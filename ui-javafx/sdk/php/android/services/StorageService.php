<?php

namespace php\android\services;

use php\android\UXServices;
use php\io\File;

abstract class StorageService {

    public const SERVICE = "com.gluonhq.charm.down.plugins.StorageService";

    /**
     * @return StorageService
     * @throws \php\lang\JavaException
     */
    public static function get() : StorageService {
        return UXServices::get(StorageService::SERVICE);
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