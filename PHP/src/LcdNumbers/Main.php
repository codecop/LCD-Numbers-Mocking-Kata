<?php
namespace LcdNumbers;

/**
 * Fake client code. Run this class to see LCD Numbers working:
 * <code>Main 12345 2</code>.
 */
$lcdDisplay = new LcdDisplay( //
        new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
        new DigitScaler(new ScalingRepeater()), //
        new DigitPrinter(new Zipper()));

        $number = args[0];
        $scaling = args->length > 1 ? Scaling::of(args[1]) : Scaling::NONE;

echo($lcdDisplay->toLcd($number, $scaling));
