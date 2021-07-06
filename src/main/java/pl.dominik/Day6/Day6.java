package main.java.pl.dominik.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6 {

    static Map<String, Planet> planetsMap = new HashMap<>();

    public void execute() throws IOException {
        System.out.println("Day 6: ");
        System.out.println("Part One result: " + calculateNumberOfOrbits(loadDataFromFile()));
        System.out.println("Part Two result: " + calculateMinimumNumberOfOrbitalTransfer(loadDataFromFile()));
    }

    public int calculateNumberOfOrbits(List<String> dataList) {
        addPlanets(dataList);
        return planetsMap.get("COM").getListSize(1);
    }

    public int calculateMinimumNumberOfOrbitalTransfer(List<String> dataList) {
        addPlanets(dataList);
        planetsMap.get("COM").setParent(null);
        planetsMap.get("COM").setDepth(0);
        return findDistanceBetweenPlanets(planetsMap.get("SAN").getParent(), planetsMap.get("YOU").getParent());
    }

    private void addPlanets(List<String> dataList) {
        String[] splitArray;
        planetsMap.put("COM", new Planet("COM"));

        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.put(splitArray[1], new Planet(splitArray[1]));
        }
        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.get(splitArray[0]).addChild(planetsMap.get(splitArray[1]));
        }
        for (String s : dataList) {
            splitArray = s.split("\\)");
            planetsMap.get(splitArray[1]).setParent(planetsMap.get(splitArray[0]));
        }
    }

    private int findDistanceBetweenPlanets(Planet planet1, Planet planet2) {
        Planet LCA = findLCA(planet1, planet2);
        return planet1.getDepth() + planet2.getDepth() - 2 * LCA.getDepth();
    }

    private Planet findLCA(Planet planet1, Planet planet2) {
        List<Planet> path1 = planetsMap.get(planet1.name).getPathToRoot();
        List<Planet> path2 = planetsMap.get(planet2.name).getPathToRoot();
        Collections.reverse(path1);
        Collections.reverse(path2);

        if (path1.size() <= 0) {
            return planetsMap.get("COM");
        }
        if (path2.size() <= 0) {
            return planetsMap.get("COM");
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).getName().equals(path2.get(i).getName())) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    private List<String> loadDataFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day6/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        return reader.lines().collect(Collectors.toList());
    }
}
