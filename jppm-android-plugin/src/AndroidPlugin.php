<?php

use packager\{
    cli\Console, Event, JavaExec, Packager, Vendor
};
use php\io\Stream;
use php\lib\fs;
use compress\ZipArchive;
use compress\ZipArchiveEntry;
use php\lib\str;


/**
 * Class AndroidPlugin
 * @jppm-task-prefix android
 * @jppm-task init as init
 * @jppm-task build as build
 */
class AndroidPlugin
{
    public function init(Event $e)
    {
        if (!isset($packageData['deps']['jphp-android-ext'])) {
            Console::log('-> installing android extension ...');
            Tasks::run('add', [
                'jphp-android-ext'
            ]);
        }

        Console::log('-> install gradle ...');
        (new GradlePlugin($e))->install($e);

        Stream::putContents("./gradle/wrapper/gradle-wrapper.properties", str::join([
            "distributionBase=GRADLE_USER_HOME",
            "distributionPath=wrapper/dists",
            "zipStoreBase=GRADLE_USER_HOME",
            "zipStorePath=wrapper/dists",
            "distributionUrl=https\://services.gradle.org/distributions/gradle-4.6-bin.zip"
        ], "\n"));

        // dirs
        fs::makeDir("./resources");

        // files
        fs::makeFile("./build.gradle");
        fs::makeFile("./resources/AndroidManifest.xml");

        $settings = [
            "compileSdkVersion" => (int) Console::read("compileSdkVersion :", 28),
            "buildToolsVersion" => Console::read("buildToolsVersion :", "28.0.3"),
            "targetSdkVersion" => (int) Console::read("targetSdkVersion :", 28),
            "applicationId" => Console::read("applicationId :", "org.venity.test"),
            "versionCode" => (int) Console::read("versionCode :", 1),
            "versionName" => Console::read("versionName :", "1.0"),
        ];

        $script = Stream::getContents("res://android/build.gradle");

        foreach ($settings as $key => $val)
            $script = str::replace($script, "%{$key}%", $val);

        Stream::putContents("./build.gradle", $script);
        Stream::putContents("./resources/AndroidManifest.xml", Stream::getContents("res://android/resources/AndroidManifest.xml"));

        Console::log("-> prepare jphp compiler ...");
        fs::makeDir('./.venity/');
        fs::makeFile('./.venity/compiler.jar');

        Stream::putContents('./.venity/compiler.jar', Stream::getContents("res://jphp/compiler.jar"));
    }

    public function build(Event $event)
    {
        Console::log("-> compiling jphp ...");

        Tasks::run("app:build");

        $buildFileName = fs::abs("./build/{$event->package()->getName()}-{$event->package()->getVersion('last')}.jar");

        fs::makeDir('./build/out');

        $zip = new ZipArchive($buildFileName);
        $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) {
            if (!$entry->isDirectory()) {
                fs::makeFile(fs::abs('./build/out/' . $entry->name));
                fs::copy($stream, fs::abs('./build/out/' . $entry->name));
                echo '.';
            } else fs::makeDir(fs::abs('./build/out/' . $entry->name));
        });
        echo ". done\n";

        fs::delete($buildFileName);

        Console::log('-> starting compiler ...');
        $process = new \php\lang\Process([
            'java', '-jar', './.venity/compiler.jar',
            '--src', './build/out',
            '--dest', './libs/compile.jar'
        ], './');

        $exit = $process->redirectOutputToInherit()->startAndWait()->getExitValue();

        if ($exit != 0) {
            Console::log("[ERROR] Error compiling jphp");
            exit($exit);
        } else Console::log(" -> done");

        Tasks::cleanDir("/build/out");

        /** @var \php\lang\Process $process */
        $process = (new GradlePlugin($event))->gradleProcess([
            "build"
        ])->inheritIO()->startAndWait();

        exit($process->getExitValue());

        fs::delete("./libs/compile.jar");
    }
}