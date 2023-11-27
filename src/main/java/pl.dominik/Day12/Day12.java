package main.java.pl.dominik.Day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day12 {
    private final List<Moon> moons = new ArrayList<>();

    public void execute() throws IOException {
        System.out.println("Day 12: ");
        System.out.println("Part One result: " + getTotalEnergy(readCoordinatesFromFile(), 1000));
        System.out.println("Part Two result: " + getStepsNumberToInitialState(readCoordinatesFromFile()));
    }

    public int getTotalEnergy(List<Coordinate> coordinates, int timeSteps) {
        loadMoons(coordinates);

        for (int i = 0; i < timeSteps; i++) {
            calculateVelocity();
            addVelocity();
        }
        return calculateTotalEnergy();
    }

    public BigInteger getStepsNumberToInitialState(List<Coordinate> coordinates) {
        loadMoons(coordinates);
        List<Moon> initialMoons = moons.stream().map(Moon::deepCopy).toList();

        long xPeriod = getXPeriod(initialMoons);
        loadMoons(coordinates);
        long yPeriod = getYPeriod(initialMoons);
        loadMoons(coordinates);
        long zPeriod = getZPeriod(initialMoons);

        return calculateLeastCommonMultiple(BigInteger.valueOf(zPeriod),
                calculateLeastCommonMultiple(BigInteger.valueOf(xPeriod), BigInteger.valueOf(yPeriod)));
    }

    public BigInteger calculateLeastCommonMultiple(BigInteger number1, BigInteger number2) {
        BigInteger gcd = number1.gcd(number2);
        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }

    private long getXPeriod(List<Moon> initialMoons) {
        long stepsNumber = 1L;

        calculateVelocity();
        addVelocity();

        while (!isXCoordinateInInitialState(initialMoons)) {
            stepsNumber++;
            calculateVelocity();
            addVelocity();
        }
        return stepsNumber;
    }

    private long getYPeriod(List<Moon> initialMoons) {
        long stepsNumber = 1L;

        calculateVelocity();
        addVelocity();

        while (!isYCoordinateInInitialState(initialMoons)) {
            stepsNumber++;
            calculateVelocity();
            addVelocity();
        }
        return stepsNumber;
    }

    private long getZPeriod(List<Moon> initialMoons) {
        long stepsNumber = 1L;

        calculateVelocity();
        addVelocity();

        while (!isZCoordinateInInitialState(initialMoons)) {
            stepsNumber++;
            calculateVelocity();
            addVelocity();
        }
        return stepsNumber;
    }

    private boolean isXCoordinateInInitialState(List<Moon> initialMoons) {
        boolean[] isInInitialState = {false, false, false, false};

        for (int i = 0; i < moons.size(); i++) {
            isInInitialState[i] = Objects.equals(moons.get(i).getPosition().getX(), initialMoons.get(i).getPosition().getX()) &&
                    Objects.equals(moons.get(i).getVelocity().getX(), initialMoons.get(i).getVelocity().getX());
        }
        return IntStream.range(0, isInInitialState.length).allMatch(i -> isInInitialState[i]);
    }

    private boolean isYCoordinateInInitialState(List<Moon> initialMoons) {
        boolean[] isInInitialState = {false, false, false, false};

        for (int i = 0; i < moons.size(); i++) {
            isInInitialState[i] = Objects.equals(moons.get(i).getPosition().getY(), initialMoons.get(i).getPosition().getY()) &&
                    Objects.equals(moons.get(i).getVelocity().getY(), initialMoons.get(i).getVelocity().getY());
        }
        return IntStream.range(0, isInInitialState.length).allMatch(i -> isInInitialState[i]);
    }

    private boolean isZCoordinateInInitialState(List<Moon> initialMoons) {
        boolean[] isInInitialState = {false, false, false, false};

        for (int i = 0; i < moons.size(); i++) {
            isInInitialState[i] = Objects.equals(moons.get(i).getPosition().getZ(), initialMoons.get(i).getPosition().getZ()) &&
                    Objects.equals(moons.get(i).getVelocity().getZ(), initialMoons.get(i).getVelocity().getZ());
        }
        return IntStream.range(0, isInInitialState.length).allMatch(i -> isInInitialState[i]);
    }

    private void loadMoons(List<Coordinate> coordinates) {
        moons.clear();

        for (Coordinate coordinate : coordinates) {
            Moon moon = new Moon();
            moon.setPosition(new Coordinate(coordinate));
            moons.add(moon);
        }
    }

    private int calculateTotalEnergy() {
        int totalEnergy = 0;
        for (Moon moon : moons) {
            int potentialEnergy = Math.abs(moon.getPosition().getX()) +
                    Math.abs(moon.getPosition().getY()) + Math.abs(moon.getPosition().getZ());
            int kineticEnergy = Math.abs(moon.getVelocity().getX())
                    + Math.abs(moon.getVelocity().getY()) + Math.abs(moon.getVelocity().getZ());
            totalEnergy += potentialEnergy * kineticEnergy;
        }
        return totalEnergy;
    }

    private void addVelocity() {
        for (Moon moon : moons) {
            moon.getPosition().setX(moon.getPosition().getX() + moon.getVelocity().getX());
            moon.getPosition().setY(moon.getPosition().getY() + moon.getVelocity().getY());
            moon.getPosition().setZ(moon.getPosition().getZ() + moon.getVelocity().getZ());
        }
    }

    private void calculateVelocity() {
        for (Moon moon : moons) {
            List<Moon> filteredMoons = moons.stream()
                    .filter(m -> !m.equals(moon) && !m.getChecked())
                    .toList();

            for (Moon filteredMoon : filteredMoons) {
                calculateVelocityBetweenMoons(moon, filteredMoon);
            }
            moon.setChecked(true);
        }
        moons.forEach(m -> m.setChecked(false));
    }

    private void calculateVelocityBetweenMoons(Moon moon1, Moon moon2) {
        calculateXVelocity(moon1, moon2);
        calculateYVelocity(moon1, moon2);
        calculateZVelocity(moon1, moon2);
    }

    private void calculateXVelocity(Moon moon1, Moon moon2) {
        if (moon1.getPosition().getX() > moon2.getPosition().getX()) {
            moon1.getVelocity().setX(moon1.getVelocity().getX() - 1);
            moon2.getVelocity().setX(moon2.getVelocity().getX() + 1);
        } else if (moon1.getPosition().getX() < moon2.getPosition().getX()) {
            moon1.getVelocity().setX(moon1.getVelocity().getX() + 1);
            moon2.getVelocity().setX(moon2.getVelocity().getX() - 1);
        }
    }

    private void calculateYVelocity(Moon moon1, Moon moon2) {
        if (moon1.getPosition().getY() > moon2.getPosition().getY()) {
            moon1.getVelocity().setY(moon1.getVelocity().getY() - 1);
            moon2.getVelocity().setY(moon2.getVelocity().getY() + 1);
        } else if (moon1.getPosition().getY() < moon2.getPosition().getY()) {
            moon1.getVelocity().setY(moon1.getVelocity().getY() + 1);
            moon2.getVelocity().setY(moon2.getVelocity().getY() - 1);
        }
    }

    private void calculateZVelocity(Moon moon1, Moon moon2) {
        if (moon1.getPosition().getZ() > moon2.getPosition().getZ()) {
            moon1.getVelocity().setZ(moon1.getVelocity().getZ() - 1);
            moon2.getVelocity().setZ(moon2.getVelocity().getZ() + 1);
        } else if (moon1.getPosition().getZ() < moon2.getPosition().getZ()) {
            moon1.getVelocity().setZ(moon1.getVelocity().getZ() + 1);
            moon2.getVelocity().setZ(moon2.getVelocity().getZ() - 1);
        }
    }

    private List<Coordinate> readCoordinatesFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/Day12/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        Pattern integerPattern = Pattern.compile("-?\\d+");
        List<Coordinate> velocities = new ArrayList<>();
        Matcher matcher;
        String line;

        while ((line = reader.readLine()) != null) {
            List<Integer> integers = new ArrayList<>();
            matcher = integerPattern.matcher(line);

            while (matcher.find()) {
                integers.add(Integer.parseInt(matcher.group()));
            }
            velocities.add(new Coordinate(integers.get(0), integers.get(1), integers.get(2)));
        }
        return velocities;
    }
}
