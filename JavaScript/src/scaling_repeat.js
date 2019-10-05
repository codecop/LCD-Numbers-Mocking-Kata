exports = typeof window !== 'undefined' && window !== null ? window : global;

/**
 * Repeats objects and characters according to scaling.
 */
exports.scalingRepeat = function(element, scaling) {
    'use strict';

    var elements = [];
    scaling.times(function() {
        elements.push(element);
    });

    if (typeof element === 'string' || element instanceof String) {
        return elements.join('');
    }

    return elements;
};
