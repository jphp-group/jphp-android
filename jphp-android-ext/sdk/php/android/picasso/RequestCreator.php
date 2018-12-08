<?php

namespace php\android\picasso;

use php\android\widget\ImageView;

class RequestCreator
{
    /**
     * @param ImageView $view
     * @return RequestCreator
     */
    public function into(ImageView $view): RequestCreator {}

    /**
     * @return RequestCreator
     */
    public function noPlaceholder(): RequestCreator {}

    /**
     * @param int $width
     * @param int $height
     * @return RequestCreator
     */
    public function resize(int $width, int $height) : RequestCreator {}
}