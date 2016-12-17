package org.codecop.lcdnumbers;

/**
 * Fake client code. Run this class to see LCD Numbers working:
 * <code>Main 12345 2</code>.
 */
public class Main {

    public static void main(String[] args) {
        final LcdDisplay lcdDisplay = new LcdDisplay( //
                new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
                new DigitScaler(new ScalingRepeater()), //
                new DigitPrinter(new Zipper()));

        int number = Integer.parseInt(args[0]);
        Scaling scaling = Scaling.of(Integer.parseInt(args[1]));

        System.out.println(lcdDisplay.toLcd(number, scaling));
    }
}
