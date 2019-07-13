<?php
/**
 * Created by PhpStorm.
 * User: themr
 * Date: 25.08.2018
 * Time: 20:18
 */

namespace php\android;



class UXExceptionDialog extends UXAndroidDialog
{

    function __construct()
    {
    }

    /**
     * @var \Exception
     */
    public $exception;
    public $introText = "";


}