package org.codecop.lcdnumbers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class DigitScalerTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    Scaling scaling;
    @Mock
    private ScalingRepeater repeater;

    @Mock
    Line a1;
    @Mock
    Line a2;
    @Mock
    Digit a;
    @Mock
    Line b1;
    @Mock
    Line b2;
    @Mock
    Digit b;

    @Test
    public void shouldScaleEmptyDigit() {
        DigitScaler scaler = new DigitScaler(repeater);

        List<Digit> scaledDigits = scaler.scale(Collections.emptyList(), scaling);

        assertTrue(scaledDigits.isEmpty());
    }

    // TODO shouldNotScaleForScalingNone
    // when(scaling.none()).thenReturn(true);

    @Test
    public void shouldScale() {
        DigitScaler scaler = new DigitScaler(repeater);

        when(a.lines()).thenReturn(Arrays.asList(a1, a2));
        when(b.lines()).thenReturn(Arrays.asList(b1, b2));

        List<Digit> scaledDigits = scaler.scale(Arrays.asList(a, b), scaling);

        // TODO crap, this is too complex with mocks.
        // Need to use the real thing.
        // The collaborators are not proper, the coupling is high, the API is detailed. Brrr.
    }
}
