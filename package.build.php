<?php

use packager\Event;
use packager\cli\Console;

function task_build(Event $e)
{
    foreach ($e->package()->getAny("modules") as $module => $task)
    	Tasks::runExternal('./' . $module, $task, [], "yes");
}