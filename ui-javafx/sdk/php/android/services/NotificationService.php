<?php

namespace php\android\services;

class NotificationService {

    /**
     * @return NotificationService
     */
    public static function get() : NotificationService {
        return null;
    }

    /**
     * @param Notification $notification
     */
    public function notify(Notification $notification) {
        // some native code ...
    }

    /**
     * @param Notification $notification
     */
    public function remove(Notification $notification) {
        // some native code ...
    }

    /**
     * @return Notification[]
     */
    public function getAllNotifications(): array {
        return [];
    }
}