# TextView

- **class** `TextView` (`php\android\widget\TextView`) **extends** [`View`](classes/php/android/view/View.md)
- **source** `php/android/widget/TextView.php`

**Child Classes**

> [EditText](classes/php/android/widget/EditText.md), [Button](classes/php/android/widget/Button.md)

---

#### Properties

- `->`[`text`](#prop-text) : `string`
- `->`[`inputType`](#prop-inputtype) : `int`
- `->`[`highlightColor`](#prop-highlightcolor) : `int`
- `->`[`gravity`](#prop-gravity) : `int`
- `->`[`paintFlags`](#prop-paintflags) : `int`
- `->`[`minLines`](#prop-minlines) : `int`
- `->`[`minHeight`](#prop-minheight) : `int`
- `->`[`maxLines`](#prop-maxlines) : `int`
- `->`[`maxHeight`](#prop-maxheight) : `int`
- `->`[`minWidth`](#prop-minwidth) : `int`
- `->`[`maxWidth`](#prop-maxwidth) : `int`
- `->`[`minEms`](#prop-minems) : `int`
- `->`[`maxEms`](#prop-maxems) : `int`
- `->`[`textSize`](#prop-textsize) : `int`
- `->`[`textScaleX`](#prop-textscalex) : `int`
- `->`[`freezesText`](#prop-freezestext) : `bool`
- `->`[`cursorVisible`](#prop-cursorvisible) : `bool`
- `->`[`hint`](#prop-hint) : `string`
- *See also in the parent class* [View](classes/php/android/view/View.md).

---

#### Methods

- `->`[`getShadowColor()`](#method-getshadowcolor)
- `->`[`getLineSpacingMultiplier()`](#method-getlinespacingmultiplier)
- `->`[`getLineSpacingExtra()`](#method-getlinespacingextra)
- `->`[`getShadowRadius()`](#method-getshadowradius)
- `->`[`getShadowDx()`](#method-getshadowdx)
- `->`[`getShadowDy()`](#method-getshadowdy)
- `->`[`append()`](#method-append)
- `->`[`setLineSpacing()`](#method-setlinespacing)
- `->`[`setShadowLayer()`](#method-setshadowlayer)
- See also in the parent class [View](classes/php/android/view/View.md)

---
# Methods

<a name="method-getshadowcolor"></a>

### getShadowColor()
```php
getShadowColor(): int
```

---

<a name="method-getlinespacingmultiplier"></a>

### getLineSpacingMultiplier()
```php
getLineSpacingMultiplier(): int
```

---

<a name="method-getlinespacingextra"></a>

### getLineSpacingExtra()
```php
getLineSpacingExtra(): int
```

---

<a name="method-getshadowradius"></a>

### getShadowRadius()
```php
getShadowRadius(): int
```

---

<a name="method-getshadowdx"></a>

### getShadowDx()
```php
getShadowDx(): int
```

---

<a name="method-getshadowdy"></a>

### getShadowDy()
```php
getShadowDy(): int
```

---

<a name="method-append"></a>

### append()
```php
append(string $text, int $start, int $end): void
```

---

<a name="method-setlinespacing"></a>

### setLineSpacing()
```php
setLineSpacing(int $add, int $mult): void
```

---

<a name="method-setshadowlayer"></a>

### setShadowLayer()
```php
setShadowLayer(int $radius, int $dx, int $dy, int $color): void
```