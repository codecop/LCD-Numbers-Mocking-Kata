package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of an LCD digit.
 */
public class Digit {

    private final List<Line> lines;

    public Digit(int digit, Patterns patterns) {
        this(patterns.of(digit));
    }

    private Digit(List<Line> lines) {
        Objects.requireNonNull(lines);
        this.lines = lines;
    }

    public List<Line> lines() {
        return lines;
    }

    public ScaledDigit scale(List<ScaledLine> scaledLines) {
        Objects.requireNonNull(scaledLines);

        int linesCount = lines.size();
        int scaledCount = scaledLines.size();
        if (scaledCount < linesCount) {
            throw new IllegalArgumentException("Scaled lines must be more than original ones: " + scaledCount + ">=" + linesCount);
        }

        return new ScaledDigit(scaledLines);
    }

    @Override
    public String toString() {
        // debug
        return String.join("\n", lines.toArray(new String[0])) + "\n";
    }
}
