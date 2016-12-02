package kata.lcdnumbers.a20160910;

import java.util.List;

/**
 * Value Object of an LCD digit.
 */
public class Digit {
    private final int digit;
    private final List<Line> lines;

    public Digit(int digit, Patterns patterns) {
        this(digit, patterns.of(digit));
    }

    private Digit(int digit, List<Line> lines) {
        this.digit = digit;
        this.lines = lines;
    }

    public List<Line> lines() {
        return lines;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Digit)) {
            return false;
        }
        Digit that = (Digit) other;
        return this.digit == that.digit;
    }

    @Override
    public int hashCode() {
        return digit;
    }

    public Digit scale(List<Line> scaledLines) {
        return new Digit(digit, scaledLines);
    }
}
