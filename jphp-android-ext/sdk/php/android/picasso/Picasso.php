<?php

namespace php\android\picasso;


class Picasso
{
    /**
     * @return Picasso
     */
    public static function get(): Picasso {}

    /**
     * loading from File, string or int
     *
     * @param $data
     * @return RequestCreator
     */
    public function load($data): RequestCreator {}
}