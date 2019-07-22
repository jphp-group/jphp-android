<?php

namespace php\android;

class UXExceptionDialog extends UXAndroidDialog
{
    /**
     * UXExceptionDialog constructor.
     */
    public function __construct() {

    }

    /**
     * @var \Exception
     */
    public $exception;

    /**
     * @var string
     */
    public $introText = "";
}