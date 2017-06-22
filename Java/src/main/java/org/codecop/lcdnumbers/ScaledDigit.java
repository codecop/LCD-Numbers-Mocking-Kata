package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of a scaled LCD digit.
 */
public final class ScaledDigit {

    private final int digit;
    private final List<ScaledLine> lines;

    ScaledDigit(int digit, List<ScaledLine> lines) {
        Objects.requireNonNull(lines);

        this.digit = digit;
        this.lines = lines;
    }

    public List<ScaledLine> lines() {
        return lines;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ScaledDigit)) {
            return false;
        }
        ScaledDigit that = (ScaledDigit) other;
        return this.digit == that.digit;
    }

    @Override
    public int hashCode() {
        return digit;
    }

    @Override
    public String toString() {
        return Integer.toString(digit);
    }
}
