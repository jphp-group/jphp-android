<?php

use php\android\app\Application;
use php\android\R;
use php\android\widget\TextView;

Application::setMainActivityHandler(function () {
    $activity = Application::getMainActivity();
    $activity->setContentViewById(R::layout("activity_main"));

    $textView = $activity->findById(R::id("text"));
    $textView->on("click", function (TextView $view) {
        $view->text = "Hello jPHP World!";
    });
});