exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class LcdDisplay

/**
 * Combines conversion, scaling and rendering.
 */
exports.createToLcd = function(convertNumber, scaleDigits, renderDigits) {
    'use strict';

    // TODO Objects.requireNonNull(convertNumber);
    // TODO Objects.requireNonNull(scaleDigits);
    // TODO Objects.requireNonNull(renderDigits);

    return function(number, scaling) {

        // TODO Objects.requireNonNull(number);
        // TODO Objects.requireNonNull(scaling);

        var digits = convertNumber(number),
            scaled = scaleDigits(digits, scaling);
        return renderDigits(scaled);
    };

};
