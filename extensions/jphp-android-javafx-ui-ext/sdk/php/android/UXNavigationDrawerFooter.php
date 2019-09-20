<?php


namespace php\android;

use php\gui\UXControl;
use php\gui\UXNode;

class UXNavigationDrawerFooter extends UXControl {

    /**
     * UXNavigationDrawerFooter constructor.
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
     * @var UXNode
     */
    public $graphic;
}