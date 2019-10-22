<?php
namespace LcdNumbers;

/**
 * Splits into digits and converts digits to LCD digits.
 */
class DigitsSplitter
{

    private $numeralSystem;
    private $digitFactory;

    public function __construct(NumeralSystem $numeralSystem, DigitFactory $digitFactory)
    {
        $this->numeralSystem = $numeralSystem;
        $this->digitFactory = $digitFactory;
    }

    public function convert($number)
    {
        $numeralDigits = $this->numeralSystem->digitsOf($number);

        $digits = [];
        foreach ($numeralDigits as $numeralDigit) {
            array_push($digits, $this->digitFactory->create($numeralDigit));
        }
        return $digits;
    }
}
