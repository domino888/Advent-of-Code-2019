package main.java.pl.dominik.Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 {

    List<Integer[]> phaseSettingPermutation = new ArrayList<>();

    public void execute() throws Exception {
        System.out.println("Day 7: ");
        System.out.println("Part One result: " + calculateMaxThrusterSignal(readNumberFromFile()));
    }

    public int calculateMaxThrusterSignal(Integer[] integerArray) throws Exception {
        Integer[] phaseSettingArray = new Integer[]{0, 1, 2, 3, 4};
        calculatePhaseSettingPermutation(phaseSettingArray.length, phaseSettingArray);
        int maxThrusterSignal = 0;

        for (Integer[] phaseSetting : phaseSettingPermutation) {
            IntcodeComputer[] Amps = new IntcodeComputer[5];
            for (int i = 0; i < 5; i++) {
                Amps[i] = new IntcodeComputer(integerArray);
                Amps[i].setInput(phaseSetting[i]);
            }

            Amps[0].setInput(0);

            for (int i = 0; i < 5; i++) {
                Amps[i].runIntCodeComputer();
                if (i != 4) {
                    Amps[i + 1].setInput(Amps[i].getOutput());
                }
        }

        int actualThrusterSignal = Amps[4].getOutput();
        if (actualThrusterSignal > maxThrusterSignal) {
            maxThrusterSignal = actualThrusterSignal;
        }
    }
        return maxThrusterSignal;
}

    private void calculatePhaseSettingPermutation(int length, Integer[] elements) {
        if (length == 1) {
            phaseSettingPermutation.add(Arrays.copyOf(elements, elements.length));
        } else {
            for (int i = 0; i < length - 1; i++) {
                calculatePhaseSettingPermutation(length - 1, elements);
                if (length % 2 == 0) {
                    swap(elements, i, length - 1);
                } else {
                    swap(elements, 0, length - 1);
                }
            }
            calculatePhaseSettingPermutation(length - 1, elements);
        }
    }

    private void swap(Integer[] input, Integer a, Integer b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private Integer[] readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day7/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        String[] lineWithoutCommas = line.trim().split(",");
        Integer[] integerArray = new Integer[lineWithoutCommas.length];

        for (int i = 0; i < lineWithoutCommas.length; i++) {
            integerArray[i] = Integer.parseInt(lineWithoutCommas[i]);
        }
        return integerArray;
    }
}