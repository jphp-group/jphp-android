<?php

namespace php\android;

use php\gui\UXControl;
use php\gui\UXNode;

class UXBottomNavigationButton extends UXControl
{

    /**
     * UXBottomNavigationButton constructor.
     */
    public function __construct() {

    }

    /**
     * @param callable $callback
     */
    public function setOnAction(callable $callback) {

    }

    /**
     * @var UXNode
     */
    public $graphic;

    /**
     * @var string
     */
    public $text;

}