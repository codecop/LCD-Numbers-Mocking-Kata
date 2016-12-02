package org.codecop.lcdnumbers;

import org.codecop.lcdnumbers.Digit;
import org.codecop.lcdnumbers.DigitPrinter;
import org.codecop.lcdnumbers.DigitScaler;
import org.codecop.lcdnumbers.DigitsSplitter;
import org.codecop.lcdnumbers.LcdDisplay;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LcdDisplayTest {

    @Test
    public void shouldConvertAndRenderSingleNumberIntoLCD() {
        Digit lcdOfDigit1 = mock(Digit.class);

        DigitsSplitter digitsSplitter = mock(DigitsSplitter.class);
        List<Digit> digits = Collections.singletonList(lcdOfDigit1);
        when(digitsSplitter.convert(1)).thenReturn(digits);

        DigitScaler digitScaler = mock(DigitScaler.class);
        when(digitScaler.scale(digits, 1)).thenReturn(digits);

        DigitPrinter digitPrinter = mock(DigitPrinter.class);
        String lcdTextOfDigit1 = "irrelevant";
        when(digitPrinter.render(digits)).thenReturn(lcdTextOfDigit1);

        LcdDisplay lcdDisplay = new LcdDisplay(digitsSplitter, digitScaler, digitPrinter);

        assertEquals(lcdTextOfDigit1, lcdDisplay.toLcd(1, 1));
    }
}
