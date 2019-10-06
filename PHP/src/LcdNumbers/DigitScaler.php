<?php
namespace LcdNumbers;

/**
 * Scales x and y of digit lines.
 */
class DigitScaler
{

    private $repeater;

    public function __construct(ScalingRepeater $repeater)
    {
        $this->repeater = $repeater;
    }

    public function scale(array $digits, Scaling $scaling)
    {
        $scaledDigits = [];
        foreach ($digits as $digit) {
            array_push($scaledDigits, $this->scaleDigit($digit, $scaling));
        }
        return $scaledDigits;
    }

    private function scaleDigit(Digit $digit, Scaling $scaling)
    {
        if ($scaling->none()) {
            return $digit;
        }

        $scaled = [];

        $oddLine = true;
        foreach ($digit->lines() as $line) {
            $scaledLine = $line->scaleHorizontal($this->repeater, $scaling);
            if ($oddLine) {
                array_push($scaled, $scaledLine);
            } else {
                array_merge($scaled, $this->repeater->repeat($scaledLine, $scaling));
            }
            $oddLine = !$oddLine;
        }

        return $digit->scale($scaled);
    }
}
