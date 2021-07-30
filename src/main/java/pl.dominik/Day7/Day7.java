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

    public void execute() throws IOException {
        System.out.println("Day 7: ");
        System.out.println("Part One result: " + calculateMaxThrusterSignal(readNumberFromFile()));
    }

    public int calculateMaxThrusterSignal(Integer[] integerArray) {
        Integer[] phaseSettingArray = new Integer[]{0, 1, 2, 3, 4};
        calculatePhaseSettingPermutation(phaseSettingArray.length, phaseSettingArray);
        int maxThrusterSignal = 0;

        for (Integer[] phaseSetting : phaseSettingPermutation) {
            IntcodeComputer AmpA = new IntcodeComputer(integerArray);
            AmpA.setInput(phaseSetting[0]);
            AmpA.setInput(0);
            AmpA.runIntCodeComputer();

            IntcodeComputer AmpB = new IntcodeComputer(integerArray);
            AmpB.setInput(phaseSetting[1]);
            AmpB.setInput(AmpA.getOutput());
            AmpB.runIntCodeComputer();

            IntcodeComputer AmpC = new IntcodeComputer(integerArray);
            AmpC.setInput(phaseSetting[2]);
            AmpC.setInput(AmpB.getOutput());
            AmpC.runIntCodeComputer();

            IntcodeComputer AmpD = new IntcodeComputer(integerArray);
            AmpD.setInput(phaseSetting[3]);
            AmpD.setInput(AmpC.getOutput());
            AmpD.runIntCodeComputer();

            IntcodeComputer AmpE = new IntcodeComputer(integerArray);
            AmpE.setInput(phaseSetting[4]);
            AmpE.setInput(AmpD.getOutput());
            AmpE.runIntCodeComputer();

            int actualThrusterSignal = AmpE.getOutput();
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