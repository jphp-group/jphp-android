<?php


namespace php\gui\layout;


use php\gui\UXNode;

class UXBorderPane extends UXPane
{
    /**
     * UXBorderPane constructor.
     */
    public function __construct() {
    }

    /**
     * @var UXNode
     */
    public $top;

    /**
     * @var UXNode
     */
    public $right;

    /**
     * @var UXNode
     */
    public $left;

    /**
     * @var UXNode
     */
    public $bottom;

    /**
     * @var UXNode
     */
    public $center;

}