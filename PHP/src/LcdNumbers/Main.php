<?php
namespace LcdNumbers;

require "./vendor/autoload.php";

/**
 * Fake client code. Run this class to see LCD Numbers working:
 * <code>Main 12345 2</code>.
 */
$lcdDisplay = new LcdDisplay( //
    new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
    new DigitScaler(new ScalingRepeater()), //
    new DigitPrinter(new Zipper()));

$number = $argv[1];
$scaling = count($argv) > 2 ? Scaling::of($argv[2]) : Scaling::$NONE;

echo ($lcdDisplay->toLcd($number, $scaling));
