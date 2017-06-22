package org.codecop.lcdnumbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Knows the initial pattern of each LCD digit.
 */
public class Patterns {

    private final Map<Integer, List<ScalingLine>> lcdByDigit = new HashMap<>();

    public Patterns() {
        put(0, new ScalingLine(" - "), //
                new ScalingLine("| |"), //
                new ScalingLine("   "), //
                new ScalingLine("| |"), //
                new ScalingLine(" - "));
        put(1, new ScalingLine("   "), //
                new ScalingLine("  |"), //
                new ScalingLine("   "), //
                new ScalingLine("  |"), //
                new ScalingLine("   "));
        put(2, new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine(" - "), //
                new ScalingLine("|  "), //
                new ScalingLine(" - "));
        put(3, new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine(" - "));
        put(4, new ScalingLine("   "), //
                new ScalingLine("| |"), //
                new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine("   "));
        put(5, new ScalingLine(" - "), //
                new ScalingLine("|  "), //
                new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine(" - "));
        put(6, new ScalingLine(" - "), //
                new ScalingLine("|  "), //
                new ScalingLine(" - "), //
                new ScalingLine("| |"), //
                new ScalingLine(" - "));
        put(7, new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine("   "), //
                new ScalingLine("  |"), //
                new ScalingLine("   "));
        put(8, new ScalingLine(" - "), //
                new ScalingLine("| |"), //
                new ScalingLine(" - "), //
                new ScalingLine("| |"), //
                new ScalingLine(" - "));
        put(9, new ScalingLine(" - "), //
                new ScalingLine("| |"), //
                new ScalingLine(" - "), //
                new ScalingLine("  |"), //
                new ScalingLine(" - "));
    }

    private void put(int digit, ScalingLine... lines) {
        if (lcdByDigit.containsKey(digit)) {
            throw new IllegalArgumentException("duplicate pattern definition for digit " + digit);
        }

        List<ScalingLine> listOfLines = Collections.unmodifiableList(Arrays.asList(lines));
        lcdByDigit.put(digit, listOfLines);
    }

    public List<ScalingLine> of(int digit) {
        if (!lcdByDigit.containsKey(digit)) {
            throw new IllegalArgumentException("no pattern defined for digit " + digit);
        }

        return lcdByDigit.get(digit);
    }
}
