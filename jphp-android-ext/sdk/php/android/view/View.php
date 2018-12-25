<?php

namespace php\android\view;

use php\android\content\Context;

class View
{
    public const NO_ID = -1;
    public const VISIBLE = 0;
    public const INVISIBLE = 4;
    public const GONE = 8;
    public const DRAWING_CACHE_QUALITY_LOW = 524288;
    public const DRAWING_CACHE_QUALITY_HIGH = 1048576;
    public const DRAWING_CACHE_QUALITY_AUTO = 0;
    public const SCROLLBARS_INSIDE_OVERLAY = 0;
    public const SCROLLBARS_INSIDE_INSET = 16777216;
    public const SCROLLBARS_OUTSIDE_OVERLAY = 33554432;
    public const SCROLLBARS_OUTSIDE_INSET = 50331648;
    public const KEEP_SCREEN_ON = 67108864;
    public const SOUND_EFFECTS_ENABLED = 134217728;
    public const HAPTIC_FEEDBACK_ENABLED = 268435456;
    public const FOCUSABLES_ALL = 0;
    public const FOCUSABLES_TOUCH_MODE = 1;
    public const FOCUS_BACKWARD = 1;
    public const FOCUS_FORWARD = 2;
    public const FOCUS_LEFT = 17;
    public const FOCUS_UP = 33;
    public const FOCUS_RIGHT = 66;
    public const FOCUS_DOWN = 130;
    public const MEASURED_SIZE_MASK = 16777215;
    public const MEASURED_STATE_MASK = -16777216;
    public const MEASURED_HEIGHT_STATE_SHIFT = 16;
    public const MEASURED_STATE_TOO_SMALL = 16777216;
    
    public const TEXT_ALIGNMENT_INHERIT = 0;
    public const TEXT_ALIGNMENT_RESOLVED_DEFAULT = 131072;
    public const IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public const IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public const IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public const OVER_SCROLL_ALWAYS = 0;
    public const OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public const OVER_SCROLL_NEVER = 2;
    public const SYSTEM_UI_FLAG_VISIBLE = 0;
    public const SYSTEM_UI_FLAG_LOW_PROFILE = 1;
    public const SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
    public const SYSTEM_UI_FLAG_FULLSCREEN = 4;
    public const SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
    public const SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
    public const SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;
    
    public const SYSTEM_UI_LAYOUT_FLAGS = 1536;
    public const FIND_VIEWS_WITH_TEXT = 1;
    public const FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
    public const SCREEN_STATE_OFF = 0;
    public const SCREEN_STATE_ON = 1;
    public const SCROLLBAR_POSITION_DEFAULT = 0;
    public const SCROLLBAR_POSITION_LEFT = 1;
    public const SCROLLBAR_POSITION_RIGHT = 2;
    public const LAYER_TYPE_NONE = 0;
    public const LAYER_TYPE_SOFTWARE = 1;
    public const LAYER_TYPE_HARDWARE = 2;
    
    public function __construct(Context $activity)
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
     * @return int
     */
    public function getVerticalFadingEdgeLength(): int {

    }

    /**
     * @return int
     */
    public function getHorizontalFadingEdgeLength(): int {

    }

    /**
     * @return int
     */
    public function getVerticalScrollbarWidth(): int {

    }

    /**
     * @param int $length
     */
    public function setFadingEdgeLength(int $length) {

    }

    /**
     * @return bool
     */
    public function showContextMenu(): bool {

    }

    /**
     * @return bool
     */
    public function hasFocus(): bool {

    }

    /**
     * @return bool
     */
    public function hasFocusable(): bool {

    }

    /**
     * @return bool
     */
    public function isFocused(): bool {

    }

    /**
     * @return bool
     */
    public function isShown(): bool {

    }

    /**
     * @return bool
     */
    public function hasTransientState(): bool {

    }

    /**
     * @return bool
     */
    public function willNotDraw(): bool {

    }

