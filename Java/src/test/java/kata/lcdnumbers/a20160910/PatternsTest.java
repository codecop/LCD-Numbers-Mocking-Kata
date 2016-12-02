package kata.lcdnumbers.a20160910;

import org.junit.Test;

import kata.lcdnumbers.a20160910.Line;
import kata.lcdnumbers.a20160910.Patterns;

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
