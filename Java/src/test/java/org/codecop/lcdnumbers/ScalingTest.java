package org.codecop.lcdnumbers;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ScalingTest {

    final Runnable block = mock(Runnable.class);

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Scaling.class).verify();
    }

    @Test
    public void shouldReportIfScaling() {
        assertTrue(Scaling.of(1).none());
        assertFalse(Scaling.of(2).none());
    }

    @Test
    public void shouldScaleAccordingFactor() {
        int factor = 3;
        Scaling threeTimes = Scaling.of(factor);

        threeTimes.times(block);

        verify(block, times(factor)).run();
    }

    @Test
    public void shouldNotScaleForFactorOne() {
        // tests constant to be 1
        Scaling.NONE.times(block);

        verify(block, times(1)).run();
    }
}
