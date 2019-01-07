# Application

- **class** `Application` (`php\android\app\Application`)
- **source** `php/android/app/Application.php`

---

#### Static Methods

- `Application ::`[`getMainActivity()`](#method-getmainactivity)
- `Application ::`[`getContext()`](#method-getcontext)
- `Application ::`[`setMainActivityHandler()`](#method-setmainactivityhandler) - _When changing the orientation, when recreating the MainActivity_
- `Application ::`[`getFilesDir()`](#method-getfilesdir)

---
# Static Methods

<a name="method-getmainactivity"></a>

### getMainActivity()
```php
Application::getMainActivity(): php\android\app\Activity
```

---

<a name="method-getcontext"></a>

### getContext()
```php
Application::getContext(): php\android\content\Context
```

---

<a name="method-setmainactivityhandler"></a>

### setMainActivityHandler()
```php
Application::setMainActivityHandler(callable $callback): void
```
When changing the orientation, when recreating the MainActivity


---

<a name="method-getfilesdir"></a>

### getFilesDir()
```php
Application::getFilesDir(): php\io\File
```