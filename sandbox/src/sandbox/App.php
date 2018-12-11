<?php

namespace sandbox;


use php\android\app\Application;
use php\android\picasso\Picasso;
use php\android\widget\Button;
use php\android\widget\GridLayout;
use php\android\widget\ImageView;
use php\lib\arr;

class App
{
    private $images = [ // cat images :3
        "http://marmazov.ru/wp-content/uploads/2017/05/kotiki.jpg",
        "http://droplak.ru/wp-content/uploads/2016/04/3-8.jpg",
        "https://cdn.fishki.net/upload/post/2016/05/27/1964155/tn/3-japonija-ryokan.jpg",
        "https://pp.userapi.com/c852220/v852220728/6167b/F9RxzXIxebU.jpg",
    ];

    private $imageIndex = 0;

    public function makeUI() {
	var_dump(Application::getFilesDir()->getAbsolutePath());

        $activity = Application::getMainActivity();
        $activity->setTitle("jPHP Sandbox");

        $layout = new GridLayout($activity);
        $image = new ImageView($activity);
        $button = new Button($activity);
        $button->text = "Next image";
        $button->on("click", function () use ($image) {
            $this->loadImage($image);
        });

        $layout->addView($button);
        $layout->addView($image);
        $activity->setContentView($layout);

        Picasso::get()->load($this->images[$this->imageIndex])->into($image);
    }

    protected function loadImage(ImageView $imageView) {
        if ($this->imageIndex >= arr::count($this->images)) $this->imageIndex = 0;

        Picasso::get()->load($this->images[$this->imageIndex])->into($imageView);

        $this->imageIndex++;
    }
}