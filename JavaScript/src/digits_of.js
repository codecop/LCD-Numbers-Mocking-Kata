exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class NumeralSystem

/**
 * Splits a number into its digits according to its base, e.g. Decimal System.
 */
exports.createDigitsOf = function() {
    'use strict';

    var base = 10;
    // if (base < 2) {
    //     throw new RangeError('Smallest base is binary; base=' + base);
    // }

    return function(value) {
        if (value < 0) {
            throw new RangeError('negative number ' + value);
        }

        var digits = [],
            remainder = value;
        while (remainder > 0) {
            digits.push(remainder % base);
            remainder = Math.floor(remainder / base);
        }
        digits.reverse(digits);

        return digits;
    };

};
