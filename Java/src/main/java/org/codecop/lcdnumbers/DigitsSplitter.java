package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Splits into digits.
 */
public class DigitsSplitter {
    private final int base = 10;
    private final DigitFactory digitFactory;

    public DigitsSplitter(DigitFactory digitFactory) {
        this.digitFactory = digitFactory;
    }

    public List<Digit> convert(int number) {
        List<Digit> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(digitFactory.create(number % base));
            number /= base;
        }
        Collections.reverse(digits);
        return digits;
    }
}
