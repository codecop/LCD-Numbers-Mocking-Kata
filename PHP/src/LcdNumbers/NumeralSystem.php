<?php
namespace LcdNumbers;

/**
 * Splits a number into its digits according to its numeral system, e.g. Decimal System.
 */
class NumeralSystem
{

    private $base;

    public function __construct($base = 10)
    {
        if ($base < 2) {
            throw new IllegalArgumentException("Smallest base is binary; base=" . $base);
        }

        $this->base = $base;
    }

    public function digitsOf($value)
    {
        if ($value < 0) {
            throw new IllegalArgumentException("negative number " . $value);
        }

        $digits = [];

        $remainder = $value;
        while ($remainder > 0) {
            $digits->add($remainder % $this->base);
            $remainder /= $this->base;
        }
        // TODO Collections->reverse($digits);

        return $digits;
    }
}
