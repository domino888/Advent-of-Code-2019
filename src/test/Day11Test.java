import main.java.pl.dominik.Day11.Color;
import main.java.pl.dominik.Day11.Day11;
import main.java.pl.dominik.Day8.Day8;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Test {

    private final Day11 day11 = new Day11();

    @Test
    void checkCountOfPaintedPanelsBlack() throws Exception {
        assertEquals(1876, day11.getCountOfPaintedPanels(Color.BLACK));
    }

    @Test
    void checkCountOfPaintedPanelsWhite() throws Exception {
        assertEquals(249, day11.getCountOfPaintedPanels(Color.WHITE));
    }

    @Test
    void checkRegistrationIdentifier() throws Exception {
        assertEquals(List.of(
                "  ██   ██  ███    ██  ██   ██   ██  █      ",
                " █  █ █  █ █  █    █ █  █ █  █ █  █ █      ",
                " █    █    █  █    █ █    █    █    █      ",
                " █    █ ██ ███     █ █    █ ██ █    █      ",
                " █  █ █  █ █    █  █ █  █ █  █ █  █ █      ",
                "  ██   ███ █     ██   ██   ███  ██  ████   "), day11.getRegistrationIdentifier());
    }
}

