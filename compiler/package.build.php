<?php

use packager\Event;
use packager\cli\Console;
use php\lib\fs;

/**
 * @jppm-task module:build
 * @jppm-description Build jphp-compiler module
 */
function task_compiler_build(Event $e) {
    Tasks::run("build", [], null);
    fs::move("./build/jphp-compiler.jar", "../jppm-plugin/src/jpfa/jphp-compiler.jar");
}