<?php

namespace php\android;


use php\gui\UXControl;
use php\gui\UXList;

class UXBottomNavigation extends UXControl
{

    /**
     * UXBottomNavigation constructor.
     * @param string $type
     */
    public function __construct(string $type = null) {

    }

    /**
     * @var string
     */
    public $type;

    /**
     * @var UXList
     */
    public $items;
}