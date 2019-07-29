<?php

namespace php\android;

use php\gui\UXControl;
use php\gui\UXNode;

class UXNavigationDrawerItem extends UXControl {

    /**
     * UXNavigationDrawerItem constructor.
     * @param string $title
     * @param UXNode|null $graphic
     */
    public function __construct(string $title, UXNode $graphic = null) {
        parent::__construct();
    }

    /**
     * @var string
     */
    public $title;

    /**
     * @var boolean
     */
    public $selected;

    /**
     * @var boolean
     */
    public $autoClose;

    /**
     * @var UXNode
     */
    public $graphic;
}