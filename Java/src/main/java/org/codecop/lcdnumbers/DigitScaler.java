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
        Objects.requireNonNull(repeater);

        this.repeater = repeater;
    }

    public List<ScaledDigit> scale(List<ScalingDigit> digits, Scaling scaling) {
        Objects.requireNonNull(digits);
        Objects.requireNonNull(scaling);

        return digits.stream(). //
                map(d -> scale(d, scaling)). //
                collect(Collectors.toList());
    }

    private ScaledDigit scale(ScalingDigit digit, Scaling scaling) {
        Objects.requireNonNull(digit);
        Objects.requireNonNull(scaling);

        List<ScaledLine> scaled = new ArrayList<>();

        boolean oddLine = true;
        for (ScalingLine line : digit.lines()) {
            ScaledLine scaledLine = line.scaleHorizontal(repeater, scaling);
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
