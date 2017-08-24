/* globals describe, it, zipWithCombine */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/zip_with_combine');

function addCombine(array) {
    return array.reduce(function (a, b) { return a + b; });
}

describe('zipWithCombine', function () {

    it('should return single element', function () {
        var zipped = zipWithCombine([ [1, 2, 3] ], addCombine);

        zipped.should.deep.equal([1, 2, 3]);
    });

    it('should merge two elements', function () {
        var zipped = zipWithCombine([ [1, 2, 3], [1, 2, 3] ], addCombine);

        zipped.should.deep.equal([2, 4, 6]);
    });

});
