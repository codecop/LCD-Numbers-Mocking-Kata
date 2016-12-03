package org.codecop.lcdnumbers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DigitScalerTest {

    private final DigitScaler digitScaler = new DigitScaler(new ScalingRepeater());

    @Test
    public void shouldScaleHorizontal() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Collections.singletonList(new Line(" - ")));
        Digit digit = new Digit(1, patterns);

        List<Digit> scaled = digitScaler.scale(Arrays.asList(digit), Scaling.TWO);

        assertEquals(Collections.singletonList(new Line(" -- ")), scaled.get(0).lines());
    }

    @Test
    public void shouldScaleVertical() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Arrays.asList(new Line(" - "), new Line("  |"), new Line(" - ")));
        Digit digit = new Digit(1, patterns);

        List<Digit> scaled = digitScaler.scale(Arrays.asList(digit), Scaling.TWO);

        assertEquals(Arrays.asList(new Line(" -- "), new Line("   |"), new Line("   |"), new Line(" -- ")), scaled.get(0).lines());
    }

    @Test
    public void shouldNotScaleOne() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Arrays.asList(new Line(" - "), new Line("  |"), new Line(" - ")));
        Digit digit = new Digit(1, patterns);

        List<Digit> scaled = digitScaler.scale(Arrays.asList(digit), Scaling.NONE);

        assertEquals(Arrays.asList(new Line(" - "), new Line("  |"), new Line(" - ")), scaled.get(0).lines());
    }
}
