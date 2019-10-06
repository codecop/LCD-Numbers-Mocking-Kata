<?php
namespace LcdNumbers;

/**
 * The scale factor value.
 */
class Scaling
{

    //public static Scaling NONE = new Scaling(1);
    //public static Scaling TWO = new Scaling(2);

    private $times;

    public static function of($t)
    {
        return new Scaling($t);
    }

    private function __($times)
    {
        if ($times <= 0) {
            throw new IllegalArgumentException("scaling factor must be >= 1");
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
