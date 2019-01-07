# NotificationBuilder

- **class** `NotificationBuilder` (`php\android\notification\NotificationBuilder`)
- **source** `php/android/notification/NotificationBuilder.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct)
- `->`[`setLargeIcon()`](#method-setlargeicon)
- `->`[`setWhen()`](#method-setwhen)
- `->`[`setUsesChronometer()`](#method-setuseschronometer)
- `->`[`setSmallIcon()`](#method-setsmallicon)
- `->`[`setContentTitle()`](#method-setcontenttitle)
- `->`[`setContentText()`](#method-setcontenttext)
- `->`[`setSubText()`](#method-setsubtext)
- `->`[`setNumber()`](#method-setnumber)
- `->`[`setContentInfo()`](#method-setcontentinfo)
- `->`[`setProgress()`](#method-setprogress)
- `->`[`setTicker()`](#method-setticker)
- `->`[`setLights()`](#method-setlights)
- `->`[`setOngoing()`](#method-setongoing)
- `->`[`setOnlyAlertOnce()`](#method-setonlyalertonce)
- `->`[`setAutoCancel()`](#method-setautocancel)
- `->`[`setDefaults()`](#method-setdefaults)
- `->`[`setPriority()`](#method-setpriority)
- `->`[`build()`](#method-build)

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(php\android\app\Activity $activity): void
```

---

<a name="method-setlargeicon"></a>

### setLargeIcon()
```php
setLargeIcon(php\android\widget\ImageView $imageView): php\android\notification\NotificationBuilder
```

---

<a name="method-setwhen"></a>

### setWhen()
```php
setWhen(int $when): php\android\notification\NotificationBuilder
```

---

<a name="method-setuseschronometer"></a>

### setUsesChronometer()
```php
setUsesChronometer(bool $b): php\android\notification\NotificationBuilder
```

---

<a name="method-setsmallicon"></a>

### setSmallIcon()
```php
setSmallIcon(int $icon): php\android\notification\NotificationBuilder
```

---

<a name="method-setcontenttitle"></a>

### setContentTitle()
```php
setContentTitle(string $title): php\android\notification\NotificationBuilder
```

---

<a name="method-setcontenttext"></a>

### setContentText()
```php
setContentText(string $text): php\android\notification\NotificationBuilder
```

---

<a name="method-setsubtext"></a>

### setSubText()
```php
setSubText(string $text): php\android\notification\NotificationBuilder
```

---

<a name="method-setnumber"></a>

### setNumber()
```php
setNumber(int $num): php\android\notification\NotificationBuilder
```

---

<a name="method-setcontentinfo"></a>

### setContentInfo()
```php
setContentInfo(string $info): php\android\notification\NotificationBuilder
```

---

<a name="method-setprogress"></a>

### setProgress()
```php
setProgress(int $max, int $progress, bool $indeterminate): php\android\notification\NotificationBuilder
```

---

<a name="method-setticker"></a>

### setTicker()
```php
setTicker(string $text): php\android\notification\NotificationBuilder
```

---

<a name="method-setlights"></a>

### setLights()
```php
setLights(int $argb, int $onMs, int $offMs): php\android\notification\NotificationBuilder
```

---

<a name="method-setongoing"></a>

### setOngoing()
```php
setOngoing(bool $ongoing): php\android\notification\NotificationBuilder
```

---

<a name="method-setonlyalertonce"></a>

### setOnlyAlertOnce()
```php
setOnlyAlertOnce(bool $onlyAlertOnce): php\android\notification\NotificationBuilder
```

---

<a name="method-setautocancel"></a>

### setAutoCancel()
```php
setAutoCancel(bool $autoCancel): php\android\notification\NotificationBuilder
```

---

<a name="method-setdefaults"></a>

### setDefaults()
```php
setDefaults(int $defaults): php\android\notification\NotificationBuilder
```

---

<a name="method-setpriority"></a>

### setPriority()
```php
setPriority(int $pri): php\android\notification\NotificationBuilder
```

---

<a name="method-build"></a>

### build()
```php
build(): php\android\notification\Notification
```