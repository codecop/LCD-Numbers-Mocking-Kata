package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Scales x and y of digit lines.
 */
public class DigitScaler {

    public List<Digit> scale(List<Digit> digits, int times) {
        Objects.requireNonNull(digits);
        if (times <= 0) {
            throw new IllegalArgumentException("scaling factor must be >= 1");
        }

        return digits.stream(). //
                map(d -> scale(d, times)). //
                collect(Collectors.toList());
    }

    public Digit scale(Digit digit, int times) {
        Objects.requireNonNull(digit);
        if (times <= 0) {
            throw new IllegalArgumentException("scaling factor must be >= 1");
        }
        if (times == 1) {
            return digit;
        }

        List<Line> scaled = new ArrayList<>();

        boolean second = false;
        for (Line line : digit.lines()) {
            Line scaledLine = line.scaleHorizontal(times);
            scaled.add(scaledLine);
            if (second) {
                for (int i = 1; i < times; i++) {
                    scaled.add(scaledLine);
                }
            }
            second = !second;
        }

        return digit.scale(scaled);
    }
}
