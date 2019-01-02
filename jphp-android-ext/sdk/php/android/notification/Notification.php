<?php

namespace php\android\notification;

class Notification {

    const DEFAULT_ALL = -1;
    const DEFAULT_SOUND = 1;
    const DEFAULT_VIBRATE = 2;
    const DEFAULT_LIGHTS = 4;
    
    const FLAG_SHOW_LIGHTS = 1;
    const FLAG_ONGOING_EVENT = 2;
    const FLAG_INSISTENT = 4;
    const FLAG_ONLY_ALERT_ONCE = 8;
    const FLAG_AUTO_CANCEL = 16;
    const FLAG_NO_CLEAR = 32;
    const FLAG_FOREGROUND_SERVICE = 64;

    const PRIORITY_MIN = -2;
    const PRIORITY_LOW = -1;
    const PRIORITY_DEFAULT = 0;
    const PRIORITY_HIGH = 1;
    const PRIORITY_MAX = 2;

    /**
     * @param Notification $notification
     * @param int $id
     */
    public static function notify(Notification $notification, int $id) {
        // native ...
    }

    /**
     * @param int $id
     */
    public static function cancel(int $id) {
        // native ...
    }

    public static function cancelAll() {
        // native ...
    }
}