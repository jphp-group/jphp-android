<?php

namespace php\android\widget;


use php\android\view\ViewGroup;

class GridLayout extends ViewGroup
{
    public const HORIZONTAL = 0;
    public const VERTICAL = 1;
    public const UNDEFINED = -2147483648;
    public const ALIGN_BOUNDS = 0;
    public const ALIGN_MARGINS = 1;

    /**
     * @var int
     */
    public $rowCount;

    /**
     * @var int
     */
    public $orientation;

    /**
     * @var int
     */
    public $alignmentMode;

    /**
     * @var bool
     */
    public $useDefaultMargins;

    /**
     * @var bool
     */
    public $rowOrderPreserved;

    /**
     * @var bool
     */
    public $columnOrderPreserved;
}