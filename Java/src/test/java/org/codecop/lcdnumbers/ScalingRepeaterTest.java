package org.codecop.lcdnumbers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

public class ScalingRepeaterTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    Scaling scaling;

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

    // force mock

    @Test
    public void shouldRepeatCharacterMocked() {
        doAnswer(invocation -> {
            Runnable runnable = invocation.getArgument(0);
            runnable.run();
            runnable.run();
            return null;
        }).when(scaling).times(any(Runnable.class));

        String repeated = repeater.repeat('c', scaling);

        assertEquals("cc", repeated);
    }

    @Test
    public void shouldRepeatElementsMocked() {
        doAnswer(invocation -> {
            Runnable runnable = invocation.getArgument(0);
            runnable.run();
            runnable.run();
            runnable.run();
            return null;
        }).when(scaling).times(any(Runnable.class));

        List<String> repeated = repeater.repeat("T", scaling);

        assertEquals(Arrays.asList("T", "T", "T"), repeated);
    }
}
