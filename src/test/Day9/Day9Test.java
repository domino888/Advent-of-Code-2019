package Day9;

import main.java.pl.dominik.Day9.Day9;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Test {

    private final Day9 day9 = new Day9();

    @Test
    void checkProducingBoostKeycode() throws Exception {
        assertEquals(Arrays.asList(109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99), day9.produceBoostKeycode(new Integer[]{109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99}));
    }

//    @Test
//    void checkProducingBoostKeycode2() throws Exception {
//        assertEquals(Arrays.asList(1125899906842624L), day9.produceBoostKeycode(new Integer[]{104,1125899906842624,99}));
//    }

}

