exports = typeof window !== "undefined" && window !== null ? window : global;

/**
 * Value Object of an LCD digit.
 */
function Digit(digit, patternsOf) {
    // TODO Objects.requireNonNull(digit);
    // TODO Objects.requireNonNull(patternsOf);
    var lines = patternsOf(digit);
    // TODO Objects.requireNonNull(lines);

    this.lines = function() {
        return lines;
    };

    this.scale = function(scaledLines) {
        // TODO Objects.requireNonNull(scaledLines);

        var linesCount = lines.length;
        var scaledCount = scaledLines.length;
        if (scaledCount < linesCount) {
            throw new IllegalArgumentException("Scaled lines must be more than original ones: " + scaledCount + ">=" + linesCount);
        }

        return new Digit(digit, function() { return scaledLines; });
    }

    this.toString = function() {
        return "" + digit;
    };

};

exports.Digit = Digit;
