package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Value Object of an LCD digit line.
 */
public final class Line {

    private final String line;

    public Line(String line) {
        Objects.requireNonNull(line);
        if (line.length() != 3) {
            throw new IllegalArgumentException("pattern line must be 3 characters: " + line);
        }

        this.line = line;
    }

    public ScaledLine scaleHorizontal(ScalingRepeater repeater, Scaling scaling) {
        Objects.requireNonNull(repeater);
        Objects.requireNonNull(scaling);

        char[] chars = line.toCharArray();
        return new ScaledLine(chars[0] + repeater.repeat(chars[1], scaling) + chars[2]);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Line)) {
            return false;
        }
        Line that = (Line) other;
        return this.line.equals(that.line);
    }

    @Override
    public int hashCode() {
        return line.hashCode();
    }

    @Override
    public String toString() {
        return line;
    }
}
