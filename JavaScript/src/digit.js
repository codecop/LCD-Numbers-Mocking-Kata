exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Value object of an LCD digit.
 */
function Digit(digit, patternsOf) {
    'use strict';

    var lines = patternsOf(digit);

    this.lines = function() {
        return lines;
    };

    this.scale = function(scaledLines) {

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
