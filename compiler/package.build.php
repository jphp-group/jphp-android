<?php

use packager\Event;
use packager\cli\Console;
use php\lib\fs;

/**
 * @jppm-task publish
 * @jppm-description Build jphp-compiler
 */
function task_compiler_build(Event $e) {
    Tasks::run("build", [], null);
    fs::makeDir("../plugins/jppm/src/jpfa/");
    fs::move("./build/jphp-compiler.jar", "../plugins/jppm/src/jpfa/jphp-compiler.jar");
}
