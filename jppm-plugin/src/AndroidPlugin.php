<?php

use packager\Event;
use packager\Package;
use packager\cli\Console;
use php\format\YamlProcessor;
use php\io\File;
use php\io\IOException;
use php\io\Stream;
use php\lang\IllegalArgumentException;
use php\lang\IllegalStateException;
use php\lang\Process;
use php\lib\fs;
use php\lib\str;
use compress\ZipArchive;
use compress\ZipArchiveEntry;

/**
 * Class AndroidPlugin
 *
 * @jppm-task init as android:init
 * @jppm-task compile as android:compile
 * @jppm-task compile_install as android:compile:adb
 * @jppm-task run as android:run
 *
 * @jppm-task compile as build
 */
class AndroidPlugin {

    // paths
    public const JPHP_COMPILER_PATH = "./.jpfa/compiler.jar";
    public const JPHP_COMPILER_RESOURCE = "res://jpfa/jphp-compiler.jar";
    public const JPHP_BUILD_TEMPLATE_JAVAFX = "res://gradle-build-scripts/javafx.template.groovy";
    public const JPHP_BUILD_TEMPLATE_NATIVE = "res://gradle-build-scripts/native.template.groovy";
    public const GRADLE_WRAPPER_DIR = "./gradle/wrapper";
    public const GRADLE_WRAPPER_JAR_FILE = "./gradle/wrapper/gradle-wrapper.jar";
    public const GRADLE_WRAPPER_JAR_RESOURCE = "res://gradle/wrapper/gradle-wrapper.jar";
    public const GRADLE_WRAPPER_PROP_FILE = "./gradle/wrapper/gradle-wrapper.properties";
    public const GRADLE_WRAPPER_PROP_RESOURCE = "res://gradle/wrapper/gradle-wrapper.properties";
    public const GRADLEW_UNIX_FILE = "./gradlew";
    public const GRADLEW_UNIX_RESOURCE = "res://gradle/gradlew";
    public const GRADLEW_WIN_FILE = "./gradlew.bat";
    public const GRADLEW_WIN_RESOURCE = "res://gradle/gradlew.bat";
    public const ANDROID_JAVAFX_RESOURCES = "res://javafx-android-res.zip";
    public const ANDROID_NATIVE_RESOURCES = "res://native-android-res.zip";

    // messages
    public const ANDROID_SDK_READ = "Android SDK Version";
    public const ANDROID_SDK_TOOLS_READ = "Android SDK Tools Version";
    public const ANDROID_UI_READ = "Select android UI [javafx, native]";
    public const PROJECT_NAME_READ = "Android application name";
    public const PROJECT_ID_READ = "Android application ID";

    public const JPHP_COMPILER_MAIN_CLASS = "org.venity.compiler.Main";

