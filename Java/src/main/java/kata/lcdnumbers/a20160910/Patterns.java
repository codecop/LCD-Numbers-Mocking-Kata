package kata.lcdnumbers.a20160910;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Knows the initial pattern of each LCD digit.
 */
public class Patterns {
    private final Map<Integer, List<Line>> lcdByDigit = new HashMap<>();

    public Patterns() {
        put(1, new Line("   "), //
               new Line("  |"), //
               new Line("   "), //
               new Line("  |"), //
               new Line("   "));
        put(2, new Line(" - "), //
               new Line("  |"), //
               new Line(" - "), //
               new Line("|  "), //
               new Line(" - "));
        put(3, new Line(" - "), //
               new Line("  |"), //
               new Line(" - "), //
               new Line("  |"), //
               new Line(" - "));
    }

    public void put(int digit, Line... lines) {
        lcdByDigit.put(digit, Arrays.asList(lines));
    }

    public List<Line> of(int digit) {
        return lcdByDigit.get(digit);
    }
}
