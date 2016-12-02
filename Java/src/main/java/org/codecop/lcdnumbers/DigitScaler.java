package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Scales x and y of digit lines.
 */
public class DigitScaler {
    public List<Digit> scale(List<Digit> digits, int size) {
        return digits. //
                stream(). //
                map(d -> scale(d, size)). //
                collect(Collectors.toList());
    }

    public Digit scale(Digit digit, int size) {
        if (size == 1) {
            return digit;
        }

        List<Line> scaled = new ArrayList<>();

        boolean second = false;
        for (Line line : digit.lines()) {
            Line scaledLine = line.scaleHorizontal(size);
            scaled.add(scaledLine);
            if (second) {
                for (int i = 1; i < size; i++) {
                    scaled.add(scaledLine);
                }
            }
            second = !second;
        }


        return digit.scale(scaled);
    }
}
