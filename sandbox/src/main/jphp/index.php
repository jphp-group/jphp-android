<?php

use php\android\app\Application;
use php\android\R;
use php\android\widget\TextView;
use php\android\notification\Notification;
use php\android\notification\NotificationBuilder;
use php\android\widget\ImageView;
use php\android\picasso\Picasso;

Application::setMainActivityHandler(function () {
    $activity = Application::getMainActivity();
    $activity->setContentViewById(R::layout("activity_main"));

    $textView = $activity->findById(R::id("text"));
    $textView->on("click", function (TextView $view) use ($activity) {
        Notification::notify((new NotificationBuilder($activity))
            ->setAutoCancel(true)
            ->setContentTitle("jPFA Test")
            ->setContentText("jPHP For Android Test")
            ->setSmallIcon(R::mipmap("ic_launcher"))
            ->setPriority(Notification::PRIORITY_MAX)
            ->build(), 1);
    });
});