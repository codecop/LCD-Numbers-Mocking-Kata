package org.codecop.lcdnumbers;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DigitTest {

    @Rule
    public ExpectedException caughtException = ExpectedException.none();

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Digit.class).//
                withIgnoredFields("lines").
                verify();
    }

    @Test
    public void shouldFailWhenScalingWithFewerLines() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Collections.singletonList(new Line("dummy")));
        Digit digit = new Digit(1, patterns);

        caughtException.expect(IllegalArgumentException.class);
        // PIT forces me to over specify message
        caughtException.expectMessage("Scaled lines must be more than original ones: 0>=1");

        List<Line> fewLines = Collections.emptyList();
        digit.scale(fewLines);
    }

    @Test
    public void shouldReplaceLinesWhenScalingWithSameSize() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Collections.singletonList(new Line("dummy")));
        Digit digit = new Digit(1, patterns);

        List<Line> sameLines = Collections.singletonList(new Line("scaled"));
        Digit scaledDigit = digit.scale(sameLines);

        assertEquals(sameLines, scaledDigit.lines());
    }

    @Test
    public void shouldReplaceLinesWhenScalingWithMoreLines() {
        Patterns patterns = mock(Patterns.class);
        when(patterns.of(1)).thenReturn(Collections.singletonList(new Line("dummy")));
        Digit digit = new Digit(1, patterns);

        List<Line> moreLines = Arrays.asList(new Line("111"), new Line("222"));
        Digit scaledDigit = digit.scale(moreLines);

        assertEquals(moreLines, scaledDigit.lines());
    }

}
