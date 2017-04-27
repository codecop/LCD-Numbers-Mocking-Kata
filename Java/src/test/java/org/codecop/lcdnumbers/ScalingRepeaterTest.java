package org.codecop.lcdnumbers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScalingRepeaterTest {

    final ScalingRepeater repeater = new ScalingRepeater();
    // Can not mock Scaling because it is final for equals contract.
    // Also easier to use the real thing.

    @Test
    public void shouldRepeatCharacter() {
        String repeated = repeater.repeat('c', Scaling.of(2));

        assertEquals("cc", repeated);
    }

    @Test
    public void shouldRepeatElements() {
        List<String> repeated = repeater.repeat("T", Scaling.of(3));

        assertEquals(Arrays.asList("T", "T", "T"), repeated);
    }
}
