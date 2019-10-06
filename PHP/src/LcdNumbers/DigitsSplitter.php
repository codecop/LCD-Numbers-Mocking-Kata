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

        // TODO make it work
        return $numeralDigits->stream()->//
            map(digitFactory::create)->//
            collect();
    }
}
