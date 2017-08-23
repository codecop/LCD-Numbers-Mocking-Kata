/* globals describe, it, zip */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/zip');

function addCombine(array) {
    return array.reduce(function (a, b) { return a + b; });
}

describe('zip', function () {

    it('should return single element', function () {
        var zipped = zip([ [1, 2, 3] ], addCombine);

        zipped.should.deep.equal([1, 2, 3]);
    });

    it('should merge two elements', function () {
        var zipped = zip([ [1, 2, 3], [1, 2, 3] ], addCombine);

        zipped.should.deep.equal([2, 4, 6]);
    });

});
