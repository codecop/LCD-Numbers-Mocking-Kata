package org.codecop.lcdnumbers;

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
        put(0, new Line(" - "), //
                new Line("| |"), //
                new Line("   "), //
                new Line("| |"), //
                new Line(" - "));
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
        put(4, new Line("   "), //
                new Line("| |"), //
                new Line(" - "), //
                new Line("  |"), //
                new Line("   "));
        put(5, new Line(" - "), //
                new Line("|  "), //
                new Line(" - "), //
                new Line("  |"), //
                new Line(" - "));
        put(6, new Line(" - "), //
                new Line("|  "), //
                new Line(" - "), //
                new Line("| |"), //
                new Line(" - "));
        put(7, new Line(" - "), //
                new Line("  |"), //
                new Line("   "), //
                new Line("  |"), //
                new Line("   "));
        put(8, new Line(" - "), //
                new Line("| |"), //
                new Line(" - "), //
                new Line("| |"), //
                new Line(" - "));
        put(9, new Line(" - "), //
                new Line("| |"), //
                new Line(" - "), //
                new Line("  |"), //
                new Line(" - "));
    }

    private void put(int digit, Line... lines) {
        if (lcdByDigit.containsKey(digit)) {
            throw new IllegalArgumentException("duplicate pattern definition for digit " + digit);
        }
        lcdByDigit.put(digit, Arrays.asList(lines));
    }

    public List<Line> of(int digit) {
        if (!lcdByDigit.containsKey(digit)) {
            throw new IllegalArgumentException("no pattern defined for digit " + digit);
        }
        return lcdByDigit.get(digit);
    }
}
