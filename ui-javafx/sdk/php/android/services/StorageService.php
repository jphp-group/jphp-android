<?php

namespace php\android\services;

use php\io\File;

abstract class StorageService {

    public const SERVICE = "com.gluonhq.charm.down.plugins.StorageService";

    /**
     * @return StorageService
     */
    public static function get() : StorageService {
        return null;
    }

    /**
     * @return File|null
     */
    abstract public function getPrivateStorage() : ?File;

    /**
     * @param string $path
     * @return File|null
     */
    abstract public function getPublicStorage(string $path) : ?File;

    /**
     * @return bool
     */
    abstract public function isExternalStorageWritable() : bool;

    /**
     * @return bool
     */
    abstract public function isExternalStorageReadable() : bool;
}