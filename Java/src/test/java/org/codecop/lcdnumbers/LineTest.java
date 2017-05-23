package org.codecop.lcdnumbers;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LineTest {

    final String left = "a";
    final char middle = 'b';
    final String right = "c";
    final String replaced = "bb";

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    Scaling scaling; // fake
    @Mock
    ScalingRepeater repeater; // stub

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Line.class). //
                withNonnullFields("line"). //
                verify();
    }

    /** 
     * @see ScalingRepeaterTest#shouldRepeatCharacter() for contract of stub.
     */
    @Test
    public void shouldScaleMiddleCharacterHorizontally() {
        when(repeater.repeat(middle, scaling)).thenReturn(replaced);

        Line line = new Line(left + middle + right);
        Line scaledLine = line.scaleHorizontal(repeater, scaling);

        assertEquals(left + replaced + right, scaledLine.toString());
    }
}
