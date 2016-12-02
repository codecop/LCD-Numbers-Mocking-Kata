package org.codecop.lcdnumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.codecop.lcdnumbers.DigitFactory;
import org.codecop.lcdnumbers.DigitPrinter;
import org.codecop.lcdnumbers.DigitScaler;
import org.codecop.lcdnumbers.DigitsSplitter;
import org.codecop.lcdnumbers.LcdDisplay;
import org.codecop.lcdnumbers.Patterns;

public class GuidingTest {

    private final LcdDisplay lcdDisplay = new LcdDisplay( //
            new DigitsSplitter(new DigitFactory(new Patterns())), //
            new DigitScaler(),
            new DigitPrinter());

    @Test
    public void shouldPrintLcdSizeOne() {
        String lcd = lcdDisplay.toLcd(123, 1);
        assertEquals("    -  - \n" + //
                     "  |  |  |\n" + //
                     "    -  - \n" + //
                     "  ||    |\n" + //
                     "    -  - \n", lcd);
    }

    @Test
    public void shouldPrintLcdSizeTwo() {
        String lcd = lcdDisplay.toLcd(123, 2);
        assertEquals("     --  -- \n" + //
                     "   |   |   |\n" + //
                     "   |   |   |\n" + //
                     "     --  -- \n" + //
                     "   ||      |\n" + //
                     "   ||      |\n" + //
                     "     --  -- \n", lcd);
    }

    @Test
    public void shouldPrintLcdSizeThree() {
        String lcd = lcdDisplay.toLcd(123, 3);
        assertEquals("      ---  --- \n" + //
                     "    |    |    |\n" + //
                     "    |    |    |\n" + //
                     "    |    |    |\n" + //
                     "      ---  --- \n" + //
                     "    ||        |\n" + //
                     "    ||        |\n" + //
                     "    ||        |\n" + //
                     "      ---  --- \n", lcd);
    }
}
