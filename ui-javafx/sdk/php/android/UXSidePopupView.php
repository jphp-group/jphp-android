<?php

namespace php\android;


use php\gui\layout\UXPane;
use php\gui\UXNode;

class UXSidePopupView extends UXPane
{
    /**
     * UXSidePopupView constructor.
     * @param UXNode|null $node
     */
    public function __construct(UXNode $node = null) {

    }

    /**
     * @var string
     */
    public $showSide;
}