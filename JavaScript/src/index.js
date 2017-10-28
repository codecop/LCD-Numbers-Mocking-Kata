'use strict';

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
 * Client code. Run this script to see LCD Numbers working:
 * <code>node index.js 12345 2</code>.
 */
var toLcd = createToLcd( //
    createConvertNumber(createDigitsOf(10), createCreateDigit(patternsOf)), //
    createScaleDigits(scalingRepeat), //
    createRenderDigits(zipWithCombine));

if (require.main === module) {

    var args = process.argv;
    args.shift(); // node
    args.shift(); // script name

    var number = Number(args[0]);
    var scaling = Scaling.of(Number(args[1]));

    console.log(toLcd(number, scaling));

} else {

    exports = typeof window !== 'undefined' && window !== null ? window : global;
    exports.toLcd = toLcd;

}
