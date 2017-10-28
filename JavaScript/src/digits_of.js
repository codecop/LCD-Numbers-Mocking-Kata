exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Returns a function that
 * splits a number into its digits according to base, e.g. Decimal System.
 */
exports.createDigitsOf = function(base) {
    'use strict';

    if (base < 2) {
        throw new RangeError('Smallest base is binary; base=' + base);
    }

    return function(number) {
        if (number < 0) {
            throw new RangeError('negative number ' + number);
        }

        var digits = [],
            remainder = number;
        while (remainder > 0) {
            digits.push(remainder % base);
            remainder = Math.floor(remainder / base);
        }
        digits.reverse(digits);

        return digits;
    };

};
