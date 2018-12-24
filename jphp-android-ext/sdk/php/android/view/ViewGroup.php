<?php

namespace php\android\view;


abstract class ViewGroup extends View
{
    public const FOCUS_BEFORE_DESCENDANTS = 131072;
    public const FOCUS_AFTER_DESCENDANTS = 262144;
    public const FOCUS_BLOCK_DESCENDANTS = 393216;
    public const PERSISTENT_NO_CACHE = 0;
    public const PERSISTENT_ANIMATION_CACHE = 1;
    public const PERSISTENT_SCROLLING_CACHE = 2;
    public const PERSISTENT_ALL_CACHES = 3;

    /**
     * @var int
     */
    public $descendantFocusability;

    /**
     * @param View $view
     * @param int $indexOrWidth
     * @param int $height
     */
    public function addView(View $view, int $indexOrWidth = null, int $height = null) {

    }

    /**
     * @param View $view
     */
    public function removeView(View $view) {

    }

    /**
     * @param int $index
     */
    public function removeViewAt(int $index) {

    }

    /**
     * @param int $start
     * @param int $count
     */
    public function removeViews(int $start, int $count) {

    }

    /**
     * @param int $start
     * @param int $count
     */
    public function removeViewsInLayout(int $start, int $count) {

    }

    public function removeAllViews() {

    }

    public function removeAllViewsInLayout() {

    }

    /**
     * @param View $child
     * @return int
     */
    public function indexOfChild(View $child): int {

    }

    /**
     * @return int
     */
    public function getChildCount(): int {

    }

    /**
     * @param int $index
     * @return View
     */
    public function getChildAt(int $index): View {

    }
}