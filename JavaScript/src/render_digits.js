exports = typeof window !== 'undefined' && window !== null ? window : global;

var NEWLINE = "\n";

/**
 * Returns a function that
 * appends digits' lines next to each other and adds line breaks.
 */
exports.createRenderDigits = function(zip) {
    'use strict';

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
        var allLines = linesOfAllDigits(digits),
            linesSideBySide = doZip(allLines);
        return join(linesSideBySide);
    };

};
