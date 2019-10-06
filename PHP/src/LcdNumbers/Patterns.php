<?php
namespace LcdNumbers;

/**
 * Knows the initial pattern of each LCD digit.
 */
class Patterns
{

    private $lcdByDigit;

    public function __construct()
    {
        $this->lcdByDigit = [];
        $this->put(0, new Line(" - "), //
            new Line("| |"), //
            new Line("   "), //
            new Line("| |"), //
            new Line(" - "));
        $this->put(1, new Line("   "), //
            new Line("  |"), //
            new Line("   "), //
            new Line("  |"), //
            new Line("   "));
        $this->put(2, new Line(" - "), //
            new Line("  |"), //
            new Line(" - "), //
            new Line("|  "), //
            new Line(" - "));
        $this->put(3, new Line(" - "), //
            new Line("  |"), //
            new Line(" - "), //
            new Line("  |"), //
            new Line(" - "));
        $this->put(4, new Line("   "), //
            new Line("| |"), //
            new Line(" - "), //
            new Line("  |"), //
            new Line("   "));
        $this->put(5, new Line(" - "), //
            new Line("|  "), //
            new Line(" - "), //
            new Line("  |"), //
            new Line(" - "));
        $this->put(6, new Line(" - "), //
            new Line("|  "), //
            new Line(" - "), //
            new Line("| |"), //
            new Line(" - "));
        $this->put(7, new Line(" - "), //
            new Line("  |"), //
            new Line("   "), //
            new Line("  |"), //
            new Line("   "));
        $this->put(8, new Line(" - "), //
            new Line("| |"), //
            new Line(" - "), //
            new Line("| |"), //
            new Line(" - "));
        $this->put(9, new Line(" - "), //
            new Line("| |"), //
            new Line(" - "), //
            new Line("  |"), //
            new Line(" - "));
    }

    private function put($digit, $lines)
    {
        if (array_key_exists($digit, $this->lcdByDigit)) {
            throw new InvalidArgumentException("duplicate pattern definition for digit " . $digit);
        }

        $this->lcdByDigit[$digit] = $lines;
    }

    public function of($digit)
    {
        if (!array_key_exists($digit, $this->lcdByDigit)) {
            throw new InvalidArgumentException("no pattern defined for digit " . $digit);
        }

        return $this->lcdByDigit[digit];
    }
}
