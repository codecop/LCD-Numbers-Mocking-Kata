package org.codecop.lcdnumbers;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PatternsTest {
    @Test
    public void shouldKnowLinesOfOne() {
        Patterns patterns = new Patterns();
        assertEquals(Arrays.asList(new Line("   "), //
                                   new Line("  |"), //
                                   new Line("   "), //
                                   new Line("  |"), //
                                   new Line("   ")), patterns.of(1));
    }
}
