<?php

use packager\Event;
use packager\Package;
use packager\cli\Console;
use php\io\File;
use php\io\IOException;
use php\io\Stream;
use php\lib\fs;
use php\lib\str;

/**
 * Class AndroidPlugin
 *
 * @jppm-task-prefix android
 * @jppm-task init as init
 * @jppm-task compile as compile
 */
class AndroidPlugin {

    // paths
    public const JPHP_COMPILER_PATH = "./.jpfa/compiler.jar";
    public const JPHP_COMPILER_RESOURCE = "res://jpfa/jphp-compiler.jar";
    public const GRADLE_WRAPPER_DIR = "./gradle/wrapper";
    public const GRADLE_WRAPPER_JAR_FILE = "./gradle/wrapper/gradle-wrapper.jar";
    public const GRADLE_WRAPPER_JAR_RESOURCE = "res://gradle/wrapper/gradle-wrapper.jar";
    public const GRADLE_WRAPPER_PROP_FILE = "./gradle/wrapper/gradle-wrapper.properties";
    public const GRADLE_WRAPPER_PROP_RESOURCE = "res://gradle/wrapper/gradle-wrapper.properties";
    public const GRADLEW_UNIX_FILE = "./gradlew";
    public const GRADLEW_UNIX_RESOURCE = "res://gradle/gradlew";
    public const GRADLEW_WIN_FILE = "./gradlew.bat";
    public const GRADLEW_WIN_RESOURCE = "res://gradle/gradlew.bat";

    // messages
    public const ANDROID_SDK_READ = "Android SDK Version";
    public const ANDROID_SDK_TOOLS_READ = "Android SDK Tools Version";
    public const ANDROID_UI_READ = "Select android UI [javafx, native]";
    public const PROJECT_NAME_READ = "Android application name";
    public const PROJECT_ID_READ = "Android application ID";

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
        fs::formatAs("./" . Package::FILENAME, $yaml, "yaml");

        if ($config["ui"] == "javafx") {
            Tasks::run("add", [ "jphp-android-javafx-ui-ext" ], null);
        } elseif ($config["ui"] == "native") {
            Tasks::run("add", [ "jphp-android-native-ui-ext" ], null);
        } else {
            Console::error("Unsupported UI type " . $config["ui"] . ", supported UIs: [javafx, native]");
            exit(102);
        }
    }

    public function compile(Event $event) {
        $this->check_environment();
        $this->prepare_compiler();
    }

    protected function prepare_compiler() {
        if (!fs::exists(AndroidPlugin::JPHP_COMPILER_PATH)) {
            Console::log("-> Prepare jPHP compiler ...");

            fs::move(AndroidPlugin::JPHP_COMPILER_PATH, AndroidPlugin::JPHP_COMPILER_RESOURCE);
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
}