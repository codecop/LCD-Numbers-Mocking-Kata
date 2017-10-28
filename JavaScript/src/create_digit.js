exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Returns a function that
 * creates an (LCD) digit from its pattern.
 */
exports.createCreateDigit = function(patternsOf) {
    'use strict';

    return function(digit) {
        return new Digit(digit, patternsOf);
    };

};
