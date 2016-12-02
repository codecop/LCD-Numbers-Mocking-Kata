package kata.lcdnumbers.a20160910;

import org.junit.Test;

import kata.lcdnumbers.a20160910.DigitPrinter;
import kata.lcdnumbers.a20160910.DigitScaler;
import kata.lcdnumbers.a20160910.DigitsSplitter;
import kata.lcdnumbers.a20160910.LcdDisplay;

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
