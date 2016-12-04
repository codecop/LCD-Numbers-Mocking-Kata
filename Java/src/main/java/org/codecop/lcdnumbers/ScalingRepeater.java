package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Repeat objects and characters according to scaling.
 */
public class ScalingRepeater {

    public <T> List<T> repeat(final T element, Scaling scaling) {
        Objects.requireNonNull(element);
        Objects.requireNonNull(scaling);

        final List<T> elements = new ArrayList<>();
        scaling.times(/*lambda*/ new Runnable() {
            @Override
            public void run() {
                elements.add(element);
            }
        });
        return elements;
    }

    public String repeat(final char aChar, Scaling scaling) {
        Objects.requireNonNull(scaling);

        final StringBuilder acc = new StringBuilder();
        scaling.times(/*lambda*/ new Runnable() {
            @Override
            public void run() {
                acc.append(aChar);
            }
        });
        return acc.toString();
    }

}
