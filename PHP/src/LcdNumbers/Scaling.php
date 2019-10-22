<?php
namespace LcdNumbers;

/**
 * The scale factor value.
 */
class Scaling
{

    public static $NONE;
    public static $TWO;

    private $times;

    public static function of($t)
    {
        return new Scaling($t);
    }

    private function __construct($times)
    {
        if ($times <= 0) {
            throw new \InvalidArgumentException("scaling factor must be >= 1");
        }

        $this->times = $times;
    }

    public function none()
    {
        return $this->times == 1;
    }

    public function times($block)
    {
        for ($i = 0; $i < $this->times; $i++) {
            $block();
        }
    }

    public function __toString()
    {
        return (string) $this->times;
    }
}

Scaling::$NONE = Scaling::of(1);
Scaling::$TWO = Scaling::of(2);
