<?php

namespace php\android\app;


use php\android\content\Context;

class Application
{
    /**
     * @return Activity
     */
    public static function getMainActivity(): Activity {

    }

    /**
     * @return Context
     */
    public static function getContext(): Context {

    }


    /**
     * --EN--
     * When changing the orientation, when recreating the MainActivity
     *
     * --RU--
     * При смене ориинтации, при пересоздании MainActivity
     *
     * --JP--
     * 方向を変更するとき、MainActivityを再作成するとき
     *
     * @param callable $callback
     */
    public static function setMainActivityHandler(callable $callback) {

    }
}