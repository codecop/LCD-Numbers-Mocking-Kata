<?php
namespace LcdNumbers;

/**
 * Value Object of an LCD digit.
 */
class Digit
{

    private $digit;
    private $lines;

    public static function from($digit, Patterns $patterns)
    {
        return new Digit($digit, $patterns->of($digit));
    }

    private function __construct($digit, $lines)
    {
        $this->digit = $digit;
        $this->lines = $lines;
    }

    public function lines()
    {
        return $this->lines;
    }

    public function scale(array $scaledLines)
    {
        $linesCount = count($this->lines);
        $scaledCount = count($scaledLines);
        if ($scaledCount < $linesCount) {
            throw new InvalidArgumentException("Scaled lines must be more than original ones: " . scaledCount . ">=" . linesCount);
        }

        return new Digit($this->digit, $scaledLines);
    }

    public function __toString()
    {
        return (string) $this->digit;
    }
}
