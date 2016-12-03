package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of an LCD digit.
 */
public class Digit {

    private final int digit;
    private final List<Line> lines;

    public Digit(int digit, Patterns patterns) {
        this(digit, patterns.of(digit));
    }

    private Digit(int digit, List<Line> lines) {
        Objects.requireNonNull(lines);

        this.digit = digit;
        this.lines = lines;
    }

    List<Line> lines() {
        return lines;
    }

    Digit scale(List<Line> scaledLines) {
        return new Digit(digit, scaledLines);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Digit)) {
            return false;
        }
        Digit that = (Digit) other;
        return this.digit == that.digit;
    }

    @Override
    public int hashCode() {
        return digit;
    }

}
