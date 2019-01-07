# View

- **class** `View` (`php\android\view\View`)
- **source** `php/android/view/View.php`

**Child Classes**

> [ViewGroup](classes/php/android/view/ViewGroup.md), [TextView](classes/php/android/widget/TextView.md), [CheckBox](classes/php/android/widget/CheckBox.md), [ImageView](classes/php/android/widget/ImageView.md)

---

#### Properties

- `->`[`id`](#prop-id) : `int`
- `->`[`top`](#prop-top) : `int`
- `->`[`bottom`](#prop-bottom) : `int`
- `->`[`left`](#prop-left) : `int`
- `->`[`right`](#prop-right) : `int`
- `->`[`rotation`](#prop-rotation) : `float`
- `->`[`verticalScrollbarPosition`](#prop-verticalscrollbarposition) : `int`
- `->`[`drawingCacheQuality`](#prop-drawingcachequality) : `int`
- `->`[`nextFocusLeftId`](#prop-nextfocusleftid) : `int`
- `->`[`nextFocusRightId`](#prop-nextfocusrightid) : `int`
- `->`[`nextFocusUpId`](#prop-nextfocusupid) : `int`
- `->`[`nextFocusDownId`](#prop-nextfocusdownid) : `int`
- `->`[`nextFocusForwardId`](#prop-nextfocusforwardid) : `int`
- `->`[`visibility`](#prop-visibility) : `int`
- `->`[`importantForAccessibility`](#prop-importantforaccessibility) : `int`
- `->`[`contentDescription`](#prop-contentdescription) : `string`
- `->`[`scrollContainer`](#prop-scrollcontainer) : `bool`
- `->`[`keepScreenOn`](#prop-keepscreenon) : `bool`
- `->`[`fitsSystemWindows`](#prop-fitssystemwindows) : `bool`
- `->`[`enabled`](#prop-enabled) : `bool`
- `->`[`soundEffectsEnabled`](#prop-soundeffectsenabled) : `bool`
- `->`[`hapticFeedbackEnabled`](#prop-hapticfeedbackenabled) : `bool`
- `->`[`clickable`](#prop-clickable) : `bool`
- `->`[`longClickable`](#prop-longclickable) : `bool`
- `->`[`pressed`](#prop-pressed) : `bool`
- `->`[`saveEnabled`](#prop-saveenabled) : `bool`
- `->`[`filterTouchesWhenObscured`](#prop-filtertoucheswhenobscured) : `bool`
- `->`[`saveFromParentEnabled`](#prop-savefromparentenabled) : `bool`
- `->`[`alpha`](#prop-alpha) : `int`
- `->`[`selected`](#prop-selected) : `bool`
- `->`[`activated`](#prop-activated) : `bool`

---

#### Methods

- `->`[`__construct()`](#method-__construct)
- `->`[`on()`](#method-on)
- `->`[`off()`](#method-off)
- `->`[`trigger()`](#method-trigger)
- `->`[`getVerticalFadingEdgeLength()`](#method-getverticalfadingedgelength)
- `->`[`getHorizontalFadingEdgeLength()`](#method-gethorizontalfadingedgelength)
- `->`[`getVerticalScrollbarWidth()`](#method-getverticalscrollbarwidth)
- `->`[`setFadingEdgeLength()`](#method-setfadingedgelength)
- `->`[`showContextMenu()`](#method-showcontextmenu)
- `->`[`hasFocus()`](#method-hasfocus)
- `->`[`hasFocusable()`](#method-hasfocusable)
- `->`[`isFocused()`](#method-isfocused)
- `->`[`isShown()`](#method-isshown)
- `->`[`hasTransientState()`](#method-hastransientstate)
- `->`[`willNotDraw()`](#method-willnotdraw)
- `->`[`dispatchUnhandledMove()`](#method-dispatchunhandledmove)
- `->`[`requestFocus()`](#method-requestfocus)
- `->`[`requestFocusFromTouch()`](#method-requestfocusfromtouch)
- `->`[`findFocus()`](#method-findfocus)
- `->`[`requestFitSystemWindows()`](#method-requestfitsystemwindows)
- `->`[`setFocusable()`](#method-setfocusable)
- `->`[`setFocusableInTouchMode()`](#method-setfocusableintouchmode)
- `->`[`setHasTransientState()`](#method-sethastransientstate)
- `->`[`setWillNotDraw()`](#method-setwillnotdraw)
- `->`[`setWillNotCacheDrawing()`](#method-setwillnotcachedrawing)
- `->`[`addFocusables()`](#method-addfocusables)
- `->`[`findViewsWithText()`](#method-findviewswithtext)
- `->`[`addTouchables()`](#method-addtouchables)
- `->`[`getTouchables()`](#method-gettouchables)
- `->`[`focusSearch()`](#method-focussearch)
- `->`[`getFocusables()`](#method-getfocusables)
- `->`[`setPadding()`](#method-setpadding)
- `->`[`setBackgroundColor()`](#method-setbackgroundcolor)
- `->`[`setBackgroundResource()`](#method-setbackgroundresource)
- `->`[`getRootView()`](#method-getrootview)

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(php\android\content\Context $activity): void
```

---

<a name="method-on"></a>

### on()
```php
on(string $event, callable $callback): void
```

---

<a name="method-off"></a>

### off()
```php
off(string $event): void
```

---

<a name="method-trigger"></a>

### trigger()
```php
trigger(string $event): void
```

---

<a name="method-getverticalfadingedgelength"></a>

### getVerticalFadingEdgeLength()
```php
getVerticalFadingEdgeLength(): int
```

---

<a name="method-gethorizontalfadingedgelength"></a>

### getHorizontalFadingEdgeLength()
```php
getHorizontalFadingEdgeLength(): int
```

---

<a name="method-getverticalscrollbarwidth"></a>

### getVerticalScrollbarWidth()
```php
getVerticalScrollbarWidth(): int
```

---

<a name="method-setfadingedgelength"></a>

### setFadingEdgeLength()
```php
setFadingEdgeLength(int $length): void
```

---

<a name="method-showcontextmenu"></a>

### showContextMenu()
```php
showContextMenu(): bool
```

---

<a name="method-hasfocus"></a>

### hasFocus()
```php
hasFocus(): bool
```

---

<a name="method-hasfocusable"></a>

### hasFocusable()
```php
hasFocusable(): bool
```

---

<a name="method-isfocused"></a>

### isFocused()
```php
isFocused(): bool
```

---

<a name="method-isshown"></a>

### isShown()
```php
isShown(): bool
```

---

<a name="method-hastransientstate"></a>

### hasTransientState()
```php
hasTransientState(): bool
```

---

<a name="method-willnotdraw"></a>

### willNotDraw()
```php
willNotDraw(): bool
```

---

<a name="method-dispatchunhandledmove"></a>

### dispatchUnhandledMove()
```php
dispatchUnhandledMove(php\android\view\View $focused, int $direction): bool
```

---

<a name="method-requestfocus"></a>

### requestFocus()
```php
requestFocus(int|null $direction): bool
```

---

<a name="method-requestfocusfromtouch"></a>

### requestFocusFromTouch()
```php
requestFocusFromTouch(): bool
```

---

<a name="method-findfocus"></a>

### findFocus()
```php
findFocus(): php\android\view\View
```

---

<a name="method-requestfitsystemwindows"></a>

### requestFitSystemWindows()
```php
requestFitSystemWindows(): void
```

---

<a name="method-setfocusable"></a>

### setFocusable()
```php
setFocusable(bool $focusable): void
```

---

<a name="method-setfocusableintouchmode"></a>

### setFocusableInTouchMode()
```php
setFocusableInTouchMode(bool $focusableInTouchMode): void
```

---

<a name="method-sethastransientstate"></a>

### setHasTransientState()
```php
setHasTransientState(bool $hasTransientState): void
```

---

<a name="method-setwillnotdraw"></a>

### setWillNotDraw()
```php
setWillNotDraw(bool $willNotDraw): void
```

---

<a name="method-setwillnotcachedrawing"></a>

### setWillNotCacheDrawing()
```php
setWillNotCacheDrawing(bool $willNotCacheDrawing): void
```

---

<a name="method-addfocusables"></a>

### addFocusables()
```php
addFocusables(View[] $views, int $direction, int|null $focusableMode): void
```

---

<a name="method-findviewswithtext"></a>

### findViewsWithText()
```php
findViewsWithText(View[] $outViews, string $searched, int $flags): void
```

---

<a name="method-addtouchables"></a>

### addTouchables()
```php
addTouchables(array $views): void
```

---

<a name="method-gettouchables"></a>

### getTouchables()
```php
getTouchables(): View[]
```

---

<a name="method-focussearch"></a>

### focusSearch()
```php
focusSearch(int $direction): php\android\view\View
```

---

<a name="method-getfocusables"></a>

### getFocusables()
```php
getFocusables(int $direction): View[]
```

---

<a name="method-setpadding"></a>

### setPadding()
```php
setPadding(int $left, int $top, int $right, int $bottom): void
```

---

<a name="method-setbackgroundcolor"></a>

### setBackgroundColor()
```php
setBackgroundColor(int $color): void
```

---

<a name="method-setbackgroundresource"></a>

### setBackgroundResource()
```php
setBackgroundResource(int $resid): void
```

---

<a name="method-getrootview"></a>

### getRootView()
```php
getRootView(): php\android\view\View
```