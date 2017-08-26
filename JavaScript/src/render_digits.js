exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class DigitPrinter

/**
 * Appends lines next to each other and adds line breaks.
 */
exports.createRenderDigits = function(zip) {

    var NEWLINE = "\n";

    // TODO Objects.requireNonNull(zip);

    function linesOfDigigit(digit) {
        return digit.lines();
    }

    function linesOfAllDigits(digits) {
        return digits.map(linesOfDigigit);
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

    return function(digits) {
        // TODO Objects.requireNonNull(digits);

        var allLines = linesOfAllDigits(digits);
        var linesSideBySide = doZip(allLines);
        return join(linesSideBySide);
    };

};
