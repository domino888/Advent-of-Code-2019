package Day2;

import main.java.pl.dominik.Day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    private final Day2 day2 = new Day2();

    @Test
    void checkInCodeComputerFirstValue() {
        assertEquals(2, day2.runIntCodeComputer(new Integer[]{1, 0, 0, 0, 99}));
        assertEquals(2, day2.runIntCodeComputer(new Integer[]{2, 3, 0, 3, 99}));
        assertEquals(2, day2.runIntCodeComputer(new Integer[]{2, 4, 4, 5, 99, 0}));
        assertEquals(30, day2.runIntCodeComputer(new Integer[]{1, 1, 1, 4, 99, 5, 6, 0, 99}));
        assertEquals(3500, day2.runIntCodeComputer(new Integer[]{1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50}));
    }

    @Test
    void checkInstructionsParametersSearch() throws IOException {
        List<Integer> foundedInstructionsParameters = day2.searchInstructionsParameters();
        assertEquals(List.of(37, 49), foundedInstructionsParameters);
    }
}


