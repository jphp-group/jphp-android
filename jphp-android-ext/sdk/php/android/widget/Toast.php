<?php

namespace php\android\widget;

use php\android\view\View;

class Toast
{
    public static const SHORT = 0;
    public static const LONG  = 1;

    /**
     * Toast constructor.
     */
    public function __construct(){

    }

    public function show() {

    }

    public function cancel() {

    }

    /**
     * @param string $text
     */
    public function setText(string $text) {

    }

    /**
     * @var int
     */
    public $duration;

    /**
     * @var View
     */
    public $view;

    /**
     * @param string $text
     * @param int $duration
     * @return Toast
     */
    public static function make(string $text, int $duration) : Toast {

    }
}