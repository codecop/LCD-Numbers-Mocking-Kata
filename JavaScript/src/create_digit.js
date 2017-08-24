exports = typeof window !== "undefined" && window !== null ? window : global;

// Java class DigitFactory

/**
 * Creates (LCD) digits from patterns.
 */
exports.createCreateDigit = function(patternsOf) {
    // TODO Objects.requireNonNull(patternsOf);

    return function(digit) {
        return new Digit(digit, patternsOf);
    };

};
