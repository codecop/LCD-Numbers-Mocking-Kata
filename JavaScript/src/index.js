'use strict';

// Java class Main

require('./to_lcd');
require('./convert_number');
require('./digits_of');
require('./digit');
require('./create_digit');
require('./line');
require('./patterns_of');
require('./scale_digits');
require('./scaling_repeat');
require('./render_digits');
require('./zip_with_combine');
require('./scaling');

/**
 * Fake client code. Run this script to see LCD Numbers working: 
 * <code>node index.js 12345 2</code>.
 */
var toLcd = createToLcd( //
    // new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
    createConvertNumber(createDigitsOf(), createCreateDigit(patternsOf)), //
    // new DigitScaler(new ScalingRepeater()), //
    createScaleDigits(scalingRepeat),
    // new DigitPrinter(new Zipper()));
    createRenderDigits(zipWithCombine));

var args = process.argv;
args.shift(); // node
args.shift(); // script name

var number = Number(args[0]);
var scaling = Scaling.of(Number(args[1]));

console.log(toLcd(number, scaling));
