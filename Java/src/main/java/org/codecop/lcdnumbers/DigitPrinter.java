package org.codecop.lcdnumbers;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Appends lines next to each other and adds line breaks.
 */
public class DigitPrinter {

    private static final String NEWLINE = "\n";

    public String render(List<Digit> digits) {
        Objects.requireNonNull(digits);

        List<Iterator<Line>> digitLines = digits.stream(). //
                map(Digit::lines). //
                map(Iterable::iterator). //
                collect(Collectors.toList());

        return renderLines(digitLines);
    }

    // TODO extract generic zip of collections -> collaborator

    private String renderLines(List<Iterator<Line>> digitLines) {
        StringBuilder out = new StringBuilder();

        Iterator<Line> first = digitLines.get(0);
        while (first.hasNext()) {
            for (Iterator<Line> i : digitLines) {
                out.append(i.next());
            }
            out.append(NEWLINE);
        }

        return out.toString();
    }

}
