package Day7;

import main.java.pl.dominik.Day7.Day7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Test {

    Day7 day7 = new Day7();

    @Test
    void checkCalculatingMaxThrusterSignal1() throws Exception {
        assertEquals(43210, day7.calculateMaxThrusterSignal(new Integer[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0}));
    }

    @Test
    void checkCalculatingMaxThrusterSignal2() throws Exception {
        assertEquals(54321, day7.calculateMaxThrusterSignal(new Integer[]{3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23, 101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0}));
    }

    @Test
    void checkCalculatingMaxThrusterSignal3() throws Exception {
        assertEquals(65210, day7.calculateMaxThrusterSignal(new Integer[]{3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33, 1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0}));
    }
}
