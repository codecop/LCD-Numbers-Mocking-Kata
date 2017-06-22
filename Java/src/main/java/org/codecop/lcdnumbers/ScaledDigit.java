package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of a scaled LCD digit.
 */
public final class ScaledDigit {

    private final List<ScaledLine> lines;

    ScaledDigit(List<ScaledLine> lines) {
        Objects.requireNonNull(lines);
        this.lines = lines;
    }

    public List<ScaledLine> lines() {
        return lines;
    }

    @Override
    public String toString() {
        // debug
        return String.join("\n", lines.toArray(new String[0])) + "\n";
    }
}
