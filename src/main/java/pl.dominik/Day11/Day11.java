package main.java.pl.dominik.Day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day11 {

    public void execute() throws Exception {
        System.out.println("Day 11: ");
        System.out.println("Part One result: " + getCountOfPaintedPanels());
        System.out.println("Part Two result: ");
    }

    private int getCountOfPaintedPanels() throws Exception {

        Map<Position, Color> panels = new HashMap<>();
        IntcodeComputer intcodeComputer = new IntcodeComputer(readNumberFromFile());
        Position currentPosition = new Position(0, 0, Direction.UP);

        while (intcodeComputer.isRunning()) {
            if(!panels.containsKey(currentPosition)){
                panels.put(currentPosition, Color.BLACK);
            }
            intcodeComputer.setInput(panels.get(currentPosition).ordinal());
            intcodeComputer.runIntCodeComputer();

            Color colorToChange = intcodeComputer.getOutput() == 0 ? Color.BLACK : Color.WHITE;
            panels.replace(currentPosition, colorToChange);

            Direction directionToChange = intcodeComputer.getOutput() == 0 ? Direction.LEFT : Direction.RIGHT;
            currentPosition = computeNewPosition(currentPosition, directionToChange);
        }
        return panels.size();
    }

    Position computeNewPosition(Position currentPosition, Direction directionToChange) throws Exception {
        switch (currentPosition.getDirection()) {
            case UP: {
                if (directionToChange == Direction.LEFT)
                    return new Position(currentPosition.getX() - 1, currentPosition.getY(), Direction.LEFT);
                else // (directionToChange == Direction.RIGHT)
                    return new Position(currentPosition.getX() + 1, currentPosition.getY(), Direction.RIGHT);
            }
            case DOWN: {
                if (directionToChange == Direction.LEFT)
                    return new Position(currentPosition.getX() + 1, currentPosition.getY(), Direction.RIGHT);
                else // (directionToChange == Direction.RIGHT)
                    return new Position(currentPosition.getX() - 1, currentPosition.getY(), Direction.LEFT);
            }
            case LEFT: {
                if (directionToChange == Direction.LEFT)
                    return new Position(currentPosition.getX(), currentPosition.getY() - 1, Direction.DOWN);
                else // (directionToChange == Direction.RIGHT)
                    return new Position(currentPosition.getX(), currentPosition.getY() + 1, Direction.UP);
            }
            case RIGHT: {
                if (directionToChange == Direction.LEFT)
                    return new Position(currentPosition.getX(), currentPosition.getY() + 1, Direction.UP);
                else // (directionToChange == Direction.RIGHT)
                    return new Position(currentPosition.getX(), currentPosition.getY() - 1, Direction.DOWN);
            }
            default:
                throw new Exception("Bad position");
        }
    }

    private Long[] readNumberFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day11/data.txt");
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
