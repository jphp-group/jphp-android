<?php

namespace php\android\view;


use php\android\app\Activity;

class View
{
    public function __construct(Activity $activity)
    {

    }

    /**
     * @param string $event
     * @param callable $callback
     */
    public function on(string $event, callable $callback) {

    }

    /**
     * @param string $event
     */
    public function off(string $event) {

    }

    /**
     * @param string $event
     */
    public function trigger(string $event) {

    }

    /**
     * @var int
     */
    public $id;

    /**
     * @var int
     */
    public $top;

    /**
     * @var int
     */
    public $bottom;

    /**
     * @var int
     */
    public $left;

    /**
     * @var int
     */
    public $right;

    /**
     * @var float
     */
    public $rotation;
}