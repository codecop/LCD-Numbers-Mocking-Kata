/* globals describe, it */
'use strict';

var chai = require('chai');
var should = chai.should();
// var expect = chai.expect;
// var assert = chai.assert;

function hello() {
    return "hello world";
}

describe('hello', function() {

    it('should say hello', function() {
        hello().should.equal('hello world');
    });

});
