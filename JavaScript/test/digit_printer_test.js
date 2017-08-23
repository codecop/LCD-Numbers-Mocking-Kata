/* globals describe, beforeEach, it, zip, DigitPrinter */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/line');
require('../src/digit_printer');
require('../src/zip');

function digitFrom(line1, line2) {
    var lines = [ new Line(line1), new Line(line2) ];
    return { lines: function() { return lines; }}; // stub Digit
}

describe('DigitPrinter', function () {

    var printer;

    beforeEach(function() {
        // Zip feels technical, so it is rather a helper than a real collaborator.
        printer = new DigitPrinter(zip);
    });

    it('should render digits side by side', function () {
        var one = digitFrom('A1', //
                            'A2');
        var two = digitFrom('B1', //
                            'B2');

        var display = printer.render([ one, two ]);

        display.should.equal('A1B1\n' + //
                             'A2B2\n');
    });

});
