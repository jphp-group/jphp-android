# ViewGroup

- **class** `ViewGroup` (`php\android\view\ViewGroup`) **extends** [`View`](classes/php/android/view/View.md)
- **source** `php/android/view/ViewGroup.php`

**Child Classes**

> [GridLayout](classes/php/android/widget/GridLayout.md), [FrameLayout](classes/php/android/widget/FrameLayout.md), [LinearLayout](classes/php/android/widget/LinearLayout.md)

---

#### Properties

- `->`[`descendantFocusability`](#prop-descendantfocusability) : `int`
- *See also in the parent class* [View](classes/php/android/view/View.md).

---

#### Methods

- `->`[`addView()`](#method-addview)
- `->`[`removeView()`](#method-removeview)
- `->`[`removeViewAt()`](#method-removeviewat)
- `->`[`removeViews()`](#method-removeviews)
- `->`[`removeViewsInLayout()`](#method-removeviewsinlayout)
- `->`[`removeAllViews()`](#method-removeallviews)
- `->`[`removeAllViewsInLayout()`](#method-removeallviewsinlayout)
- `->`[`indexOfChild()`](#method-indexofchild)
- `->`[`getChildCount()`](#method-getchildcount)
- `->`[`getChildAt()`](#method-getchildat)
- See also in the parent class [View](classes/php/android/view/View.md)

---
# Methods

<a name="method-addview"></a>

### addView()
```php
addView(php\android\view\View $view, int $indexOrWidth, int $height): void
```

---

<a name="method-removeview"></a>

### removeView()
```php
removeView(php\android\view\View $view): void
```

---

<a name="method-removeviewat"></a>

### removeViewAt()
```php
removeViewAt(int $index): void
```

---

<a name="method-removeviews"></a>

### removeViews()
```php
removeViews(int $start, int $count): void
```

---

<a name="method-removeviewsinlayout"></a>

### removeViewsInLayout()
```php
removeViewsInLayout(int $start, int $count): void
```

---

<a name="method-removeallviews"></a>

### removeAllViews()
```php
removeAllViews(): void
```

---

<a name="method-removeallviewsinlayout"></a>

### removeAllViewsInLayout()
```php
removeAllViewsInLayout(): void
```

---

<a name="method-indexofchild"></a>

### indexOfChild()
```php
indexOfChild(php\android\view\View $child): int
```

---

<a name="method-getchildcount"></a>

### getChildCount()
```php
getChildCount(): int
```

---

<a name="method-getchildat"></a>

### getChildAt()
```php
getChildAt(int $index): php\android\view\View
```