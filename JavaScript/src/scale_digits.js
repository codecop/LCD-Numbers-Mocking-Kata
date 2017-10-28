exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Returns a function that
 * scales x and y of digit lines.
 */
exports.createScaleDigits = function(scalingRepeat) {
    'use strict';

    function scale(digit, scaling) {

        if (scaling.none()) {
            return digit;
        }

        var scaled = [],
            oddLine = true;
        digit.lines().forEach(function(line) {
            var scaledLine = line.scaleHorizontal(scalingRepeat, scaling);
            if (oddLine) {
                scaled.push(scaledLine);
            } else {
                Array.prototype.push.apply(scaled, scalingRepeat(scaledLine, scaling));
            }
            oddLine = !oddLine;
        });

        return digit.scale(scaled);
    }

    return function(digits, scaling) {

        function scaleDigit(digit) {
            return scale(digit, scaling);
        }

        return digits.map(scaleDigit);
    };

};
