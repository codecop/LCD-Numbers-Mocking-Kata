/* globals describe, beforeEach, it, zipWithCombine, createRenderDigits, Line */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/line');
require('../src/zip_with_combine');
require('../src/render_digits');

function digitFrom(line1, line2) { // stub Digit
    var lines = [ new Line(line1), new Line(line2) ];
    return {
        lines : function() {
            return lines;
        }
    };
}

describe('renderDigits', function() {
    var printDigit;

    beforeEach(function() {
        // zipWithCombine feels technical, so it is rather a helper than a real collaborator.
        printDigit = createRenderDigits(zipWithCombine);
    });

    it('should render digits side by side', function() {
        var one = digitFrom('A1', //
                            'A2'),
            two = digitFrom('B1', //
                            'B2'),

            display = printDigit([ one, two ]);

        display.should.equal('A1B1\n' + //
                             'A2B2\n');
    });

});
