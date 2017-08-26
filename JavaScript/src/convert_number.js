exports = typeof window !== "undefined" && window !== null ? window : global;

// Java class DigitsSplitter

/**
 * Splits into digits and converts digits to LCD digits.
 */
exports.createConvertNumber = function(digitsOf, createDigit) {

    // TODO Objects.requireNonNull(digitsOf);
    // TODO Objects.requireNonNull(createDigit);

    return function(number) {
        return digitsOf(number).map(createDigit);
    };

};
