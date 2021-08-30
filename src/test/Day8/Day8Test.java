package Day8;

import main.java.pl.dominik.Day8.Day8;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Test {

    private final Day8 day8 = new Day8();

    @Test
    void checkComputingImageChecksum() throws IOException {
        assertEquals(2250, day8.computeImageChecksum(day8.readNumberFromFile()));
    }
}
