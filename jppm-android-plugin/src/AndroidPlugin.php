<?php

use packager\{
    cli\Console, Event, JavaExec, Packager, Vendor, Package
};

use php\io\Stream;
use php\lib\fs;
use compress\ZipArchive;
use compress\ZipArchiveEntry;
use php\lib\str;
use php\lang\System;

/**
 * Class AndroidPlugin
 * @jppm-task-prefix android
 * @jppm-task init as init
 * @jppm-task compile as build
 * @jppm-task compile as compile
 * @jppm-task gradle_install as installGradle
 */
class AndroidPlugin
{
    /**
     * @param Event $e
     * @throws \php\io\IOException
     */
    public function init(Event $e)
    {
        if (!isset($packageData['deps']['jphp-android-ext'])) {
            Console::log('-> installing android extension ...');
            Tasks::run('add', [
                'jphp-android-ext'
            ]);
        }

        $this->gradle_install($e);

        Tasks::cleanDir("./src/");

        // dirs
        fs::makeDir("./src/");
        fs::makeDir("./src/main/");
        fs::makeDir("./src/main/jphp");
        fs::makeDir("./src/main/res");

        // files
        fs::makeFile("./build.gradle");
        fs::makeFile("./src/main/jphp/index.php");

        $sdk = $_ENV["android.build.sdk"] ?: Console::read("sdkVersion :", 28);

        $settings = [
            "compileSdkVersion" => $sdk,
            "buildToolsVersion" => $_ENV["android.build.tools"] ?: Console::read("buildToolsVersion :", "28.0.3"),
            "targetSdkVersion" => $sdk,
            "appName" => $_ENV["android.app.name"] ?: Console::read("App name :", "test"),
            "applicationId" => $_ENV["android.app.id"] ?: Console::read("applicationId :", "org.venity.test"),
            "versionCode" => $_ENV["android.version.code"] ?: (int) Console::read("versionCode :", 1),
            "versionName" => $_ENV["android.version.name"] ?: Console::read("versionName :", "1.0"),
        ];

        $script = Stream::getContents("res://android/build.groovy");

        Console::log("-> prepare resources ...");

        $zip = new ZipArchive(Stream::of("res://android/res.zip"));
        $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) use ($settings) {
            if (!$entry->isDirectory()) {
                $filePath = fs::abs('./src/main/' . $entry->name);
                fs::makeFile($filePath);
                fs::copy($stream, $filePath);

                if (fs::ext($filePath) != "xml") return;

                foreach ($settings as $key => $val)
                    Stream::putContents($filePath, str::replace(Stream::getContents($filePath), "%{$key}%", $val));

            } else fs::makeDir(fs::abs('./src/main/' . $entry->name));
        });

        foreach ($settings as $key => $val)
            $script = str::replace($script, "%{$key}%", $val);

        Stream::putContents("./build.gradle", $script);
        Stream::putContents("./src/main/jphp/index.php", Stream::getContents("res://android/index.php"));

        $this->prepare_compiler();

        $yaml = fs::parseAs("./" . Package::FILENAME, "yaml");
        $yaml["sources"] = [ "src/main/jphp" ];
        fs::formatAs("./" . Package::FILENAME, $yaml, "yaml");
    }

    public function prepare_compiler() {
        Console::log("-> prepare jphp compiler ...");
        fs::makeDir('./.venity/');
        fs::makeFile('./.venity/compiler.jar');
        Stream::putContents('./.venity/compiler.jar', Stream::getContents("res://jphp/compiler.jar"));
    }

    public function gradle_install(Event $e) {
        Console::log('-> install gradle ...');

        Tasks::createDir('./gradle/wrapper');
        Tasks::createFile('./gradlew', str::replace(fs::get('res://gradle/gradlew'), "\r\n", "\n"));
        Tasks::createFile('./gradlew.bat', fs::get('res://gradle/gradlew.bat'));

        (new \php\io\File('./gradlew'))->setExecutable(true);

        fs::copy('res://gradle/wrapper/gradle-wrapper.jar', './gradle/wrapper/gradle-wrapper.jar');
        fs::copy('res://gradle/wrapper/gradle-wrapper.properties', './gradle/wrapper/gradle-wrapper.properties');
    }

    /**
     * @param Event $event
     * @throws \php\lang\IllegalArgumentException
     * @throws \php\lang\IllegalStateException
     */
    public function compile(Event $event)
    {
        $this->prepare_compiler();

        Console::log("-> compiling jphp ...");

        Tasks::run("app:build");

        $buildFileName = fs::abs("./build/{$event->package()->getName()}-{$event->package()->getVersion('last')}.jar");

        fs::makeDir('./build/out');

        $zip = new ZipArchive($buildFileName);
        $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) {
            if (str::endsWith(str::upper($entry->name), "META-INF/MANIFEST.MF")) return; // fix #2

            if (!$entry->isDirectory()) {
                fs::makeFile(fs::abs('./build/out/' . $entry->name));
                fs::copy($stream, fs::abs('./build/out/' . $entry->name));
            } else fs::makeDir(fs::abs('./build/out/' . $entry->name));
        });

        fs::delete($buildFileName);

        Console::log('-> starting compiler ...');
        $process = new \php\lang\Process([
            'java', '-jar', './.venity/compiler.jar',
            '--src', './build/out',
            '--dest', './libs/compile.jar'
        ], './');

        $exit = $process->inheritIO()->startAndWait()->getExitValue();

        if ($exit != 0) exit($exit);
        else Console::log(" -> done");

        Tasks::cleanDir("./build/out");

        $gradleTask = $event->flags()[0] ?? "build";

        /** @var \php\lang\Process $process */
        $process = (new GradlePlugin($event))->gradleProcess([
            $gradleTask
        ])->inheritIO()->startAndWait();

        $exit = $process->getExitValue();

        if ($exit != 0)
            exit($exit);

        fs::delete("./libs/compile.jar");
    }
}