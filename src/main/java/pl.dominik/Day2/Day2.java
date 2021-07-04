package main.java.pl.dominik.Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public void execute() throws IOException {
        Integer[] integerArray = readNumberFromFile();
        integerArray[1] = 12;
        integerArray[2] = 2;

        System.out.println("Day 2: ");
        System.out.println("Part One result: " + runIntCodeComputer(integerArray));
        System.out.println("Part Two result: " + (100 * searchInstructionsParameters().get(0) + searchInstructionsParameters().get(1)));
    }

    public List<Integer> searchInstructionsParameters() throws IOException {

        List<Integer> foundedInstructionsParameters = new ArrayList<>();
        Integer[] integerArray;
        int noun, verb;

        for (noun = 0; noun < 100; noun++) {
            for (verb = 0; verb < 100; verb++) {

                integerArray = returnClearIntegerArray(noun, verb);

                for (int i = 0; i < integerArray.length; i += 4) {
                    switch (integerArray[i]) {
                        case 1: {
                            integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] + integerArray[integerArray[i + 2]];
                            break;
                        }
                        case 2: {
                            integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] * integerArray[integerArray[i + 2]];
                            break;
                        }
                        case 99:
                            break;
                    }
                    if (integerArray[0] == 19690720) {
                        foundedInstructionsParameters.add(noun);
                        foundedInstructionsParameters.add(verb);
                        break;
                    }
                }

            }
        }
        return foundedInstructionsParameters;
    }

    public Integer[] returnClearIntegerArray(int noun, int verb) throws IOException {
        Integer[] integerArray = readNumberFromFile();
        integerArray[1] = noun;
        integerArray[2] = verb;
        return integerArray;
    }

    public int runIntCodeComputer(Integer[] integerArray) {
        for (int i = 0; i < integerArray.length; i += 4) {
            switch (integerArray[i]) {
                case 1: {
                    integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] + integerArray[integerArray[i + 2]];
                    break;
                }
                case 2: {
                    integerArray[integerArray[i + 3]] = integerArray[integerArray[i + 1]] * integerArray[integerArray[i + 2]];
                    break;
                }
                case 99:
                    break;
            }
        }
        return integerArray[0];
    }

    public Integer[] readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day2/data.txt");
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
