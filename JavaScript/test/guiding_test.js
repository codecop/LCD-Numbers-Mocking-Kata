/* globals describe, it, beforeEach, to_lcd */
'use strict';

var chai = require('chai');
var should = chai.should();
var fs = require('fs');

require('../src/to_lcd');
require('../src/convert_number');
require('../src/digits_of');
require('../src/digit');
require('../src/create_digit');
require('../src/line');
require('../src/patterns_of');

require('../src/scale_digits');
require('../src/scaling_repeat');

require('../src/render_digits');
require('../src/zip_with_combine');

require('../src/scaling');

function read(name) {
    return fs.readFileSync('./test/resources/' + name, 'UTF-8').replace(/(?:\r\n|\r)/g, '\n');
}

describe('to_lcd', function() {
    var toLcd;

    beforeEach(function() {
        toLcd = createToLcd( //
            // new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
            createConvertNumber(createDigitsOf(), createCreateDigit(patternsOf)), //
            // new DigitScaler(new ScalingRepeater()), //
            createScaleDigits(scalingRepeat),
            // new DigitPrinter(new Zipper()));
            createRenderDigits(zipWithCombine));
    });

    it('should print LCD size one', function() {
        var lcd = toLcd(123, Scaling.NONE);
        lcd.should.equal('    -  - \n' + //
                         '  |  |  |\n' + //
                         '    -  - \n' + //
                         '  ||    |\n' + //
                         '    -  - \n');
    });

    it('should print LCD size two', function() {
        var lcd = toLcd(123, Scaling.TWO);
        lcd.should.equal('     --  -- \n' + //
                         '   |   |   |\n' + //
                         '   |   |   |\n' + //
                         '     --  -- \n' + //
                         '   ||      |\n' + //
                         '   ||      |\n' + //
                         '     --  -- \n');
    });

    it('should print LCD size three', function() {
        var lcd = toLcd(123, Scaling.of(3));
        lcd.should.equal('      ---  --- \n' + //
                         '    |    |    |\n' + //
                         '    |    |    |\n' + //
                         '    |    |    |\n' + //
                         '      ---  --- \n' + //
                         '    ||        |\n' + //
                         '    ||        |\n' + //
                         '    ||        |\n' + //
                         '      ---  --- \n');
    });

    it('should print all numbers LCD size three', function() {
        var lcd = toLcd(1234567890, Scaling.of(3));
        var expected = read('/numbers grid 5x9 - size 3.txt');
        lcd.should.equal(expected);
    });

});
