<?php

namespace php\android\services;

abstract class NotificationService {

    /**
     * @return NotificationService
     */
    public static function get() : NotificationService {
        return null;
    }

    /**
     * @param Notification $notification
     */
    abstract public function notify(Notification $notification);

    /**
     * @param Notification $notification
     */
    abstract public function remove(Notification $notification);

    /**
     * @return Notification[]
     */
    abstract public function getAllNotifications(): array;
}