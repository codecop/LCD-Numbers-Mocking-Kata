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

    public Line scaleHorizontal(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("scaling factor must be >= 1");
        }
        if (times == 1) {
            return this;
        }

        char[] chars = line.toCharArray();
        return new Line("" + chars[0] + repeat(chars[1], times) + chars[2]);
    }

    // TODO this is another collaborator
    private String repeat(char aChar, int size) {
        StringBuilder acc = new StringBuilder();
        for (int i = 0; i < size; i++) {
            acc.append(aChar);
        }
        return acc.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Line))
            return false;
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
