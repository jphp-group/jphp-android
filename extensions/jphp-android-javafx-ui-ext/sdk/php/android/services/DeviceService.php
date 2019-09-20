<?php

namespace php\android\services;

abstract class DeviceService {

    /**
     * @return DeviceService
     */
    public static function get() : DeviceService {
        return null;
    }

    /**
     * @return string
     */
    abstract public function getModel(): string;

    /**
     * @return string
     */
    abstract public function getUuid(): string;

    /**
     * @return string
     */
    abstract public function getPlatform(): string;

    /**
     * @return string
     */
    abstract public function getVersion(): string;

    /**
     * @return string
     */
    abstract public function getSerial(): string;

    /**
     * @return bool
     */
    abstract public function isWearable(): bool;
}