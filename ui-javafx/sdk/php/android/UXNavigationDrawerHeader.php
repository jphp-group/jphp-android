<?php

namespace php\android;

use php\gui\UXControl;
use php\gui\UXNode;

class UXNavigationDrawerHeader extends UXControl {

    /**
     * UXNavigationDrawerHeader constructor.
     * @param string $title
     * @param string|null $subtitle
     * @param UXNode|null $graphic
     */
    public function __construct(string $title, string $subtitle = null, UXNode $graphic = null) {
        parent::__construct();
    }

    /**
     * @var string
     */
    public $title;

    /**
     * @var string
     */
    public $subtitle;

    /**
     * @var UXNode
     */
    public $graphic;

    /**
     * @param callable $callback
     */
    public function setOnAction(callable $callback) {

    }
}