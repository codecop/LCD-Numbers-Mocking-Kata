package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Value Object of an LCD digit line which can scale.
 */
public class ScalingLine extends Line {

    public ScalingLine(String line) {
        super(line);
        if (line.length() != 3) {
            throw new IllegalArgumentException("pattern line must be 3 characters: " + line);
        }
    }

    public Line scaleHorizontal(ScalingRepeater repeater, Scaling scaling) {
        Objects.requireNonNull(repeater);
        Objects.requireNonNull(scaling);

        char[] chars = toString().toCharArray();
        return new Line(chars[0] + repeater.repeat(chars[1], scaling) + chars[2]);
    }

}
