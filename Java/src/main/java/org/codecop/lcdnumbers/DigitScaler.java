package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Scales x and y of digit lines.
 */
public class DigitScaler {

    private final ScalingRepeater repeater;

    public DigitScaler(ScalingRepeater repeater) {
        this.repeater = repeater;
    }

    public List<Digit> scale(List<Digit> digits, Scaling scaling) {
        Objects.requireNonNull(digits);
        Objects.requireNonNull(scaling);

        return digits.stream(). //
                map(d -> scale(d, scaling)). //
                collect(Collectors.toList());
    }

    public Digit scale(Digit digit, Scaling scaling) {
        Objects.requireNonNull(digit);
        Objects.requireNonNull(scaling);
        if (scaling.none()) {
            return digit;
        }

        List<Line> scaled = new ArrayList<>();

        boolean second = false;
        for (Line line : digit.lines()) {
            Line scaledLine = line.scaleHorizontal(repeater, scaling);
            scaled.add(scaledLine);
            if (second) {
                scaled.addAll(repeater.repeat(scaledLine, scaling));
            }
            second = !second;
        }

        return digit.scale(scaled);
    }
}
