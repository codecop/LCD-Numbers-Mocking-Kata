exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class DigitPrinter

var NEWLINE = "\n";

/**
 * Appends digits' lines next to each other and adds line breaks.
 */
exports.createRenderDigits = function(zip) {

    // TODO Objects.requireNonNull(zip);

    function linesOfDigigit(digit) {
        return digit.lines();
    }

    function linesOfAllDigits(digits) {
        return digits.map(linesOfDigigit);
    }

    function concat(lines) {
        return lines.map(function(line) {
            return line.toString();
        }).reduce(function(a, b) {
            return a + b;
        });
    }

    function doZip(linesOfAllDigits) {
        return zip(linesOfAllDigits, concat);
    }

    function join(lines) {
        return lines.reduce(function(a, b) {
            return a + NEWLINE + b;
        }) + NEWLINE;
    }

    return function(digits) {
        // TODO Objects.requireNonNull(digits);

        var allLines = linesOfAllDigits(digits);
        var linesSideBySide = doZip(allLines);
        return join(linesSideBySide);
    };

};
