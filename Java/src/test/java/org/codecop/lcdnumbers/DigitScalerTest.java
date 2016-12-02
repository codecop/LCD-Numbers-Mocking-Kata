package org.codecop.lcdnumbers;

import org.codecop.lcdnumbers.Digit;
import org.codecop.lcdnumbers.DigitScaler;
import org.codecop.lcdnumbers.Line;
import org.codecop.lcdnumbers.Patterns;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DigitScalerTest {

    private final DigitScaler digitScaler = new DigitScaler();

    @Test
    public void shouldScaleHorizontal() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Collections.singletonList(new Line(" - ")));
        Digit digit = new Digit(1, patterns);

        Digit scaled = digitScaler.scale(digit, 2);

        assertEquals(Collections.singletonList(new Line(" -- ")), scaled.lines());
    }

    @Test
    public void shouldScaleVertical() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Arrays.asList(new Line(" - "), new Line("  |"), new Line(" - ")));
        Digit digit = new Digit(1, patterns);

        Digit scaled = digitScaler.scale(digit, 2);

        assertEquals(Arrays.asList(new Line(" -- "), new Line("   |"), new Line("   |"), new Line(" -- ")), scaled.lines());
    }

    @Test
    public void shouldNotScaleOne() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Arrays.asList(new Line(" - "), new Line("  |"), new Line(" - ")));
        Digit digit = new Digit(1, patterns);

        Digit scaled = digitScaler.scale(digit, 1);

        assertEquals(Arrays.asList(new Line(" - "), new Line("  |"), new Line(" - ")), scaled.lines());
    }
}
