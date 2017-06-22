package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * The scale factor value.
 */
public class Scaling {

    public static final Scaling NONE = new Scaling(1);
    public static final Scaling TWO = new Scaling(2);

    private final int times;

    public static Scaling of(int t) {
        return new Scaling(t);
    }

    private Scaling(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("scaling factor must be >= 1");
        }

        this.times = times;
    }

    public void times(Runnable block) {
        Objects.requireNonNull(block);

        for (int i = 0; i < times; i++) {
            block.run();
        }
    }

    @Override
    public String toString() {
        // debug
        return Integer.toString(times);
    }
}
