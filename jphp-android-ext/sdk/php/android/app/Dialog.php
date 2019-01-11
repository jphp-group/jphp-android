<?php

namespace php\android\app;

use php\android\content\Context;
use php\android\view\View;

class Dialog
{
    /**
     * @var Activity
     */
    public $ownerActivity;

    /**
     * Dialog constructor.
     * @param Context $context
     */
    public function __construct(Context $context)
    {
        // native ...
    }

    /**
     * @param View $view
     */
    public function setContentView(View $view)
    {
        // native ...
    }

    /**
     * @param int $id
     */
    public function setContentViewById(int $id)
    {
        // native ...
    }

    /**
     * @param string $title
     */
    public function setTitle(string $title)
    {
        // native ...
    }

    /**
     * @param int $id
     */
    public function setTitleById(int $id)
    {
        // native ...
    }

    /**
     * @return View
     */
    public function getCurrentFocus(): View
    {
        // native ...
    }

    /**
     * @param int $id
     * @return View
     */
    public function findViewById(int $id): View
    {
        // native ...
    }

    /**
     * @return bool
     */
    public function isShowing(): bool
    {
        // native ...
    }

    public function show()
    {
        // native ...
    }

    public function hide()
    {
        // native ...
    }

    public function dismiss()
    {
        // native ...
    }

    public function cancel()
    {
        // native ...
    }
}