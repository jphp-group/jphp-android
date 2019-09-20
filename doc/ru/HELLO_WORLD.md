# Hello, World!

Готовый пример `Hello, World!` приложения можно посмотреть тут:

* [javafx-hello](../../examples/javafx-hello/README.md)
* [native-hello]() (В разработке)

## Hello, World! на JavaFX

Для генерации `Hello, World!` приложения нужно использовать следующие команды:

```bash
jppm init jphp-android-javafx # Вводим всю информацию и инициализируем шаблон
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

Компилируем с помощью команды `jppm build` или запускаем с помощью команды `jppm start`, и видим наш Hello, World!

## Native Hello, World!

> В разработке!
