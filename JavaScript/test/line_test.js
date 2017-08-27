/* globals describe, it, beforeEach, Line */
'use strict';

var chai = require('chai');
var should = chai.should();
var sinon = require('sinon');

require('../src/line');

var left = 'a';
var middle = 'b';
var right = 'c';
var replaced = 'bb';

describe('Line', function() {
    var scaling; // fake object
    var repeat; // stub function

    beforeEach(function() {
        scaling = {};
    });

    it('should scale middle character horizontally', function() {
        repeat = sinon.stub().withArgs(middle, scaling).returns(replaced);

        var line = new Line(left + middle + right);
        var scaledLine = line.scaleHorizontal(repeat, scaling);

        scaledLine.toString().should.equal(left + replaced + right);
    });

});
