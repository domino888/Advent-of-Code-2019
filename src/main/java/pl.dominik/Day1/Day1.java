package main.java.pl.dominik.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    private static final List<Integer> massOfModules = new ArrayList<>();
    private static final List<Integer> neededFuels = new ArrayList<>();

    public void execute() throws IOException {
        loadData();
        System.out.println("Day 1: ");
        System.out.println("Part One result: " + calculateFuel1(massOfModules));
        System.out.println("Part Two result: " + calculateFuel2(massOfModules));
    }

    private static void loadData() throws IOException {
        Path path = Paths.get("src/main/resources/Day1/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            massOfModules.add(Integer.parseInt(line));
        }
    }

    public int calculateFuel1(List<Integer> massOfModules) {
        for (Integer mass : massOfModules) {
            mass = mass / 3 - 2;
            neededFuels.add(mass);
        }
        int neededFuel = neededFuels.stream().reduce(0, Integer::sum);
        neededFuels.clear();
        return neededFuel;
    }

    public int calculateFuel2(List<Integer> massOfModules) {
        for (Integer mass : massOfModules) {
            int sumOfMass = 0;
            while (mass > 0) {
                mass = mass / 3 - 2;
                if (mass == -2 || mass == -1) {
                    mass = 0;
                }
                sumOfMass += mass;
            }
            neededFuels.add(sumOfMass);
        }

        int neededFuel = neededFuels.stream().reduce(0, Integer::sum);
        neededFuels.clear();
        return neededFuel;
    }
}
