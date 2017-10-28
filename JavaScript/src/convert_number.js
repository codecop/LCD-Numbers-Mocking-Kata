exports = typeof window !== 'undefined' && window !== null ? window : global;

// was Java class DigitsSplitter

/**
 * Splits number into digits and converts each digit into LCD digit.
 */
exports.createConvertNumber = function(digitsOf, createDigit) {
    'use strict';

    // TODO Objects.requireNonNull(digitsOf);
    // TODO Objects.requireNonNull(createDigit);

    return function(number) {
        return digitsOf(number).map(createDigit);
    };

};
