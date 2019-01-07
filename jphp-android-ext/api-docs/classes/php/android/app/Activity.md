# Activity

- **class** `Activity` (`php\android\app\Activity`) **extends** [`Context`](classes/php/android/content/Context.md)
- **source** `php/android/app/Activity.php`

---

#### Methods

- `->`[`onCreate()`](#method-oncreate)
- `->`[`setTitle()`](#method-settitle)
- `->`[`setContentView()`](#method-setcontentview)
- `->`[`setContentViewById()`](#method-setcontentviewbyid)
- `->`[`findById()`](#method-findbyid)
- `->`[`setOnCreate()`](#method-setoncreate) - _On Activity create_
- See also in the parent class [Context](classes/php/android/content/Context.md)

---
# Methods

<a name="method-oncreate"></a>

### onCreate()
```php
onCreate(): void
```

---

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
