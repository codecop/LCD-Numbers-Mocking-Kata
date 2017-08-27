/* globals describe, it, scalingRepeat, Scaling */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/scaling_repeat');
require('../src/scaling');

describe('scalingRepeat', function() {

    it('should repeat character', function() {
        var repeated = scalingRepeat('c', Scaling.of(3));

        repeated.should.equal('ccc');
    });

    it('should repeat elements', function() {
        var repeated = scalingRepeat({ id : 1 }, Scaling.of(2));

        repeated.should.deep.equal([ { id : 1 }, { id : 1 } ]);
    });

});
