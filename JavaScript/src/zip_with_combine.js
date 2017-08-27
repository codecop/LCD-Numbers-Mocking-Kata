exports = typeof window !== 'undefined' && window !== null ? window : global;

// Java class Zipper

function zip(arrays) {
    // see https://stackoverflow.com/a/10284006/104143
    return arrays[0].map(function(_, i) {
        return arrays.map(function(array) {
            return array[i];
        });
    });
}

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
exports.zipWithCombine = function(collections, combine) {

    // TODO Objects.requireNonNull(collections);
    // TODO Objects.requireNonNull(combine);

    if (collections.length === 0) {
        return [];
    }

    return zip(collections).map(combine);
};
