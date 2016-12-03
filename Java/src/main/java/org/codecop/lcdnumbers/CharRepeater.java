package org.codecop.lcdnumbers;

/**
 * Repeat characters.
 */
public class CharRepeater {

    private final int times;

    public CharRepeater(int times) {
        if (times < 0) {
            throw new IllegalArgumentException("repetition must be >= 0");
        }
        this.times = times;
    }

    public String repeat(char aChar) {
        StringBuilder acc = new StringBuilder();
        for (int i = 0; i < times; i++) {
            acc.append(aChar);
        }
        return acc.toString();
    }

}
