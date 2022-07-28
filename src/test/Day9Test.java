import main.java.pl.dominik.Day9.Day9;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Test {

    private final Day9 day9 = new Day9();

    @Test
    void checkProducingBoostKeycode() throws Exception {
        assertEquals(Arrays.asList(109L, 1L, 204L, -1L, 1001L, 100L, 1L, 100L, 1008L, 100L, 16L, 101L, 1006L, 101L, 0L, 99L),
                day9.produceBoostKeycode(new Long[]{109L, 1L, 204L, -1L, 1001L, 100L, 1L, 100L, 1008L, 100L, 16L, 101L, 1006L, 101L, 0L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode2() throws Exception {
        assertEquals(List.of(1219070632396864L), day9.produceBoostKeycode(new Long[]{1102L, 34915192L, 34915192L, 7L, 4L, 7L, 99L, 0L}));
    }

    @Test
    void checkProducingBoostKeycode3() throws Exception {
        assertEquals(List.of(1125899906842624L), day9.produceBoostKeycode(new Long[]{104L, 1125899906842624L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode4() throws Exception {
        assertEquals(List.of(-1L), day9.produceBoostKeycode(new Long[]{109L, -1L, 4L, 1L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode5() throws Exception {
        assertEquals(List.of(1L), day9.produceBoostKeycode(new Long[]{109L, -1L, 104L, 1L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode6() throws Exception {
        assertEquals(List.of(109L), day9.produceBoostKeycode(new Long[]{109L, -1L, 204L, 1L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode7() throws Exception {
        assertEquals(List.of(204L), day9.produceBoostKeycode(new Long[]{109L, 1L, 9L, 2L, 204L, -6L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode8() throws Exception {
        assertEquals(List.of(204L), day9.produceBoostKeycode(new Long[]{109L, 1L, 109L, 9L, 204L, -6L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode9() throws Exception {
        assertEquals(List.of(204L), day9.produceBoostKeycode(new Long[]{109L, 1L, 209L, -1L, 204L, -106L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode10() throws Exception {          // outputs the input
        assertEquals(List.of(1L), day9.produceBoostKeycode(new Long[]{109L, 1L, 3L, 3L, 204L, 2L, 99L}));
    }

    @Test
    void checkProducingBoostKeycode11() throws Exception {          // outputs the input
        assertEquals(List.of(1L), day9.produceBoostKeycode(new Long[]{109L, 1L, 203L, 2L, 204L, 2L, 99L}));
    }


}

