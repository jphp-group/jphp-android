<?php

namespace php\android\widget;

use php\android\app\Activity;
use php\android\view\View;

class ImageView extends View
{
    /**
     * ImageView constructor.
     * @param Activity $activity
     */
    public function __construct(Context $activity) {}

    /**
     * CENTER, CENTER_CROP, CENTER_INSIDE, FIT_CENTER, FIT_END, FIT_START, FIT_XY, MATRIX
     *
     * @var string
     */
    public $scaleType;

    /**
     * @var int
     */
    public $maxWidth;

    /**
     * @var int
     */
    public $maxHeight;
}