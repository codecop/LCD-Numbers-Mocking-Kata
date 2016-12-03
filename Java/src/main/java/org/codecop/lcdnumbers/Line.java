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

    public Line scaleHorizontal(Scaling scaling) {
        if (scaling.none()) {
            return this;
        }

        char[] chars = line.toCharArray();
        return new Line("" + chars[0] + repeat(chars[1], scaling) + chars[2]);
    }

    // TODO this is another collaborator
    private String repeat(char aChar, Scaling scaling) {
        StringBuilder acc = new StringBuilder();
        acc.append(aChar);
        scaling.repeat(() -> acc.append(aChar));
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
