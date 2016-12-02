package kata.lcdnumbers.a20160910;

import org.junit.Test;

import kata.lcdnumbers.a20160910.DigitPrinter;
import kata.lcdnumbers.a20160910.Line;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DigitPrinterTest {
    @Test
    public void testShouldPrintOne() {
        Digit one = mock(Digit.class);
        when(one.lines()).thenReturn(Arrays.asList(new Line("   "), new Line("  |")));
        DigitPrinter printer = new DigitPrinter();
        assertEquals("   \n" + //
                     "  |\n", printer.render(Collections.singletonList(one)));
    }

    @Test
    public void testShouldPrintSequence() {
        Digit one = mock(Digit.class);
        when(one.lines()).thenReturn(Arrays.asList(new Line(" - "), new Line("  |")));
        DigitPrinter printer = new DigitPrinter();
        assertEquals(" -  - \n" + //
                     "  |  |\n", printer.render(Arrays.asList(one, one)));
    }
}