    /**
     * @param View $focused
     * @param int $direction
     * @return bool
     */
    public function dispatchUnhandledMove(View $focused, int $direction): bool {

    }

    /**
     * @param int|null $direction
     * @return bool
     */
    public function requestFocus(int $direction = null): bool {

    }

    /**
     * @return bool
     */
    public function requestFocusFromTouch(): bool {

    }

    /**
     * @return View
     */
    public function findFocus(): View {

    }

    public function requestFitSystemWindows(): void {

    }

    /**
     * @param bool $focusable
     */
    public function setFocusable(bool $focusable): void {

    }

    /**
     * @param bool $focusableInTouchMode
     */
    public function setFocusableInTouchMode(bool $focusableInTouchMode): void {

    }

    /**
     * @param bool $hasTransientState
     */
    public function setHasTransientState(bool $hasTransientState): void {

    }

    /**
     * @param bool $willNotDraw
     */
    public function setWillNotDraw(bool $willNotDraw): void {

    }

    /**
     * @param bool $willNotCacheDrawing
     */
    public function setWillNotCacheDrawing(bool $willNotCacheDrawing): void {

    }

    /**
     * @param View[] $views
     * @param int $direction
     * @param int|null $focusableMode
     */
    public function addFocusables(array $views, int $direction, int $focusableMode = null): void {

    }

    /**
     * @param View[] $outViews
     * @param string $searched
     * @param int $flags
     */
    public function findViewsWithText(array $outViews, string $searched, int $flags): void {

    }

    /**
     * @param array $views
     */
    public function addTouchables(array $views): void {

    }

    /**
     * @return View[]
     */
    public function getTouchables(): array {

    }

    /**
     * @param int $direction
     * @return View
     */
    public function focusSearch(int $direction): View {

    }

    /**
     * @param int $direction
     * @return View[]
     */
    public function getFocusables(int $direction): array {

    }

    /**
      * @param int $left
      * @param int $top
      * @param int $right
      * @param int $bottom
      */
    public function setPadding(int $left, int $top, int $right, int $bottom) {

    }

    /**
     * @param int $color
     */
    public function void setBackgroundColor(int $color) {

    }

    /**
     * @param int $resid
     */
    public function void setBackgroundResource(int $resid) {

    }

    /**
     * @return View
     */
    public function void getRootView(): View {

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

    /**
     * @var int
     */
    public $verticalScrollbarPosition;

    /**
     * @var int
     */
    public $drawingCacheQuality;

    /**
     * @var int
     */
    public $nextFocusLeftId;

    /**
     * @var int
     */
    public $nextFocusRightId;

    /**
     * @var int
     */
    public $nextFocusUpId;

    /**
     * @var int
     */
    public $nextFocusDownId;

    /**
     * @var int
     */
    public $nextFocusForwardId;

    /**
     * @var int
     */
    public $visibility;

    /**
     * @var int
     */
    public $importantForAccessibility;

    /**
     * @var string
     */
    public $contentDescription;

    /**
     * @var bool
     */
    public $scrollContainer;

    /**
     * @var bool
     */
    public $keepScreenOn;

    /**
     * @var bool
     */
    public $fitsSystemWindows;

    /**
     * @var bool
     */
    public $enabled;

    /**
     * @var bool
     */
    public $soundEffectsEnabled;

    /**
     * @var bool
     */
    public $hapticFeedbackEnabled;

    /**
     * @var bool
     */
    public $clickable;

    /**
     * @var bool
     */
    public $longClickable;

    /**
     * @var bool
     */
    public $pressed;

    /**
     * @var bool
     */
    public $saveEnabled;

    /**
     * @var bool
     */
    public $filterTouchesWhenObscured;

    /**
     * @var bool
     */
    public $saveFromParentEnabled;

    /**
     * @var int
     */
    public $alpha;

    /**
     * @var bool
     */
    public $selected;

    /**
     * @var bool
     */
    public $activated;
}