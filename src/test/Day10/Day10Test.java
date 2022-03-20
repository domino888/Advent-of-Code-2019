package Day10;

import main.java.pl.dominik.Day10.Day10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Test {

    private final Day10 day10 = new Day10();

    @Test
    void checkGettingNumberOfDetectedAsteroids() {
        assertEquals(8, day10.getNumberOfDetectedAsteroids(new char[][]{
                ".#..#".toCharArray(),
                ".....".toCharArray(),
                "#####".toCharArray(),
                "....#".toCharArray(),
                "...##".toCharArray()}));
    }

    @Test
    void checkGettingNumberOfDetectedAsteroids2() {
        assertEquals(33, day10.getNumberOfDetectedAsteroids(new char[][]{
                "......#.#.".toCharArray(),
                "#..#.#....".toCharArray(),
                "..#######.".toCharArray(),
                ".#.#.###..".toCharArray(),
                ".#..#.....".toCharArray(),
                "..#....#.#".toCharArray(),
                "#..#....#.".toCharArray(),
                ".##.#..###".toCharArray(),
                "##...#..#.".toCharArray(),
                ".#....####".toCharArray()}));
    }

    @Test
    void checkGettingNumberOfDetectedAsteroids3() {
        assertEquals(35, day10.getNumberOfDetectedAsteroids(new char[][]{
                "#.#...#.#.".toCharArray(),
                ".###....#.".toCharArray(),
                ".#....#...".toCharArray(),
                "##.#.#.#.#".toCharArray(),
                "....#.#.#.".toCharArray(),
                ".##..###.#".toCharArray(),
                "..#...##..".toCharArray(),
                "..##....##".toCharArray(),
                "......#...".toCharArray(),
                ".####.###.".toCharArray()}));
    }

    @Test
    void checkGettingNumberOfDetectedAsteroids4() {
        assertEquals(41, day10.getNumberOfDetectedAsteroids(new char[][]{
                ".#..#..###".toCharArray(),
                "####.###.#".toCharArray(),
                "....###.#.".toCharArray(),
                "..###.##.#".toCharArray(),
                "##.##.#.#.".toCharArray(),
                "....###..#".toCharArray(),
                "..#.#..#.#".toCharArray(),
                "#..#.#.###".toCharArray(),
                ".##...##.#".toCharArray(),
                ".....#.#..".toCharArray()}));
    }

    @Test
    void checkGettingNumberOfDetectedAsteroids5() {
        assertEquals(210, day10.getNumberOfDetectedAsteroids(new char[][]{
                ".#..##.###...#######".toCharArray(),
                "##.############..##.".toCharArray(),
                ".#.######.########.#".toCharArray(),
                ".###.#######.####.#.".toCharArray(),
                "#####.##.#.##.###.##".toCharArray(),
                "..#####..#.#########".toCharArray(),
                "####################".toCharArray(),
                "#.####....###.#.#.##".toCharArray(),
                "##.#################".toCharArray(),
                "#####.##.###..####..".toCharArray(),
                "..######..##.#######".toCharArray(),
                "####.##.####...##..#".toCharArray(),
                ".#####..#.######.###".toCharArray(),
                "##...#.##########...".toCharArray(),
                "#.##########.#######".toCharArray(),
                ".####.#.###.###.#.##".toCharArray(),
                "....##.##.###..#####".toCharArray(),
                ".#.#.###########.###".toCharArray(),
                "#.#.#.#####.####.###".toCharArray(),
                "###.##.####.##.#..##".toCharArray()}));
    }
}

