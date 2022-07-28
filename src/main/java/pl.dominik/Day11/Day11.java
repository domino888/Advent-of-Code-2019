package main.java.pl.dominik.Day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day11 {

    Map<Position, Color> panels = new HashMap<>();

    public void execute() throws Exception {
        System.out.println("Day 11: ");
        System.out.println("Part One result: " + getCountOfPaintedPanels(Color.BLACK));
        System.out.println("Part Two result: ");
        getRegistrationIdentifier().forEach(System.out::println);
    }

    public int getCountOfPaintedPanels(Color startPanelColor) throws Exception {

        IntcodeComputer intcodeComputer = new IntcodeComputer(readNumberFromFile());
        Position currentPosition = new Position(0, 0, Direction.UP);

        while (intcodeComputer.isRunning()) {
            if (!panels.containsKey(currentPosition)) {
                panels.put(currentPosition, startPanelColor);
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

    public List<String> getRegistrationIdentifier() throws Exception {
        panels.clear();
        getCountOfPaintedPanels(Color.WHITE);

        int width = computeRegistrationWith();
        int height = computeRegistrationHeight();

        List<String> registrationIdentifier = new ArrayList<>();
        char[][] area = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = ' ';
            }
        }

        for (Map.Entry<Position, Color> panel : panels.entrySet()) {
            if (panel.getValue().equals(Color.WHITE)) {
                area[-panel.getKey().getY()][panel.getKey().getX()] = '\u2588';
            }
        }
        for (int i = 0; i < height; i++) {
            String line = "";
            for (int j = 0; j < width; j++) {
                line = line.concat(String.valueOf(area[i][j]));
            }
            registrationIdentifier.add(line);
        }
        return registrationIdentifier;
    }

    private Position computeNewPosition(Position currentPosition, Direction directionToChange) throws Exception {
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

    private int computeRegistrationWith() {
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;

        for (Map.Entry<Position, Color> panel : panels.entrySet()) {
            if (panel.getKey().getX() < xMin)
                xMin = panel.getKey().getX();
        }

        for (Map.Entry<Position, Color> panel : panels.entrySet()) {
            if (panel.getKey().getX() > xMax)
                xMax = panel.getKey().getX();
        }
        return xMax - xMin + 1;
    }

    private int computeRegistrationHeight() {
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;

        for (Map.Entry<Position, Color> panel : panels.entrySet()) {
            if (panel.getKey().getY() < yMin)
                yMin = panel.getKey().getY();
        }

        for (Map.Entry<Position, Color> panel : panels.entrySet()) {
            if (panel.getKey().getY() > yMax)
                yMax = panel.getKey().getY();
        }
        return yMax - yMin + 1;
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
