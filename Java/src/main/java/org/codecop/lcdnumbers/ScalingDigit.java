package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of an LCD digit which can scale.
 */
public class ScalingDigit extends Digit {

    public ScalingDigit(int digit, Patterns patterns) {
        super(patterns.of(digit));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<ScalingLine> scalindLines() {
        return (List) super.lines();
    }

    public Digit scale(List<Line> scaledLines) {
        Objects.requireNonNull(scaledLines);

        int linesCount = scalindLines().size();
        int scaledCount = scaledLines.size();
        if (scaledCount < linesCount) {
            throw new IllegalArgumentException("Scaled lines must be more than original ones: " + scaledCount + ">=" + linesCount);
        }

        return new Digit(scaledLines);
    }

    @Override
    public String toString() {
        // debug
        return String.join("\n", scalindLines().toArray(new String[0])) + "\n";
    }
}
