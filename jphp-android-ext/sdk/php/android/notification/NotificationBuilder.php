<?php

namespace php\android\notification;

use php\android\app\Activity;
use php\android\widget\ImageView;

class NotificationBuilder {

    /**
     * @param Activity $activity
     */
    public function __construct(Activity $activity) {
        // native ...
    }

    /**
     * @param ImageView $imageView
     * @return NotificationBuilder
     */
    public function setLargeIcon(ImageView $imageView): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $when
     * @return NotificationBuilder
     */
    public function setWhen(int $when): NotificationBuilder {
        // native ...
    }

    /**
     * @param bool $b
     * @return NotificationBuilder
     */
    public function setUsesChronometer(bool $b): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $icon
     * @return NotificationBuilder
     */
    public function setSmallIcon(int $icon): NotificationBuilder {
        // native ...
    }

    /**
     * @param string $title
     * @return NotificationBuilder
     */
    public function setContentTitle(string $title): NotificationBuilder {
        // native ...
    }

    /**
     * @param string $text
     * @return NotificationBuilder
     */
    public function setContentText(string $text): NotificationBuilder {
        // native ...
    }

    /**
     * @param string $text
     * @return NotificationBuilder
     */
    public function setSubText(string $text): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $num
     * @return NotificationBuilder
     */
    public function setNumber(int $num): NotificationBuilder {
        // native ...
    }

    /**
     * @param string $info
     * @return NotificationBuilder
     */
    public function setContentInfo(int $info): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $max
     * @param int $progress
     * @param bool $indeterminate
     * @return NotificationBuilder
     */
    public function setProgress(int $max, int $progress, bool $indeterminate): NotificationBuilder {
        // native ...
    }

    /**
     * @param string $text
     * @return NotificationBuilder
     */
    public function setTicker(string $text): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $argb
     * @param int $onMs
     * @param int $offMs
     * @return NotificationBuilder
     */
    public function setLights(int $argb, int $onMs, int $offMs): NotificationBuilder {
        // native ...
    }

    /**
     * @param bool $ongoing
     * @return NotificationBuilder
     */
    public function setOngoing(bool $ongoing): NotificationBuilder {
        // native ...
    }

    /**
     * @param bool $onlyAlertOnce
     * @return NotificationBuilder
     */
    public function setOnlyAlertOnce(bool $onlyAlertOnce): NotificationBuilder {
        // native ...
    }

    /**
     * @param bool $autoCancel
     * @return NotificationBuilder
     */
    public function setAutoCancel(bool $autoCancel): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $defaults
     * @return NotificationBuilder
     */
    public function setDefaults(int $defaults): NotificationBuilder {
        // native ...
    }

    /**
     * @param int $pri
     * @return NotificationBuilder
     */
    public function setPriority(int $pri): NotificationBuilder {
        // native ...
    }

    /**
      * @return Notification
      */
    public function build(): Notification {
        // native ...
    }
}