package main.java.pl.dominik.Day8;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day8 {

    public void execute() throws IOException {
        System.out.println("Day 1: ");
        System.out.println("Part One result: " + computeImageChecksum(readNumberFromFile()));
    }

    public int computeImageChecksum(List<Integer> integerList) {
        int numberOfPixels = 25 * 6;
        int numberOfLayers = integerList.size() / numberOfPixels;
        List<List<Integer>> layers = new ArrayList<>(numberOfLayers);
        List<Integer> searchedLayer = new ArrayList<>();
        int minNumberOfZeros = Integer.MAX_VALUE;

        for (int i = 0; i < integerList.size(); i += numberOfPixels) {
            layers.add(integerList.subList(i, i + numberOfPixels));
        }

        for (List<Integer> layer : layers) {
            int numberOfZeros = Collections.frequency(layer, 0);
            if (numberOfZeros < minNumberOfZeros) {
                minNumberOfZeros = numberOfZeros;
                searchedLayer = layer;
            }
        }
        return Collections.frequency(searchedLayer, 1) * Collections.frequency(searchedLayer, 2);
    }

    public List<Integer> readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day8/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            integerList.add(Character.getNumericValue(line.charAt(i)));
        }
        return integerList;
    }
}
