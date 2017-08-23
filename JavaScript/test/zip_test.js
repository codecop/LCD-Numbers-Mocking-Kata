/* globals describe, it, zip */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/zip');

describe('zip', function () {

    it('should return single element', function () {
        var zipped = zip([ [1, 2, 3] ], function(a, b) {
            return a + b;
        });

        zipped.should.deep.equal([1, 2, 3]);
    });

    it('should merge two elements', function () {
        var zipped = zip([ [1, 2, 3], [1, 2, 3] ], function(a, b) {
            return a + b;
        });

        zipped.should.deep.equal([2, 4, 6]);
    });

});
