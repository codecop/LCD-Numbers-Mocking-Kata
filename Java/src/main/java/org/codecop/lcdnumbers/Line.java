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

    @Override
    public String toString() {
        return line;
    }
}
