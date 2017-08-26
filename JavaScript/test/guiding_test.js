/* globals describe, it, beforeEach, to_lcd */
'use strict';

var chai = require('chai');
var should = chai.should();

require('../src/to_lcd');
    require('../src/convert_number');
        require('../src/digits_of');
        require('../src/create_digit');
                require('../src/line');
            require('../src/patterns_of');

    require('../src/scale_digits');
        require('../src/scaling_repeat');

    require('../src/render_digits');
        require('../src/zip_with_combine');

require('../src/scaling');

describe('to_lcd', function () {
    var toLcd;

    beforeEach(function() {
        toLcd = createToLcd( //
            // new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
            createConvertNumber(createDigitsOf(), createCreateDigit(patternsOf)), //
            // new DigitScaler(new ScalingRepeater()), //
            createScaleDigits(scalingRepeat),
            // new DigitPrinter(new Zipper()));
            createRenderDigits(zipWithCombine)
        );
    });

    it('should print LCD size one', function () {
        var lcd = toLcd(123, Scaling.NONE);
        lcd.should.equal("    -  - \n" + //
                         "  |  |  |\n" + //
                         "    -  - \n" + //
                         "  ||    |\n" + //
                         "    -  - \n");
    });

//    @Test
//    public void shouldPrintLcdSizeTwo() {
//        String lcd = lcdDisplay.toLcd(123, Scaling.TWO);
//        assertEquals("     --  -- \n" + //
//                     "   |   |   |\n" + //
//                     "   |   |   |\n" + //
//                     "     --  -- \n" + //
//                     "   ||      |\n" + //
//                     "   ||      |\n" + //
//                     "     --  -- \n", lcd);
//    }
//
//    @Test
//    public void shouldPrintLcdSizeThree() {
//        String lcd = lcdDisplay.toLcd(123, Scaling.of(3));
//        assertEquals("      ---  --- \n" + //
//                     "    |    |    |\n" + //
//                     "    |    |    |\n" + //
//                     "    |    |    |\n" + //
//                     "      ---  --- \n" + //
//                     "    ||        |\n" + //
//                     "    ||        |\n" + //
//                     "    ||        |\n" + //
//                     "      ---  --- \n", lcd);
//    }
//
//    @Test @Ignore("can not find file in kata project")
//    public void shouldPrintAllNumbersLcdSizeThree() throws IOException, URISyntaxException {
//        String lcd = lcdDisplay.toLcd(1234567890, Scaling.of(3));
//        String expected = read("/numbers grid 5x9 - size 3.txt");
//        assertEquals(expected, lcd);
//    }
//
//    private String read(String name) throws IOException, URISyntaxException {
//        URL classpathResource = getClass().getResource(name);
//        Path fileSystemResource = Paths.get(classpathResource.toURI());
//        return Files.readAllLines(fileSystemResource). //
//                stream(). //
//                collect(Collectors.joining("\n", "", "\n"));
//    }

});
