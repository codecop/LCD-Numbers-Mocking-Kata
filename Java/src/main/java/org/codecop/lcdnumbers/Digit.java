package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of an LCD digit.
 */
public class Digit {

    private final List<Line> lines;

    @SuppressWarnings("unchecked")
    Digit(List<? extends Line> lines) {
        Objects.requireNonNull(lines);
        this.lines = (List<Line>) lines; // ScalingLine extends Line, OK
    }

    public List<Line> lines() {
        return lines;
    }

    @Override
    public String toString() {
        // debug
        return String.join("\n", lines().toArray(new String[0])) + "\n";
    }
}
