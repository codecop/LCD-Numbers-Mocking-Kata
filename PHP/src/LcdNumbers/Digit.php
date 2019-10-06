<?php
namespace LcdNumbers;

/**
 * Value Object of an LCD digit.
 */
class Digit
{

    private $digit;
    private $lines;

    public function __construct($digit, Patterns $patterns)
    {
        $this->digit = $digit;
        $this->lines = $patterns->of($digit);
    }

    public function lines()
    {
        return $this->lines;
    }

    public function scale(array $scaledLines)
    {
        $linesCount = $this->lines->size();
        $scaledCount = $scaledLines->size();
        if ($scaledCount < $linesCount) {
            throw new IllegalArgumentException("Scaled lines must be more than original ones: " . scaledCount . ">=" . linesCount);
        }

        return new Digit($this->digit, $scaledLines);
    }

    public function __toString()
    {
        return (string) $this->digit;
    }
}
