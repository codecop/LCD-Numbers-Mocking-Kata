/* globals describe, it, beforeEach, afterEach, Scaling */
'use strict';

var chai = require('chai');
var should = chai.should();
var expect = chai.expect;
var sinon = require('sinon');

require('../src/scaling');

describe('Scaling', function() {
    var callback; // mock

    beforeEach(function() {
        callback = sinon.spy();
    });

    it('should report if scaling', function() {
        Scaling.of(1).none().should.equal(true);
        Scaling.of(2).none().should.equal(false);
    });

    it('should scale according factor', function() {
        var factor = 3;
        var threeTimes = Scaling.of(factor);

        threeTimes.times(callback);

        callback.callCount.should.equal(factor);
    });

    it('should not scale for factor one', function() {
        // tests constant to be 1
        Scaling.NONE.times(callback);

        callback.callCount.should.equal(1);
    });

    it('should fail on non positive scale values', function() {
        expect(function() {
            Scaling.of(0);
        }).to.throw(RangeError);
    });

});
