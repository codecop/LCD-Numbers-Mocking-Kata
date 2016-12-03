package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Value Object of an LCD digit line.
 */
public class Line {

    private final String line;

    public Line(String line) {
        Objects.requireNonNull(line);

        this.line = line;
    }

    public Line scaleHorizontal(CharRepeater repeater) {
        Objects.requireNonNull(repeater);

        char[] chars = line.toCharArray();
        return new Line(chars[0] + repeater.repeat(chars[1]) + chars[2]);
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
