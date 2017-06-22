package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Value Object of a scaled LCD digit line.
 */
public final class ScaledLine {

    private final String line;

    public ScaledLine(String line) {
        Objects.requireNonNull(line);

        this.line = line;
    }

    @Override
    public String toString() {
        return line;
    }
}
