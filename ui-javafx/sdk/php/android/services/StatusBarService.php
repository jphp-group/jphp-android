<?php

namespace php\android\services;

use php\gui\paint\UXColor;

abstract class StatusBarService {

    /**
     * @return StatusBarService
     */
    public static function get() : StatusBarService {
        return null;
    }

    /**
     * @param UXColor $color
     * @return mixed
     */
    abstract public function setColor(UXColor $color);
}