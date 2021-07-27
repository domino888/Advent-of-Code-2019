package main.java.pl.dominik.Day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 {

    List<Integer[]> phaseSettingPermutation = new ArrayList<>();
    Integer[] optionalProgram;

    public void execute() throws IOException {
        System.out.println("Day 7: ");
        System.out.println("Part One result: " + calculateMaxThrusterSignal());
        System.out.println("Part Two result: ");
    }

    public int calculateMaxThrusterSignal() throws IOException {
        Integer[] phaseSettingArray = new Integer[]{0, 1, 2, 3, 4};
        calculatePhaseSettingPermutation(phaseSettingArray.length, phaseSettingArray);
        int maxThrusterSignal = 0;

        for (Integer[] phaseSetting : phaseSettingPermutation) {
            IntcodeComputer AmpA = new IntcodeComputer(phaseSetting[0], 0, optionalProgram);
            AmpA.runIntCodeComputer();
            IntcodeComputer AmpB = new IntcodeComputer(phaseSetting[1], AmpA.getOutput(), optionalProgram);
            AmpB.runIntCodeComputer();
            IntcodeComputer AmpC = new IntcodeComputer(phaseSetting[2], AmpB.getOutput(), optionalProgram);
            AmpC.runIntCodeComputer();
            IntcodeComputer AmpD = new IntcodeComputer(phaseSetting[3], AmpC.getOutput(), optionalProgram);
            AmpD.runIntCodeComputer();
            IntcodeComputer AmpE = new IntcodeComputer(phaseSetting[4], AmpD.getOutput(), optionalProgram);
            AmpE.runIntCodeComputer();

            if (AmpE.getOutput() > maxThrusterSignal) {
                maxThrusterSignal = AmpE.getOutput();
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

    public void setOptionalProgram(Integer[] optionalProgram) {
        this.optionalProgram = optionalProgram;
    }
}