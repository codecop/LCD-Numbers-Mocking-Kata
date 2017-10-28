exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class ScalingRepeater

/**
 * Repeats objects and characters according to scaling.
 */
exports.scalingRepeat = function(element, scaling) {
    'use strict';

    // TODO Objects.requireNonNull(element);
    // TODO Objects.requireNonNull(scaling);

    var elements = [];
    scaling.times(function() {
        elements.push(element);
    });

    if (typeof element === 'string' || element instanceof String) {
        return elements.join('');
    }

    return elements;
};
