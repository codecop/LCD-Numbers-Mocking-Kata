package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Scales x and y of digit lines.
 */
public class DigitScaler {

    private final ScalingRepeater repeater;

    public DigitScaler(ScalingRepeater repeater) {
        Objects.requireNonNull(repeater);

        this.repeater = repeater;
    }

    public List<Digit> scale(List<Digit> digits, Scaling scaling) {
        Objects.requireNonNull(digits);
        Objects.requireNonNull(scaling);

        // return digits.map(d -> scale(d, scaling));
        List<Digit> scaled = new ArrayList<>();
        for (Digit d :digits) {
            scaled.add(scale(d, scaling));
        }
        return scaled;
    }

    private Digit scale(Digit digit, Scaling scaling) {
        Objects.requireNonNull(digit);
        Objects.requireNonNull(scaling);
        if (scaling.none()) {
            return digit;
        }

        List<Line> scaled = new ArrayList<>();

        boolean oddLine = true;
        for (Line line : digit.lines()) {
            Line scaledLine = line.scaleHorizontal(repeater, scaling);
            if (oddLine) {
                scaled.add(scaledLine);
            } else {
                scaled.addAll(repeater.repeat(scaledLine, scaling));
            }
            oddLine = !oddLine;
        }

        return digit.scale(scaled);
    }
}
