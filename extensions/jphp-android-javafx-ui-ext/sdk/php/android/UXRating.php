<?php

namespace php\android;


use php\gui\UXControl;

class UXRating extends UXControl
{
    /**
     * UXRating constructor.
     */
    public function __construct() {

    }

    /**
     * @var string
     */
    public $orientation;

    /**
     * @var int
     */
    public $max;

    /**
     * @var int
     */
    public $rating;

    /**
     * @var bool
     */
    public $partialRating;

    /**
     * @var bool
     */
    public $updateOnHover;
}