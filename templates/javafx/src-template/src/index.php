<?php

use app\HomeView;
use php\android\UXMobileApplication;

UXMobileApplication::launch(function () {
    UXMobileApplication::addView("home", new HomeView());
    UXMobileApplication::showView("home");
});
