package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Value Object of an LCD digit line which can scale.
 */
public class ScalingLine {

    private final String line;

    public ScalingLine(String line) {
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
    public String toString() {
        // debug
        return line;
    }
}
