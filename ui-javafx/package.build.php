<?php

use compress\ZipArchive;
use compress\ZipArchiveEntry;
use packager\Event;
use packager\cli\Console;
use php\io\Stream;
use php\lib\fs;

/**
 * @jppm-depends-on gradle:build
 * @jppm-task module:build
 * @jppm-description Build ui-javafx module
 */
function task_ui_javafx_build(Event $e) {
    Tasks::cleanDir(fs::abs("./jars/"), [], true);

    Tasks::run("gradle:build", [], null);

    $jars = [
        "x-charm-5.0.2",
        "x-charm-cloudlink-client-4.5.2",
        "x-charm-down-core-3.8.5",
        "x-charm-down-plugin-device-3.8.0",
        "x-charm-down-plugin-display-3.8.5",
        "x-charm-down-plugin-in-app-billing-3.8.0",
        "x-charm-down-plugin-lifecycle-3.8.5",
        "x-charm-down-plugin-push-notifications-3.8.0",
        "x-charm-down-plugin-runtime-args-3.8.0",
        "x-charm-down-plugin-statusbar-3.8.5",
        "x-charm-down-plugin-storage-3.8.5",
        "x-charm-glisten-5.0.2",
        "x-charm-glisten-connect-view-5.0.2",
        "x-connect-1.5.0",
        "x-javax.json-1.0.4",
        "x-jphp-android-javafx-ui-ext-1.0.0",
    ];

    foreach ($jars as $jar) {
        $zip = new ZipArchive(fs::abs('./jars/' . $jar . '.jar'));
        $zip->readAll(function (ZipArchiveEntry $entry, ?Stream $stream) {
            if (!$entry->isDirectory()) {
                $file = fs::abs('./jars/.out/' . $entry->name);

                if (!fs::isFile($file))
                    fs::makeFile($file);

                fs::copy($stream, $file);
            } else fs::makeDir(fs::abs('./jars/.out/' . $entry->name));
        });
    }

    foreach ($jars as $jar)
        fs::delete(fs::abs('./jars/' . $jar . '.jar'));

    fs::makeFile("./jars/ui-javafx.jar");
    $jar = new ZipArchive(fs::abs("./jars/ui-javafx.jar"));
    $jar->open();

    fs::scan(fs::abs("./jars/.out/"), function (string $file) use ($jar) {
        if (fs::isFile($file))
            $jar->addFile($file, fs::relativize($file, fs::abs("./jars/.out/")));
    });

    $jar->close();

    Tasks::cleanDir(fs::abs("./jars/.out/"), [], true);


    // publish this package without call gradle:build
    $plugin = new DefaultPlugin;
    $plugin->publish(new Event($e->packager(), $e->package(), [], [ "yes" => true ]));
}