import main.java.pl.dominik.Day4.Day4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {

    private final Day4 day4 = new Day4();

    @Test
    void checkCalculatingNumberOfDifferentPasswordsWithFirstCriteria() {
        assertEquals(979, day4.calculateNumberOfDifferentPasswordsWithFirstCriteria(new Integer[]{256310, 732736}));
    }

    @Test
    void checkCalculatingNumberOfDifferentPasswordsWithSecondCriteria() {
        assertEquals(635, day4.calculateNumberOfDifferentPasswordsWithSecondCriteria(new Integer[]{256310, 732736}));
    }

}


