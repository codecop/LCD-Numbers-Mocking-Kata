package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Appends lines next to each other and adds line breaks.
 */
public class DigitPrinter {

    private static final String NEWLINE = "\n";

    private final Zipper zipper;

    public DigitPrinter(Zipper zipper) {
        Objects.requireNonNull(zipper);

        this.zipper = zipper;
    }

    public String render(List<ScaledDigit> digits) {
        Objects.requireNonNull(digits);

        List<List<ScaledLine>> linesOfAllDigits = linesOfAllDigits(digits);
        List<String> linesSideBySide = zip(linesOfAllDigits);
        return join(linesSideBySide);
    }

    private List<List<ScaledLine>> linesOfAllDigits(List<ScaledDigit> digits) {
        return digits.stream(). //
                map(ScaledDigit::lines). //
                collect(Collectors.toList());
    }

    private List<String> zip(List<List<ScaledLine>> linesOfAllDigits) {
        return zipper.zip(linesOfAllDigits, this::concat);
    }

    private String concat(List<ScaledLine> lines) {
        return lines.stream(). //
                map(ScaledLine::toString). //
                collect(Collectors.joining());
    }

    private String join(List<String> lines) {
        return lines.stream(). //
                collect(Collectors.joining(NEWLINE, "", NEWLINE));
    }

}
