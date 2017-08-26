exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class LcdDisplay

/**
 * Combines Converter, Scaler and Printer.
 */
exports.createToLcd = function(convertNumber, scaleDigits, renderDigits) {

    // TODO Objects.requireNonNull(convertNumber);
    // TODO Objects.requireNonNull(scaleDigits);
    // TODO Objects.requireNonNull(renderDigits);

    return function (number, scaling) {
        // TODO Objects.requireNonNull(scaling);

        var digits = convertNumber(number);
        var scaled = scaleDigits(digits, scaling);
        return renderDigits(scaled);
    };
};
