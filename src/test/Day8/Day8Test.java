package Day8;

import main.java.pl.dominik.Day8.Day8;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Test {

    private final Day8 day8 = new Day8();

    public Day8Test() throws IOException {
    }

    @Test
    void checkComputingImageChecksum() {
        assertEquals(2250, day8.computeImageChecksum());
    }

    @Test
    void checkDecodingMessage() {
        assertEquals(List.of(
                "████ █  █   ██ █  █ █    ",
                "█    █  █    █ █  █ █    ",
                "███  ████    █ █  █ █    ",
                "█    █  █    █ █  █ █    ",
                "█    █  █ █  █ █  █ █    ",
                "█    █  █  ██   ██  ████ "), day8.decodeImageMessage());
    }
}
