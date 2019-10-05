exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Initial pattern of each LCD digit.
 */
var lcdByDigit = [];

function put(digit, lines) {
    'use strict';

    if (lcdByDigit[digit] !== undefined) {
        throw new RangeError('duplicate pattern definition for digit ' + digit);
    }

    lcdByDigit[digit] = lines;
}

put(0, [new Line(' - '), //
        new Line('| |'), //
        new Line('   '), //
        new Line('| |'), //
        new Line(' - ')]);
put(1, [new Line('   '), //
        new Line('  |'), //
        new Line('   '), //
        new Line('  |'), //
        new Line('   ')]);
put(2, [new Line(' - '), //
        new Line('  |'), //
        new Line(' - '), //
        new Line('|  '), //
        new Line(' - ')]);
put(3, [new Line(' - '), //
        new Line('  |'), //
        new Line(' - '), //
        new Line('  |'), //
        new Line(' - ')]);
put(4, [new Line('   '), //
        new Line('| |'), //
        new Line(' - '), //
        new Line('  |'), //
        new Line('   ')]);
put(5, [new Line(' - '), //
        new Line('|  '), //
        new Line(' - '), //
        new Line('  |'), //
        new Line(' - ')]);
put(6, [new Line(' - '), //
        new Line('|  '), //
        new Line(' - '), //
        new Line('| |'), //
        new Line(' - ')]);
put(7, [new Line(' - '), //
        new Line('  |'), //
        new Line('   '), //
        new Line('  |'), //
        new Line('   ')]);
put(8, [new Line(' - '), //
        new Line('| |'), //
        new Line(' - '), //
        new Line('| |'), //
        new Line(' - ')]);
put(9, [new Line(' - '), //
        new Line('| |'), //
        new Line(' - '), //
        new Line('  |'), //
        new Line(' - ')]);

exports.patternsOf = function(digit) {
    'use strict';

    if (lcdByDigit[digit] === undefined) {
        throw new RangeError('no pattern defined for digit ' + digit);
    }

    return lcdByDigit[digit];
};
