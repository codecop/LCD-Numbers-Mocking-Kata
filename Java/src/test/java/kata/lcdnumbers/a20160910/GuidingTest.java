package kata.lcdnumbers.a20160910;

import org.junit.Test;

import kata.lcdnumbers.a20160910.DigitFactory;
import kata.lcdnumbers.a20160910.DigitPrinter;
import kata.lcdnumbers.a20160910.DigitScaler;
import kata.lcdnumbers.a20160910.DigitsSplitter;
import kata.lcdnumbers.a20160910.LcdDisplay;
import kata.lcdnumbers.a20160910.Patterns;

import static org.junit.Assert.assertEquals;

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
