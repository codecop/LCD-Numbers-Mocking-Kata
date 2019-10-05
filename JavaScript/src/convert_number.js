exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Returns a function that
 * splits a given number into digits and converts each digit into LCD digit.
 */
exports.createConvertNumber = function(digitsOf, createDigit) {
    'use strict';

    return function(number) {
        return digitsOf(number).map(createDigit);
    };

};
