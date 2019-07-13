<?php

use packager\Event;

/**
 * @param Event $event
 * @jppm-task build
 * @jppm-description Build all project modules
 */
function task_build(Event $event) {
    foreach ($event->package()->getAny('modules', []) as $i => $module) {
        Tasks::runExternal("./$module", 'module:build');
    }
}