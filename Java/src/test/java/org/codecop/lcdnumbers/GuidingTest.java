package org.codecop.lcdnumbers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class GuidingTest {

    private PrintStream out;
    private ByteArrayOutputStream mockOut;

    @Before
    public void captureSystemOut() {
        out = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
    }

    @After
    public void resetSystemOut() {
        System.setOut(out);
    }
    
    @Test
    public void shouldPrintLcdSizeOne() {
        Main.main("123");
        String lcd = mockOut.toString();
        assertEquals("    -  - \n" + //
                     "  |  |  |\n" + //
                     "    -  - \n" + //
                     "  ||    |\n" + //
                     "    -  - \n", lcd);
    }

    @Test
    public void shouldPrintLcdSizeTwo() {
        Main.main("123", "2");
        String lcd = mockOut.toString();
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
        Main.main("123", "3");
        String lcd = mockOut.toString();
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
        Main.main("1234567890", "3");
        String lcd = mockOut.toString();
        String expected = read("/numbers grid 5x9 - size 3.txt");
        assertEquals(expected, lcd);
    }

    private String read(String name) throws IOException, URISyntaxException {
        URL classpathResource = getClass().getResource(name);
        Path fileSystemResource = Paths.get(classpathResource.toURI());
        return Files.readAllLines(fileSystemResource). //
                stream(). //
                collect(Collectors.joining("\n", "", "\n"));
    }
    
}
