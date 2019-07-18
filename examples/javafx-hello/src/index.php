<?php

use app\MainView;
use php\android\UXMobileApplication;

UXMobileApplication::addView("home", new MainView()); // add view
UXMobileApplication::showView("home"); // show view