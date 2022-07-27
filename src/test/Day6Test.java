import main.java.pl.dominik.Day6.Day6;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Test {

    private final Day6 day6 = new Day6();

    @Test
    void checkCalculatingNumberOfOrbits() {
        assertEquals(42, day6.calculateNumberOfOrbits(List.of("COM)B", "B)C", "C)D", "D)E", "E)F",
                "B)G", "G)H", "D)I", "E)J", "J)K", "K)L")));
    }

    @Test
    void checkCalculatingMinimumNumberOfOrbitalTransfer() {
        assertEquals(4, day6.calculateMinimumNumberOfOrbitalTransfer(List.of("COM)B", "B)C", "C)D",
                "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN")));
    }
}

