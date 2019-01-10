# Activity

- **class** `Activity` (`php\android\app\Activity`) **extends** [`Context`](classes/php/android/content/Context.md)
- **source** `php/android/app/Activity.php`

---

#### Methods

- `->`[`setTitle()`](#method-settitle)
- `->`[`setContentView()`](#method-setcontentview)
- `->`[`setContentViewById()`](#method-setcontentviewbyid)
- `->`[`findById()`](#method-findbyid)
- `->`[`setOnCreate()`](#method-setoncreate) - _On Activity create_
- `->`[`setOnKeyDown()`](#method-setonkeydown) - _Callback params: int $keyCode_
- `->`[`setOnKeyUp()`](#method-setonkeyup) - _Callback params: int $keyCode_
- `->`[`setOnKeyLongPress()`](#method-setonkeylongpress) - _Callback params: int $keyCode_
- `->`[`setOnKeyMultiple()`](#method-setonkeymultiple) - _Callback params: int $keyCode_
- `->`[`setOnKeyShortcut()`](#method-setonkeyshortcut) - _Callback params: int $keyCode_
- See also in the parent class [Context](classes/php/android/content/Context.md)

---
# Methods

<a name="method-settitle"></a>

### setTitle()
```php
setTitle(string $title): void
```

---

<a name="method-setcontentview"></a>

### setContentView()
```php
setContentView(php\android\view\View $view): void
```

---

<a name="method-setcontentviewbyid"></a>

### setContentViewById()
```php
setContentViewById(int $id): void
```

---

<a name="method-findbyid"></a>

### findById()
```php
findById(int $id): php\android\view\View
```

---

<a name="method-setoncreate"></a>

### setOnCreate()
```php
setOnCreate(callable $callback): void
```
On Activity create


---

<a name="method-setonkeydown"></a>

### setOnKeyDown()
```php
setOnKeyDown(callable $callback): void
```
Callback params: int $keyCode

---

<a name="method-setonkeyup"></a>

### setOnKeyUp()
```php
setOnKeyUp(callable $callback): void
```
Callback params: int $keyCode

---

<a name="method-setonkeylongpress"></a>

### setOnKeyLongPress()
```php
setOnKeyLongPress(callable $callback): void
```
Callback params: int $keyCode

---

<a name="method-setonkeymultiple"></a>

### setOnKeyMultiple()
```php
setOnKeyMultiple(callable $callback): void
```
Callback params: int $keyCode

---

<a name="method-setonkeyshortcut"></a>

### setOnKeyShortcut()
```php
setOnKeyShortcut(callable $callback): void
```
Callback params: int $keyCode