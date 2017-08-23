exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Appends lines next to each other and adds line breaks.
 */
exports.DigitPrinter = function(zip) {

    var NEWLINE = "\n";

    // TODO Objects.requireNonNull(zip);

    function linesOfAllDigits(digits) {
        return digits.map(function(digit) { return digit.lines(); });
    }

    function doZip(linesOfAllDigits) {
        return zip(linesOfAllDigits, concat);
    }

    function concat(lines) {
        return lines.map(function(line) { return line.toString(); }).
                reduce(function (a, b) { return a + b; });
    }

    function join(lines) {
        return lines.reduce(function (a, b) { return a + NEWLINE + b ; }) + NEWLINE;
    }

    this.render = function(digits) {
        // TODO Objects.requireNonNull(digits);

        var _linesOfAllDigits = linesOfAllDigits(digits);
        var linesSideBySide = doZip(_linesOfAllDigits);
        return join(linesSideBySide);
    };

};
