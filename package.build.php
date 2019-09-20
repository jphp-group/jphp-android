<?php

use packager\Event;

/**
 * @param Event $event
 * @jppm-task build
 * @jppm-description Build all project modules
 */
function task_build(Event $event) {
    foreach ($event->package()->getAny('modules', []) as $i => $module) {
        Tasks::runExternal("./$module", 'publish', [], "yes");
    }

    foreach ($event->package()->getAny('plugins', []) as $i => $plugin) {
        Tasks::runExternal("./plugins/$plugin", 'publish', [], "yes");
    }

    foreach ($event->package()->getAny('extensions', []) as $i => $extension) {
        Tasks::runExternal("./extensions/$extension", 'publish', [], "yes");
    }

    foreach ($event->package()->getAny('templates', []) as $i => $template) {
        Tasks::runExternal("./templates/$template", 'publish', [], "yes");
    }
}
