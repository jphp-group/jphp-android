<?php 

use php\android\app\Application;
use sandbox\App;

$app = new App();

Application::setMainActivityHandler([$app, "makeUI"]);