exports = typeof window !== "undefined" && window !== null ? window : global;

/**
 * The scale factor value.
 */
function Scaling(times) {
    if (times <= 0) {
        // TODO JS exception
        throw new IllegalArgumentException("scaling factor must be >= 1");
    }

    this.none = function() {
        return times === 1;
    }

    this.times = function(block) {
        var i;
        // TODO Objects.requireNonNull(block);

        for (i = 0; i < times; i++) {
            block();
        }
    }

    this.toString = function() {
        return "" + times;
    };

}

exports.Scaling = {};

exports.Scaling.NONE = new Scaling(1);
exports.Scaling.TWO = new Scaling(2);

exports.Scaling.of = function(t) {
    return new Scaling(t);
};
