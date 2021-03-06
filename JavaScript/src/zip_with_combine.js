exports = typeof window !== 'undefined' && window !== null ? window : global;

function zip(arrays) {
    'use strict';
    // see https://stackoverflow.com/a/10284006/104143
    return arrays[0].map(function(e, i) {
        return arrays.map(function(array) {
            return array[i];
        });
    });
}

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
exports.zipWithCombine = function(collections, combine) {
    'use strict';

    if (collections.length === 0) {
        return [];
    }

    return zip(collections).map(combine);
};
