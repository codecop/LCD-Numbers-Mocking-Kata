<?php
namespace LcdNumbers;

/**
 * Combines Converter, Scaler and Printer.
 */
class LcdDisplay
{

    private $digitsSplitter;
    private $digitScaler;
    private $digitPrinter;

    public function __construct(DigitsSplitter $digitsSplitter, DigitScaler $digitScaler, DigitPrinter $digitPrinter)
    {
        $this->digitsSplitter = $digitsSplitter;
        $this->digitScaler = $digitScaler;
        $this->digitPrinter = $digitPrinter;
    }

    public function toLcd($number, Scaling $scaling)
    {
        $digits = $this->digitsSplitter->convert($number);
        $scaled = $this->digitScaler->scale($digits, $scaling);
        return $this->digitPrinter->render($scaled);
    }
}
