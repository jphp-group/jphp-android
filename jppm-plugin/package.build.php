<?php

use packager\Event;
use packager\cli\Console;

/**
 * @jppm-task module:build
 * @jppm-description Build jppm plugin module
 */
function task_compiler_build(Event $e) {
    Tasks::run("publish", ["yes"], null);
}