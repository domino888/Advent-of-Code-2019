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


    public List<Long> produceBoostKeycode(Long[] program) throws Exception {
        List<Long> outputValues = new ArrayList<>();
        IntcodeComputer intcodeComputer = new IntcodeComputer(program);
        intcodeComputer.setInput(1L);
        intcodeComputer.runIntCodeComputer();

        while (intcodeComputer.hasOutput()) {
            outputValues.add(intcodeComputer.getOutput());
        }
        return outputValues;
    }

    private Long[] readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day9/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        String[] lineWithoutCommas = line.trim().split(",");
        Long[] program = new Long[lineWithoutCommas.length];

        for (int i = 0; i < lineWithoutCommas.length; i++) {
            program[i] = Long.parseLong(lineWithoutCommas[i]);
        }
        return program;
    }
}
