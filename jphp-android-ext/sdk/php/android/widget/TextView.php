<?php

namespace php\android\widget;

use php\android\view\View;

class TextView extends View
{
    /**
     * @var string
     */
    public $text;

    /**
     * @var int
     */
    public $inputType;

    /**
     * @var int
     */
    public $highlightColor;

    /**
     * @var int
     */
    public $gravity;

    /**
     * @var int
     */
    public $paintFlags;

    /**
     * @var int
     */
    public $minLines;

    /**
     * @var int
     */
    public $minHeight;

    /**
     * @var int
     */
    public $maxLines;

    /**
     * @var int
     */
    public $maxHeight;

    /**
     * @var int
     */
    public $minWidth;

    /**
     * @var int
     */
    public $maxWidth;

    /**
     * @var int
     */
    public $minEms;

    /**
     * @var int
     */
    public $maxEms;

    /**
     * @var int
     */
    public $textSize;

    /**
     * @var int
     */
    public $textScaleX;

    /**
     * @var bool
     */
    public $freezesText;

    /**
     * @var bool
     */
    public $cursorVisible;

    /**
     * @var string
     */
    public $hint;

    /**
     * @return int
     */
    public function getShadowColor(): int {

    }

    /**
     * @return int
     */
    public function getLineSpacingMultiplier(): int {

    }

    /**
     * @return int
     */
    public function getLineSpacingExtra(): int {

    }

    /**
     * @return int
     */
    public function getShadowRadius(): int {

    }

    /**
     * @return int
     */
    public function getShadowDx(): int {

    }

    /**
     * @return int
     */
    public function getShadowDy(): int {

    }

    /**
     * @param $text string
     * @param $start int
     * @param $end int
     */
    public function append(string $text, int $start, int $end): void {

    }

    /**
     * @param $add int
     * @param $mult int
     */
    public function setLineSpacing(int $add, int $mult): void {

    }

    /**
     * @param $radius int
     * @param $dx int
     * @param $dy int
     * @param $color int
     */
    public function setShadowLayer(int $radius, int $dx, int $dy, int $color): void {

    }
}