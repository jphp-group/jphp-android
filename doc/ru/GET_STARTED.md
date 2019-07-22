# Начало работы

## Сборка из исходного кода

Для начала вам нужно установить Android SDK, [JDK 8](https://bell-sw.com/pages/java-8u222/) и [JPPM](https://github.com/jphp-group/jphp/releases).

После установки нужных компонентов нужно собрать jPHP for Android из исходного кода исользуя следующие комманды:

```bash
git clone https://github.com/jphp-group/jphp-android.git
cd jphp-android
jppm build
```

После выполнения этих команд у нас загрузится исходный код jPHP for Android и скомилируются следующие модули:

* **compiler**    - AOT компилятор jPHP кода в JVM Byte-Code 
* **ui-javafx**   - Обёртка вокруг проекта [JavaFXPorts](https://gluonhq.com/products/mobile/javafxports/)
* **ui-native**   - Обёртка вокруг Android API (В разработке)
* **jppm-plugin** - Плагин для системы сборки [jppm](https://github.com/jphp-group/jphp/tree/master/packager)

## Как это работает ?

Для начала `jppm` собирает единый `jar` со всеми зависемостями.

Потом вызывается AOT компилятор jPHP который конвертирует все php файлы, в едином `jar`, в ``$php_хеш.class`` файлы
понятные ``JVM``.

После всех этих манипуляций собирается само Android приложение в которое дабовляется скомпилированый `jar` как зависемость.

Ну и на выходе мы получаем готовый apk файл.