import main.java.pl.dominik.Day12.Coordinate;
import main.java.pl.dominik.Day12.Day12;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day12Test {

    private final Day12 day12 = new Day12();

    @Test
    void checkTotalEnergy() throws Exception {
        assertEquals(179, day12.getTotalEnergy(List.of(
                new Coordinate(-1, 0, 2),
                new Coordinate(2, -10, -7),
                new Coordinate(4, -8, 8),
                new Coordinate(3, 5, -1)), 10));
    }

    @Test
    void checkTotalEnergy2() throws Exception {
        assertEquals(1940, day12.getTotalEnergy(List.of(
                new Coordinate(-8, -10, 0),
                new Coordinate(5, 5, 10),
                new Coordinate(2, -7, 3),
                new Coordinate(9, -8, -3)), 100));
    }

    @Test
    void checkStepsNumberToInitialState() throws Exception {
        assertEquals(new BigInteger("2772"), day12.getStepsNumberToInitialState(List.of(
                new Coordinate(-1, 0, 2),
                new Coordinate(2, -10, -7),
                new Coordinate(4, -8, 8),
                new Coordinate(3, 5, -1))));
    }

    @Test
    void checkStepsNumberToInitialState2() throws Exception {
        assertEquals(new BigInteger("4686774924"), day12.getStepsNumberToInitialState(List.of(
                new Coordinate(-8, -10, 0),
                new Coordinate(5, 5, 10),
                new Coordinate(2, -7, 3),
                new Coordinate(9, -8, -3))));
    }
}