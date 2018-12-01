<?php

use packager\Event;
use packager\cli\Console;
use php\lib\fs;

/**
 * @jppm-task compiler-build
 */
function task_compiler_build(Event $e)
{
    
    Tasks::run("build", [], null);
    fs::move("./build/compiler.jar", "../jppm-android-plugin/src/jphp/compiler.jar");
}