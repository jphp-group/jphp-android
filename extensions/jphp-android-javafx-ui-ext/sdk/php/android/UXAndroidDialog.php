<?php
namespace php\android;

use php\gui\UXList;
use php\gui\UXNode;

class UXAndroidDialog
{
    /**
     * UXAndroidDialog constructor.
     */
    public function __construct() {
    }

    /**
     * Показать диалог
     */
    public function show() {

    }

    /**
     * Скрыть диалог
     */
    public function hide() {

    }

    /**
     * В полном экране?
     */
    public function isFullScreen() : bool {

    }

    /**
     * Закрыть автоматически?
     */
    public function isAutoHide() : bool {

    }


    /**
     * Показан?
     */
    public function isShowing() : bool {

    }

    /**
     * Заголовок
     * @var UXNode
     */
    public $title;

    /*
     * @var UXList
     */
    public $items;

    /*
     * @var UXNode
     */
    public $content;

    /*
     * @var callable
     */
    public $onHide;

    /*
     * @var UXNode
     */
    public $graphic;
}