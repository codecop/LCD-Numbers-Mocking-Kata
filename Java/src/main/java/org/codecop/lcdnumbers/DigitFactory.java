package org.codecop.lcdnumbers;

/**
 * Creates digits from patterns.
 */
public class DigitFactory {

    private final Patterns patterns;

    public DigitFactory(Patterns patterns) {
        this.patterns = patterns;
    }

    public Digit create(int digit) {
        return new Digit(digit, patterns);
    }
}
