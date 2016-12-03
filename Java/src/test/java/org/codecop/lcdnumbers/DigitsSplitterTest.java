package org.codecop.lcdnumbers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DigitsSplitterTest {

    @Test
    public void shouldConvertEachDigit() {
        List<Integer> digits = Arrays.asList(1, 2, 3);
        NumeralSystem system = mock(NumeralSystem.class);
        when(system.digitsOf(123)).thenReturn(digits);

        Digit one = new Digit(1, new Patterns());
        Digit two = new Digit(2, new Patterns());
        Digit three = new Digit(3, new Patterns());
        DigitFactory factory = mock(DigitFactory.class);
        when(factory.create(1)).thenReturn(one);
        when(factory.create(2)).thenReturn(two);
        when(factory.create(3)).thenReturn(three);

        DigitsSplitter converter = new DigitsSplitter(system, factory);

        assertEquals(Arrays.asList(one, two, three), converter.convert(123));
    }
}
