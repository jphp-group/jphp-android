<?php

use packager\Event;
use packager\cli\Console;
use php\lib\fs;
use php\io\File;

const OUTPUT_JAR = "./jars/x-jphp-compiler-1.0.1.jar";
const DEST_PATH = "../plugins/jppm/src/jpfa/";
const DEST_JAR_PATH = DEST_PATH . "/jphp-compiler.jar";

/**
 * @jppm-task publish
 * @jppm-description Build jphp-compiler
 */
function task_compiler_build(Event $e) {
    Tasks::run("build", [], null);

    fs::makeDir(DEST_PATH);

    if (fs::exists(DEST_JAR_PATH)) {
        fs::delete(DEST_JAR_PATH);
    }

    fs::scan("./build/libs", function (File $file) {
        $dest = fs::abs(DEST_PATH . File::DIRECTORY_SEPARATOR . fs::name($file));
        fs::move($file, $dest);
    });

    fs::move(OUTPUT_JAR, DEST_JAR_PATH);
}
