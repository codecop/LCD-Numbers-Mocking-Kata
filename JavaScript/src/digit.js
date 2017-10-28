exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class Digit

/**
 * Value object of an LCD digit.
 */
function Digit(digit, patternsOf) {
    'use strict';

    // TODO Objects.requireNonNull(digit);
    // TODO Objects.requireNonNull(patternsOf);

    var lines = patternsOf(digit);
    // TODO Objects.requireNonNull(lines);

    this.lines = function() {
        return lines;
    };

    this.scale = function(scaledLines) {
        // TODO Objects.requireNonNull(scaledLines);

        var linesCount = lines.length,
            scaledCount = scaledLines.length;
        if (scaledCount < linesCount) {
            throw new RangeError('Scaled lines must be more than original ones: ' + scaledCount + '>=' + linesCount);
        }

        function patternOfScaledLines() {
            return scaledLines;
        }

        return new Digit(digit, patternOfScaledLines);
    };

    this.toString = function() {
        return String(digit);
    };

}

exports.Digit = Digit;
