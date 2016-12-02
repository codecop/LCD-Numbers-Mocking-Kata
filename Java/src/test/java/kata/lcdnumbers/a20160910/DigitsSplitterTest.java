package kata.lcdnumbers.a20160910;

import org.junit.Test;

import kata.lcdnumbers.a20160910.DigitFactory;
import kata.lcdnumbers.a20160910.DigitsSplitter;
import kata.lcdnumbers.a20160910.Patterns;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DigitsSplitterTest {

    @Test
    public void shouldConvertEachDigit() {
        Digit one = new Digit(1, new Patterns());
        Digit two = new Digit(2, new Patterns());
        Digit three = new Digit(3, new Patterns());
        DigitFactory c = mock(DigitFactory.class);
        when(c.create(1)).thenReturn(one);
        when(c.create(2)).thenReturn(two);
        when(c.create(3)).thenReturn(three);

        DigitsSplitter converter = new DigitsSplitter(c);

        assertEquals(Arrays.asList(one, two, three), converter.convert(123));
    }
}
