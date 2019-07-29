# Hello, World!

Готовый пример `Hello, World!` приложения можно посмотреть тут:

* [javafx-hello](../../examples/javafx-hello/README.md)
* [native-hello]() (В разработке)

## Hello, World! на JavaFX

Для генерации `Hello, World!` приложения нужно использовать следующие команды:

```bash
jppm init # Соглашаемся на добовление App плагина
jppm remove jphp-core && jppm remove jphp-zend-ext
jppm add jppm-android-plugin --dev # Добовляем jppm плагин
jppm android:init # Инициализируем Android проект
```

После чего у нас сгенерируются файлы Android приложения.

Создадим класс `MainView` с namespace `app` в деректории `src`, который заполняем как [тут](../../examples/javafx-hello/src/app/MainView.php)
Дальше зарегистрируем этот класс в `index.php`

```php
<?

use app\MainView;
use php\android\UXMobileApplication;

UXMobileApplication::launch(function () {
    UXMobileApplication::addView("home", new MainView()); // add view
    UXMobileApplication::showView("home"); // show view
});
```

Компилируем с помощью команды `jppm android:compile` или запускаем с помощью команды `jppm android:run`, и видим наш Hello, World!

## Native Hello, World!

> В разработке!