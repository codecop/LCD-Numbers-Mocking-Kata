exports = typeof window !== "undefined" && window !== null ? window : global;

// Java class DigitScaler

/**
 * Scales x and y of digit lines.
 */
exports.createScaleDigits = function(scalingRepeat) {

    // TODO Objects.requireNonNull(scalingRepeat);

    function scale(digit, scaling) {
        // TODO Objects.requireNonNull(digit);
        // TODO Objects.requireNonNull(scaling);

        if (scaling.none()) {
            return digit;
        }

        var scaled = [];

        var oddLine = true;
        for (Line line : digit.lines()) {
            var scaledLine = line.scaleHorizontal(scalingRepeat, scaling);
            if (oddLine) {
                scaled.push(scaledLine);
            } else {
                scaled += scalingRepeat(scaledLine, scaling);
            }
            oddLine = !oddLine;
        }

        return digit.scale(scaled);
    }

    return function(digits, scaling) {
        // TODO Objects.requireNonNull(digits);
        // TODO Objects.requireNonNull(scaling);
        return digits.map(function(d) { return scale(d, scaling); });
    };
];
