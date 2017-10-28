exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Value Object of an LCD digit line.
 */
function Line(line) {
    'use strict';

    this.scaleHorizontal = function(repeat, scaling) {
        return new Line(line.charAt(0) + repeat(line.charAt(1), scaling) + line.charAt(2));
    };

    this.toString = function() {
        return line;
    };

}

exports.Line = Line;
