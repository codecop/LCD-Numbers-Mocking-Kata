exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class DigitFactory

/**
 * Creates an (LCD) digit from its pattern.
 */
exports.createCreateDigit = function(patternsOf) {

    // TODO Objects.requireNonNull(patternsOf);

    return function(digit) {
        return new Digit(digit, patternsOf);
    };

};
