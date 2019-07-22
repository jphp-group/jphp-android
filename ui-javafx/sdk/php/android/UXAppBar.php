<?php

namespace php\android;

use php\gui\UXControl;
use php\gui\UXList;
use php\gui\UXNode;

class UXAppBar extends UXControl
{
    /**
     * UXAppBar constructor.
     */
    public function __construct() {

    }

    public function clear() {

    }

    /**
     * @var float
     */
    public $spacing;

    /**
     * @var float
     */
    public $progress;

    /**
     * @var UXNode
     */
    public $navIcon;

    /**
     * @var UXList
     */
    public $items;

    /**
     * @var UXNode
     */
    public $title;

}