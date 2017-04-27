package org.codecop.lcdnumbers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DigitPrinterTest {

    final DigitPrinter printer = new DigitPrinter(new Zipper());
    // Zipper feels technical, so it is rather a helper than a real collaborator.

    @Test
    public void shouldRenderEmptyDigit() {
        // maybe it should not because it does not make sense for business
        String display = printer.render(Collections.emptyList());

        assertEquals("\n", display);
    }

    @Test
    public void shouldRenderDigitsSideBySide() {
        Digit one = from("A1", //
                         "A2");
        Digit two = from("B1", //
                         "B2");

        String display = printer.render(Arrays.asList(one, two));

        assertEquals("A1B1\n" + //
                     "A2B2\n", display);
    }

    private Digit from(String line1, String line2) {
        Digit digit = mock(Digit.class);
        List<Line> lines = Arrays.asList(new Line(line1), new Line(line2));
        when(digit.lines()).thenReturn(lines);
        return digit;
    }

}
