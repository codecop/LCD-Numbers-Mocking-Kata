/* globals describe, it, patternsOf, Line */
'use strict';

var chai = require('chai');
var should = chai.should();
var expect = chai.expect;

require('../src/patterns_of');
require('../src/Line');

describe('patternsOf', function() {

    it('should return pattern 1', function() {
        patternsOf(1).map(function(line) { 
            return line.toString(); 
        }).should.deep.equal(['   ', '  |', '   ', '  |', '   ']);
    });

    it('should fail on unknown digit', function() {
        expect(function() {
            patternsOf(42);
        }).to.throw(RangeError);
    });

});
