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

    public boolean none() {
        return times == 1;
    }

    public CharRepeater repeater() {
        return new CharRepeater(times);
    }

    public void additional(Runnable block) {
        Objects.requireNonNull(block);

        for (int i = 1; i < times; i++) {
            block.run();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Scaling)) {
            return false;
        }
        Scaling that = (Scaling) other;
        return this.times == that.times;
    }

    @Override
    public int hashCode() {
        return times;
    }

    @Override
    public String toString() {
        return Integer.toString(times);
    }

}
