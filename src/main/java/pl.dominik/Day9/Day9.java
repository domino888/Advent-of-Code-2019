package main.java.pl.dominik.Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day9 {

    public void execute() throws Exception {
        System.out.println("Day 9: ");
        System.out.println("Part One result: ");
        produceBoostKeycode(readNumberFromFile()).forEach(System.out::println);
    }


    public List<Integer> produceBoostKeycode(Integer[] integerArray) throws Exception {
        IntcodeComputer intcodeComputer = new IntcodeComputer(integerArray);
        intcodeComputer.runIntCodeComputer();

        List<Integer> outputValues = new ArrayList<>();

        while (intcodeComputer.hasOutput()) {
            outputValues.add(intcodeComputer.getOutput());
        }

        return outputValues;
    }

    private Integer[] readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day9/data.txt");
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
