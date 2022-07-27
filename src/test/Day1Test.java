import main.java.pl.dominik.Day1.Day1;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day1Test {

    private final Day1 day1 = new Day1();

    @Test
    void checkCalculateFuel1() {
       assertEquals(2, day1.calculateFuel1(List.of(12)));
       assertEquals(2, day1.calculateFuel1(List.of(14)));
       assertEquals(654, day1.calculateFuel1(List.of(1969)));
       assertEquals(33583, day1.calculateFuel1(List.of(100756)));
    }

    @Test
    void checkCalculateFuel2() {
        assertEquals(2, day1.calculateFuel2(List.of(12)));
        assertEquals(2, day1.calculateFuel2(List.of(14)));
        assertEquals(966, day1.calculateFuel2(List.of(1969)));
        assertEquals(50346, day1.calculateFuel2(List.of(100756)));
    }
}


