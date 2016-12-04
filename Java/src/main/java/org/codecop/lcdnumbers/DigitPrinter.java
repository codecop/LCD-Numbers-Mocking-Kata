package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String render(List<Digit> digits) {
        Objects.requireNonNull(digits);

        List<List<Line>> linesOfAllDigits = linesOfAllDigits(digits);
        List<String> linesSideBySide = zip(linesOfAllDigits);
        return join(linesSideBySide);

    }

    private List<List<Line>> linesOfAllDigits(List<Digit> digits) {
        // return digits.map(Digit::lines);
        List<List<Line>> digitLines = new ArrayList<>();
        for (Digit d : digits) {
            digitLines.add(d.lines());
        }
        return digitLines;
    }

    private List<String> zip(List<List<Line>> linesOfAllDigits) {
        return zipper.zip(linesOfAllDigits, /*lambda*/ new Zipper.Combiner<List<Line>, String>() {
            @Override
            public String apply(List<Line> arg) {
                return concat(arg);
            }
        });
    }

    private String concat(List<Line> lines) {
        // return lines.map(Line::toString).joining());
        StringBuilder joiner = new StringBuilder();
        for (Line line : lines) {
            joiner.append(line.toString());
        }
        return joiner.toString();
    }

    private String join(List<String> lines) {
        // return lines.joining(NEWLINE, "", NEWLINE));
        StringBuilder joiner = new StringBuilder();
        for (String line : lines) {
            joiner.append(line);
            joiner.append(NEWLINE);
        }
        return joiner.toString();
    }

}
