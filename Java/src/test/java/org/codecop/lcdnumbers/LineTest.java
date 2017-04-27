package org.codecop.lcdnumbers;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LineTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Line.class).//
                withNonnullFields("line"). //
                verify();
    }

    @Test
    public void shouldScaleHorizontal() {
        Line line = new Line("abc");
        ScalingRepeater repeater = mock(ScalingRepeater.class);
        Scaling scale = Scaling.NONE; // fake
        when(repeater.repeat('b', scale)).thenReturn("xx");

        Line scaledLine = line.scaleHorizontal(repeater, scale);

        assertEquals("axxc", scaledLine.toString());
    }
}
