<?php

use packager\Event;
use packager\cli\Console;
use php\io\Stream;

function task_build(Event $e)
{
    foreach ($e->package()->getAny("modules") as $module => $options)
    	Tasks::runExternal('./' . $module, $options["task"], [], "yes");
}

function task_hubBuild(Event $e)
{
	foreach ($e->package()->getAny("modules") as $module => $options)
	{
    	if (!$options["hub"]) continue;

    	Stream::putContents('./' . $module . "/package.hub.yml",
    		"login: " . $GLOBALS['argv'][2] . "\nauth: " . $GLOBALS['argv'][3]);
    	
    	Tasks::runExternal('./' . $module, "hub:publish", [], "f");
	}
}
