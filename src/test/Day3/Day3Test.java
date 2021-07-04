package Day3;

import main.java.pl.dominik.Day3.Day3;
import main.java.pl.dominik.Day3.Path;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {
    private final Day3 day3 = new Day3();

    @Test
    void checkCalculatingDistanceToClosestIntersection1() {
        List<Path> path1 = Arrays.asList(
                new Path("R75"), new Path("D30"), new Path("R83"),
                new Path("U83"), new Path("L12"), new Path("D49"),
                new Path("R71"), new Path("U7"), new Path("L72"));
        List<Path> path2 = Arrays.asList(
                new Path("U62"), new Path("R66"), new Path("U55"),
                new Path("R34"), new Path("D71"), new Path("R55"),
                new Path("D58"), new Path("R83"));
        assertEquals(159, day3.calculateDistanceToClosestIntersection(Arrays.asList(path1, path2)));
    }

    @Test
    void checkCalculatingDistanceToClosestIntersection2() {
        List<Path> path1 = Arrays.asList(
                new Path("R98"), new Path("U47"), new Path("R26"),
                new Path("D63"), new Path("R33"), new Path("U87"),
                new Path("L62"), new Path("D20"), new Path("R33"),
                new Path("U53"), new Path("R51"));
        List<Path> path2 = Arrays.asList(
                new Path("U98"), new Path("R91"), new Path("D20"),
                new Path("R16"), new Path("D67"), new Path("R40"),
                new Path("U7"), new Path("R15"), new Path("U6"),
                new Path("R7"));
        assertEquals(135, day3.calculateDistanceToClosestIntersection(Arrays.asList(path1, path2)));
    }

    @Test
    void checkCalculatingFewestStepsToIntersection1(){
        List<Path> path1 = Arrays.asList(
                new Path("R75"), new Path("D30"), new Path("R83"),
                new Path("U83"), new Path("L12"), new Path("D49"),
                new Path("R71"), new Path("U7"), new Path("L72"));
        List<Path> path2 = Arrays.asList(
                new Path("U62"), new Path("R66"), new Path("U55"),
                new Path("R34"), new Path("D71"), new Path("R55"),
                new Path("D58"), new Path("R83"));
        assertEquals(610, day3.calculateFewestStepsToIntersection(Arrays.asList(path1, path2)));
    }

    @Test
    void checkCalculatingFewestStepsToIntersection2(){
        List<Path> path1 = Arrays.asList(
                new Path("R98"), new Path("U47"), new Path("R26"),
                new Path("D63"), new Path("R33"), new Path("U87"),
                new Path("L62"), new Path("D20"), new Path("R33"),
                new Path("U53"), new Path("R51"));
        List<Path> path2 = Arrays.asList(
                new Path("U98"), new Path("R91"), new Path("D20"),
                new Path("R16"), new Path("D67"), new Path("R40"),
                new Path("U7"), new Path("R15"), new Path("U6"),
                new Path("R7"));
        assertEquals(410, day3.calculateFewestStepsToIntersection(Arrays.asList(path1, path2)));
    }
}


