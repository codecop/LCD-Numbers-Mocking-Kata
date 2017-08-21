/* globals describe, it, expect, beforeEach, afterEach, Scaling */
'use strict';

var chai = require('chai');
var should = chai.should();
// var expect = chai.expect;
// var assert = chai.assert;

require('../src/scaling');
console.log(Scaling);

describe('Scaling', function () {

    it('should report if scaling', function () {
        Scaling.of(1).none().should.equal(true);
        Scaling.of(2).none().should.equal(false);
    });

//    @Test
//    public void shouldScaleAccordingFactor() {
//        int factor = 3;
//        Scaling threeTimes = Scaling.of(factor);
//
//        threeTimes.times(block);
//
//        verify(block, times(factor)).run();
//    }
//
//    @Test
//    public void shouldNotScaleForFactorOne() {
//        // tests constant to be 1
//        Scaling.NONE.times(block);
//
//        verify(block, times(1)).run();
//    }

});


//    @Mock
//    Runnable block; // mock

//    @Test
//    public void equalsContract() {
//        EqualsVerifier.forClass(Scaling.class).verify();
//    }
