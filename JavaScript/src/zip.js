exports = typeof window !== "undefined" && window !== null ? window : global;

// see https://stackoverflow.com/questions/4856717/javascript-equivalent-of-pythons-zip-function

function zip(arrays) {
    // see https://stackoverflow.com/a/10284006/104143
    return arrays[0].map(function(_,i){
        return arrays.map(function(array){return array[i]})
    });
}

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
exports.zip = function(collections, combine) {
    // TODO Objects.requireNonNull(collections);
    // TODO Objects.requireNonNull(combine);

    var z1 = zip(collections);

    var zipped = [];

//    List<Iterator<T>> iterators = collections.stream(). //
//            map(Iterable::iterator). //
//            collect(Collectors.toList());
//
//    if (iterators.isEmpty()) {
//        return zipped;
//    }
//
//    Iterator<T> first = iterators.get(0);
//    while (first.hasNext()) {
//        List<T> nthElements = nextOfEach(iterators);
//        R joined = combine.combine(nthElements);
//        zipped.add(joined);
//    }

    return zipped;
};
