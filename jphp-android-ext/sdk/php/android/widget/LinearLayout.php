<?php

namespace php\android\widget;

use php\android\view\ViewGroup;

class LinearLayout extends ViewGroup
{
    /**
     * @var int
     */
    public $showDividers;

    /**
     * @var int
     */
    public $orientation;

    public const HORIZONTAL = 0;
    public const VERTICAL = 1;

    public const SHOW_DIVIDER_NONE = 0;
    public const SHOW_DIVIDER_BEGINNING = 1;
    public const SHOW_DIVIDER_MIDDLE = 2;
    public const SHOW_DIVIDER_END = 4;
}