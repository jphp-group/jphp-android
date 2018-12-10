<?php

namespace php\android\app;

use php\android\content\Context;
use php\android\view\View;

class Activity extends Context
{
    public function onCreate() {
        // stub
    }

    /**
     * @param string $title
     */
    public function setTitle(string $title) {

    }

    /**
     * @param View $view
     */
    public function setContentView(View $view) {

    }

    /**
     * @param int $id
     */
    public function setContentViewById(int $id) {

    }

    /**
     * @param int $id
     * @return View
     */
    public function findById(int $id) : View {

    }

    /**
     * --RU--
     * При создании Activity
     *
     * --EN--
     * On Activity create
     *
     * --JP--
     * Activity 作成時
     *
     * @param callable $callback
     */
    public function setOnCreate(callable $callback) {

    }
}