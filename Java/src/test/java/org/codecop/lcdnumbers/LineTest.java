package org.codecop.lcdnumbers;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LineTest {

    final String left = "a";
    final char middle = 'b';
    final String right = "c";
    final String replaced = "xx";
    final Scaling scaling = Scaling.NONE; // fake

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Line.class). //
                withNonnullFields("line"). //
                verify();
    }

    @Test
    public void shouldScaleMiddleCharacterHorizontally() {
        ScalingRepeater repeater = mock(ScalingRepeater.class);
        when(repeater.repeat(middle, scaling)).thenReturn(replaced);

        Line line = new Line(left + middle + right);
        Line scaledLine = line.scaleHorizontal(repeater, scaling);

        assertEquals(left + replaced + right, scaledLine.toString());
    }
}
