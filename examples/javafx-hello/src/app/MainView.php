<?php

namespace app;

use php\android\UXAppBar;
use php\android\UXMaterialIcons;
use php\android\UXView;
use php\gui\UXButton;
use php\gui\UXLabel;

class MainView extends UXView {

    /**
     * MainView constructor.
     */
    public function __construct() {
        parent::__construct();

        $button = new UXButton("Hello, World!");
        $button->graphic = UXMaterialIcons::of("LANGUAGE")->graphic();
        $button->on("click", function () use ($button) {
            $button->text = "Change the world!";
        });

        $this->center = $button;

        $this->setOnUpdateAppBar([$this, "updateAppBar"]);
    }

    /**
     * Update top app bar
     *
     * @param UXAppBar $appBar
     */
    public function updateAppBar(UXAppBar $appBar) {
        $appBar->title   = new UXLabel("jPHP & JavaFX");
        $appBar->navIcon = UXMaterialIcons::of("MENU")->button(function () {
            // on navigation icon click ....
        });
    }
}