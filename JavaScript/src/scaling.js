exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class Scaling

/**
 * The scale factor value.
 */
function Scaling(times) {
    'use strict';

    if (times <= 0) {
        throw new RangeError('scaling factor must be >= 1');
    }

    this.none = function() {
        return times === 1;
    };

    this.times = function(block) {
        var i;
        // TODO Objects.requireNonNull(block);

        for (i = 0; i < times; i+=1) {
            block();
        }
    };

    this.toString = function() {
        return String(times);
    };

}

exports.Scaling = {};

exports.Scaling.NONE = new Scaling(1);
exports.Scaling.TWO = new Scaling(2);

exports.Scaling.of = function(t) {
    'use strict';
    return new Scaling(t);
};
