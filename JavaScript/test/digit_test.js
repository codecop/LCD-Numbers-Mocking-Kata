/* globals describe, it, beforeEach, Digit */
'use strict';

var chai = require('chai');
var should = chai.should();
var expect = chai.expect;
var sinon = require('sinon');

require('../src/digit');

describe('Digit', function () {

    var originalLine;
    var anotherLine;
    var secondLine;

    var digit;

    beforeEach(function() {
        var someLines = [ originalLine ];
        var patternsOf = sinon.stub().withArgs(1).returns(someLines);

        digit = new Digit(1, patternsOf);
    });

    it('should replace lines when scaling with same size', function () {
        var sameLines = [ anotherLine ];

        var scaledDigit = digit.scale(sameLines);

        scaledDigit.lines().should.deep.equal(sameLines);
    });

    it('should replace lines when scaling with more size', function () {
        var moreLines = [ anotherLine, secondLine ];

        var scaledDigit = digit.scale(moreLines);

        scaledDigit.lines().should.deep.equal(moreLines);
    });

// TODO error
//    it('should fail when scaling with fewer lines', function () {
//        var fewerLines = [ ];
//
//        expect(function() {
//            digit.scale(fewerLines);
//        }).to.throw(IllegalArgumentException);
//    });

});
