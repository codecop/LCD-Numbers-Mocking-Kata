package org.codecop.lcdnumbers;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DigitTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    Line originalLine;
    @Mock
    Line anotherLine;
    @Mock
    Line secondLine;

    Digit digit;

    @Rule
    public ExpectedException caughtException = ExpectedException.none();

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Digit.class).//
                withIgnoredFields("lines").
                verify();
    }

    @Before
    public void patternForOne() {
        Patterns patterns = mock(Patterns.class); // stub
        List<Line> someLines = Collections.singletonList(originalLine);
        when(patterns.of(1)).thenReturn(someLines);

        digit = new Digit(1, patterns);
    }

    @Test
    public void shouldFailWhenScalingWithFewerLines() {
        caughtException.expect(IllegalArgumentException.class);
        caughtException.expectMessage("Scaled lines must be more than original ones: 0>=1");
        // PIT forces me to over specify message

        List<Line> fewerLines = Collections.emptyList();
        digit.scale(fewerLines);
    }

    @Test
    public void shouldReplaceLinesWhenScalingWithSameSize() {
        List<Line> sameLines = Collections.singletonList(anotherLine);

        Digit scaledDigit = digit.scale(sameLines);

        assertEquals(sameLines, scaledDigit.lines());
    }

    @Test
    public void shouldReplaceLinesWhenScalingWithMoreLines() {
        List<Line> moreLines = Arrays.asList(anotherLine, secondLine);

        Digit scaledDigit = digit.scale(moreLines);

        assertEquals(moreLines, scaledDigit.lines());
    }

}
