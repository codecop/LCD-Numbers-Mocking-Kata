package org.codecop.lcdnumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.codecop.lcdnumbers.DigitFactory;
import org.codecop.lcdnumbers.DigitPrinter;
import org.codecop.lcdnumbers.DigitScaler;
import org.codecop.lcdnumbers.DigitsSplitter;
import org.codecop.lcdnumbers.LcdDisplay;
import org.codecop.lcdnumbers.Patterns;

public class GuidingTest {

    private final LcdDisplay lcdDisplay = new LcdDisplay( //
            new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
            new DigitScaler(new ScalingRepeater()),
            new DigitPrinter());

    @Test
    public void shouldPrintLcdSizeOne() {
        String lcd = lcdDisplay.toLcd(123, Scaling.NONE);
        assertEquals("    -  - \n" + //
                     "  |  |  |\n" + //
                     "    -  - \n" + //
                     "  ||    |\n" + //
                     "    -  - \n", lcd);
    }

    @Test
    public void shouldPrintLcdSizeTwo() {
        String lcd = lcdDisplay.toLcd(123, Scaling.TWO);
        assertEquals("     --  -- \n" + //
                     "   |   |   |\n" + //
                     "   |   |   |\n" + //
                     "     --  -- \n" + //
                     "   ||      |\n" + //
                     "   ||      |\n" + //
                     "     --  -- \n", lcd);
    }

    @Test
    public void shouldPrintLcdSizeThree() {
        String lcd = lcdDisplay.toLcd(123, Scaling.of(3));
        assertEquals("      ---  --- \n" + //
                     "    |    |    |\n" + //
                     "    |    |    |\n" + //
                     "    |    |    |\n" + //
                     "      ---  --- \n" + //
                     "    ||        |\n" + //
                     "    ||        |\n" + //
                     "    ||        |\n" + //
                     "      ---  --- \n", lcd);
    }

    @Test
    public void shouldPrintAllNumbersLcdSizeThree() throws IOException, URISyntaxException {
        String lcd = lcdDisplay.toLcd(1234567890, Scaling.of(3));
        String expected = read("/numbers grid 5x9 - size 3.txt");
        assertEquals(expected, lcd);
    }

    private String read(String name) throws IOException, URISyntaxException {
        URL classpathResource = getClass().getResource(name);
        Path fileSystemResource = Paths.get(classpathResource.toURI());
        return Files.readAllLines(fileSystemResource). //
                stream(). //
                collect(Collectors.joining("\n")) + "\n";
    }
    
}
