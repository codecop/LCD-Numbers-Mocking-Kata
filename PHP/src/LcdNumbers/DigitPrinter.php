<?php
namespace LcdNumbers;

/**
 * Appends lines next to each other and adds line breaks->
 */
class DigitPrinter
{

    const NEWLINE = "\n";

    private $zipper;

    public function __construct(Zipper $zipper)
    {
        $this->zipper = $zipper;
    }

    public function render(array $digits)
    {
        $linesOfAllDigits = $this->linesOfAllDigits($digits);
        $linesSideBySide = $this->zip($linesOfAllDigits);
        return $this->join($linesSideBySide);
    }

    private function linesOfAllDigits(array $digits)
    {
        return array_map(
            function ($digit) {
                return $digit->lines();
            }, $digits);
    }

    private function zip(array $linesOfAllDigits)
    {
        return $this->zipper->zip($linesOfAllDigits, this::concat);
    }

    private function concat(array $lines)
    {
        return join(
            $lines
            //    array_map(function($line) { return (string) $line; }, $lines)
        );
    }

    private function join(array $lines)
    {
        return join(NEWLINE, $lines) . NEWLINE;
    }

}
