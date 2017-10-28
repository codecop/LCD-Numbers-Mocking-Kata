exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class DigitScaler

/**
 * Scales x and y of digit lines.
 */
exports.createScaleDigits = function(scalingRepeat) {
    'use strict';

    // TODO Objects.requireNonNull(scalingRepeat);

    function scale(digit, scaling) {
        // TODO Objects.requireNonNull(digit);
        // TODO Objects.requireNonNull(scaling);

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
        // TODO Objects.requireNonNull(digits);
        // TODO Objects.requireNonNull(scaling);

        function scaleDigit(digit) {
            return scale(digit, scaling);
        }

        return digits.map(scaleDigit);
    };

};
