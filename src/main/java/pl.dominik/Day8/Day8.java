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
    private final int numberOfPixels = 25 * 6;
    private final List<List<Integer>> layers = readLayers();

    public Day8() throws IOException {
    }

    public void execute() {
        System.out.println("Day 8: ");
        System.out.println("Part One result: " + computeImageChecksum());
        System.out.println("Part Two result: ");
        decodeImageMessage().forEach(System.out::println);
    }

    public int computeImageChecksum() {
        int minNumberOfZeros = Integer.MAX_VALUE;
        List<Integer> searchedLayer = new ArrayList<>();

        for (List<Integer> layer : layers) {
            int numberOfZeros = Collections.frequency(layer, 0);
            if (numberOfZeros < minNumberOfZeros) {
                minNumberOfZeros = numberOfZeros;
                searchedLayer = layer;
            }
        }
        return Collections.frequency(searchedLayer, 1) * Collections.frequency(searchedLayer, 2);
    }

    public List<String> decodeImageMessage() {
        List<Integer> imageList = new ArrayList<>(Collections.nCopies(numberOfPixels, 2));
        List<String> message = new ArrayList<>();
        boolean[] isSet = new boolean[numberOfPixels];

        for (List<Integer> layer : layers) {
            for (int pixel = 0; pixel < numberOfPixels; pixel++) {
                if (!isSet[pixel]) {
                    if (layer.get(pixel) == 0) {
                        imageList.set(pixel, 0);
                        isSet[pixel] = true;
                    } else if (layer.get(pixel) == 1) {
                        imageList.set(pixel, 1);
                        isSet[pixel] = true;
                    }
                }
            }
        }
        for (int i = 0; i < numberOfPixels; i += 25) {
            message.add(imageList.subList(i, i + 25).toString().replaceAll("[\\[\\]]", "").replaceAll(",", " ").replaceAll("\\s+", "").replaceAll("0", " ").replaceAll("1", "\u2588"));

        }
        return message;
    }

    public List<List<Integer>> readLayers() throws IOException {
        Path path = Paths.get("src/main/resources/Day8/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        List<Integer> integerList = new ArrayList<>();
        List<List<Integer>> layers = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            integerList.add(Character.getNumericValue(line.charAt(i)));
        }
        for (int i = 0; i < integerList.size(); i += numberOfPixels) {
            layers.add(integerList.subList(i, i + numberOfPixels));
        }
        return layers;
    }
}
