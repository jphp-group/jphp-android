<?php

namespace php\android;

use php\gui\UXControl;
use php\gui\UXList;
use php\gui\UXNode;

class UXNavigationDrawer extends UXControl {

    /**
     * UXNavigationDrawer constructor.
     */
    public function __construct() {
    }

    /**
     * @var UXNode
     */
    public $footer;


    /**
     * @var UXNode
     */
    public $header;

    /**
     * @var UXList
     */
    public $items;

    /**
     * @var UXNode
     */
    public $selectedItem;
}