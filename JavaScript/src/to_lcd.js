exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Combines conversion, scaling and rendering.
 */
exports.createToLcd = function(convertNumber, scaleDigits, renderDigits) {
    'use strict';

    return function(number, scaling) {
        var digits = convertNumber(number),
            scaled = scaleDigits(digits, scaling);
        return renderDigits(scaled);
    };

};
