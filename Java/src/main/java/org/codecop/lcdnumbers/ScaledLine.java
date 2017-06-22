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
    public boolean equals(Object other) {
        if (!(other instanceof ScaledLine)) {
            return false;
        }
        ScaledLine that = (ScaledLine) other;
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
