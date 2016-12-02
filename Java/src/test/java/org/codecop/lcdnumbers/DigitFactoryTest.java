package org.codecop.lcdnumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.codecop.lcdnumbers.Digit;
import org.codecop.lcdnumbers.DigitFactory;
import org.codecop.lcdnumbers.Patterns;

public class DigitFactoryTest {
    @Test
    public void shouldConvertOne() {
        Patterns patterns = new Patterns();
        Digit one = new Digit(1, patterns);
        // now what makes a one with size 1?
        // We only see that during rendering because we do not want to expose inner state.
        // this is like cheating because there is not logic now, just delaying the problem.
        DigitFactory factory = new DigitFactory(patterns);

        assertEquals(one, factory.create(1));
    }
}