    /**
     * Init android project
     *
     * @param Event $event
     * @throws IOException
     * @throws \php\format\ProcessorException
     */
    public function init(Event $event) {
        $this->check_environment();
        $this->gradle_init();
        $this->prepare_compiler();

        // build config
        $config = [
            "sdk" => $_ENV["JPHP_ANDROID_SDK"] ?: Console::read(AndroidPlugin::ANDROID_SDK_READ, 28),
            "sdk-tools" => $_ENV["JPHP_ANDROID_SDK_TOOLS"] ?:
                Console::read(AndroidPlugin::ANDROID_SDK_TOOLS_READ, "29.0.0"),
            "id" => $_ENV["JPHP_ANDROID_APPLICATION_ID"] ?:
                Console::read(AndroidPlugin::PROJECT_ID_READ, "org.develnext.jphp.android"),
            "ui" => $_ENV["JPHP_ANDROID_UI"] ?:
                Console::read(AndroidPlugin::ANDROID_UI_READ, "javafx")
        ];

        // save config to package.php.yml
        $yaml = fs::parseAs("./" . Package::FILENAME, "yaml");
        $yaml["android"] = $config;
        fs::formatAs("./" . Package::FILENAME, $yaml, "yaml", YamlProcessor::SERIALIZE_PRETTY_FLOW);

        if ($config["ui"] == "javafx") {
            Tasks::run("add", [ "jphp-android-javafx-ui-ext" ], null);
        } elseif ($config["ui"] == "native") {
            Tasks::run("add", [ "jphp-android-native-ui-ext" ], null);
        } else {
            Console::error("Unsupported UI type " . $config["ui"] . ", supported UIs: [javafx, native]");
            exit(102);
        }

        $config["name"] = $event->package()->getName();
        $config["version-name"] = $event->package()->getVersion('last');
        $config["version-code"] = intval($event->package()->getVersion('1'));

        if ($config["ui"] == "javafx") {
            $zip = new ZipArchive(Stream::of(AndroidPlugin::ANDROID_JAVAFX_RESOURCES));
            $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) use ($config) {
                if (!$entry->isDirectory()) {
                    $filePath = fs::abs('./android/' . $entry->name);
                    fs::makeFile($filePath);
                    fs::copy($stream, $filePath);
                    if (fs::ext($filePath) != "xml") return;

                    foreach ($config as $key => $val)
                        Stream::putContents($filePath, str::replace(Stream::getContents($filePath), "%{$key}%", $val));
                } else fs::makeDir(fs::abs('./android/' . $entry->name));
            });
        } elseif ($config["ui"] == "native") {
            // save config to package.php.yml
            $yaml = fs::parseAs("./" . Package::FILENAME, "yaml");
            $yaml["sources"] = [
                "src-php"
            ];
            fs::formatAs("./" . Package::FILENAME, $yaml, "yaml", YamlProcessor::SERIALIZE_PRETTY_FLOW);

            Tasks::cleanDir("./src/");
            // dirs
            fs::makeDir("./src-php/");

            fs::makeDir("./src/");
            fs::makeDir("./src/main/");
            fs::makeDir("./src/main/res");

            $zip = new ZipArchive(Stream::of(AndroidPlugin::ANDROID_NATIVE_RESOURCES));
            $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) use ($config) {
                if (!$entry->isDirectory()) {
                    $filePath = fs::abs('./src/main/' . $entry->name);
                    fs::makeFile($filePath);
                    fs::copy($stream, $filePath);
                    if (fs::ext($filePath) != "xml") return;

                    foreach ($config as $key => $val)
                        Stream::putContents($filePath, str::replace(Stream::getContents($filePath), "%{$key}%", $val));
                } else fs::makeDir(fs::abs('./src/main/' . $entry->name));
            });
        } else {
            Console::error("Unsupported UI type");
            exit(-1);
        }
    }

    /**
     * @param Event $event
     * @param string $task
     *
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     * @throws \php\format\ProcessorException
     */
    public function exec_gradle_task(Event $event, string $task) {
        $this->check_environment();
        $this->gradle_init();
        $this->prepare_compiler();
        $this->generate_gradle_build($event);

        Tasks::run("app:build", [], null);

        $buildFileName = "{$event->package()->getName()}-{$event->package()->getVersion('last')}";
        Console::log('-> unpack jar');
        fs::makeDir('./build/out');

        $zip = new ZipArchive(fs::abs('./build/' . $buildFileName . '.jar'));
        $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) {
            if (!$entry->isDirectory()) {
                fs::makeFile(fs::abs('./build/out/' . $entry->name));
                fs::copy($stream, fs::abs('./build/out/' . $entry->name));
            } else fs::makeDir(fs::abs('./build/out/' . $entry->name));
        });
        echo "  -> done\n";

        Console::log('-> starting compiler ...');

        $classPath = fs::parseAs("./vendor/paths.json", "json")["classPaths"][""];
        foreach ($classPath as $key => $path)
            $classPath[$key] = fs::normalize(fs::abs("./vendor/") . $path);

        $classPath = str::join($classPath, File::PATH_SEPARATOR) . File::PATH_SEPARATOR . AndroidPlugin::JPHP_COMPILER_PATH;

        $yaml = fs::parseAs("./" . Package::FILENAME, "yaml");

        $classPath .= File::PATH_SEPARATOR . $_ENV["ANDROID_HOME"] . "/platforms/android-" . $yaml["android"]["sdk"] . "/android.jar";

        $process = new Process([
            'java', '-cp', $classPath,
            AndroidPlugin::JPHP_COMPILER_MAIN_CLASS,
            '--src', './build/out',
            '--dest', './libs/compile.jar'
        ], './');

        $exit = $process->inheritIO()->startAndWait()->getExitValue();

        if ($exit != 0) {
            Console::log("[ERROR] Error compiling jPHP");
            exit($exit);
        } else Console::log(" -> done");

        Console::log('-> starting gradle ...');

        /** @var Process $process */
        $process = (new GradlePlugin($event))->gradleProcess([
            $task
        ])->inheritIO()->startAndWait();

        exit($process->getExitValue());
    }

    /**
     * Compile project
     *
     * @param Event $event
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     * @throws \php\format\ProcessorException
     */
    public function compile(Event $event) {
        if ($event->package()->getAny('android.ui', "") == "javafx")
            $this->exec_gradle_task($event, "android");
        elseif ($event->package()->getAny('android.ui', "") == "native")
            $this->exec_gradle_task($event, "packageDebug");
        else {
            Console::error("Unable to compile unknown UI type");
            exit(103);
        }
    }

    /**
     * Compile and install project
     *
     * @param Event $event
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     * @throws \php\format\ProcessorException
     */
    public function compile_install(Event $event) {
        if ($event->package()->getAny('android.ui', "") == "javafx")
            $this->exec_gradle_task($event, "androidInstall");
        elseif ($event->package()->getAny('android.ui', "") == "native") {
            $this->exec_gradle_task($event, "installDebug");
        } else {
            Console::error("Unable to compile unknown UI type");
            exit(103);
        }
    }

    /**
     * Run project on desktop
     *
     * @jppm-dependency-of start
     *
     * @param Event $event
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     * @throws \php\format\ProcessorException
     */
    public function run(Event $event) {
        if ($event->package()->getAny('android.ui', "") == "javafx")
            $this->exec_gradle_task($event, "run");
        elseif ($event->package()->getAny('android.ui', "") == "native")
            // Soon ...
            Console::error("Running native UI type is soon ...");
        else {
            Console::error("Unable to run unknown UI type");
            exit(103);
        }

        exit(0);
    }

    protected function prepare_compiler() {
        if (!fs::exists(AndroidPlugin::JPHP_COMPILER_PATH)) {
            Console::log("-> prepare jPHP compiler ...");

            fs::makeDir("./.jpfa/");
            Tasks::createFile(AndroidPlugin::JPHP_COMPILER_PATH,
                fs::get(AndroidPlugin::JPHP_COMPILER_RESOURCE));
        }
    }

    protected function check_environment() {
        if (!$_ENV["ANDROID_HOME"]) {
            Console::error("Environment variable ANDROID_HOME is not set");
            exit(101);
        }
    }

    protected function gradle_init() {
        Console::log('-> install gradle ...');

        Tasks::createDir(AndroidPlugin::GRADLE_WRAPPER_DIR);
        Tasks::createFile(AndroidPlugin::GRADLEW_UNIX_FILE,
            str::replace(fs::get(AndroidPlugin::GRADLEW_UNIX_RESOURCE), "\r\n", "\n"));
        Tasks::createFile(AndroidPlugin::GRADLEW_WIN_FILE,
            fs::get(AndroidPlugin::GRADLEW_WIN_RESOURCE));

        (new File(AndroidPlugin::GRADLEW_UNIX_FILE))
            ->setExecutable(true);

        fs::copy(AndroidPlugin::GRADLE_WRAPPER_JAR_RESOURCE, AndroidPlugin::GRADLE_WRAPPER_JAR_FILE);
        fs::copy(AndroidPlugin::GRADLE_WRAPPER_PROP_RESOURCE, AndroidPlugin::GRADLE_WRAPPER_PROP_FILE);
    }

    protected function generate_gradle_build(Event $event) {
        Console::log('-> prepare build.gradle ...');

        Tasks::createFile("./build.gradle");
        $template = Stream::getContents($event->package()->getAny('android.ui', "javafx") == "javafx" ?
            AndroidPlugin::JPHP_BUILD_TEMPLATE_JAVAFX : AndroidPlugin::JPHP_BUILD_TEMPLATE_NATIVE);

        $config = $event->package()->getAny('android', []);
        $config["sdk-path"] = str::replace($_ENV["ANDROID_HOME"], "\\", "\\\\");

        foreach ($config as $key => $value)
            $template = str::replace($template, "%$key%", $value);

        Stream::putContents("./build.gradle", $template);
    }
}
