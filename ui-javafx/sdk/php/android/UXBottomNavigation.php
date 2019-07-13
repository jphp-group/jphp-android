<?php

namespace php\android;


use php\gui\UXControl;
use php\gui\UXList;

class UXBottomNavigation extends UXControl
{

    public function __construct($type = null)
    {

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