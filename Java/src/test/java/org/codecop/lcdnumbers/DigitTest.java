package org.codecop.lcdnumbers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class DigitTest {
    
    @Test
    public void shouldKnowLinesOfOne() {
        Patterns patterns = mock(Patterns.class);
        List<Line> lines = Arrays.asList(new Line("   "), new Line("  |"));
        when(patterns.of(1)).thenReturn(lines);

        Digit digit = new Digit(1, patterns);

        verify(patterns).of(1);
        assertEquals(lines, digit.lines());
    }
}
