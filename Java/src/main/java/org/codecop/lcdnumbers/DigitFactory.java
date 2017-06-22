package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Creates (LCD) digits from patterns.
 */
public class DigitFactory {

    private final Patterns patterns;

    public DigitFactory(Patterns patterns) {
        Objects.requireNonNull(patterns);

        this.patterns = patterns;
    }

    public ScalingDigit create(int digit) {
        return new ScalingDigit(digit, patterns);
    }
}
