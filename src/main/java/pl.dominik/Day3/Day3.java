package main.java.pl.dominik.Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {

    public void execute() throws IOException {
        System.out.println("Day 3: ");
        System.out.println("Part One result: " + calculateDistanceToClosestIntersection(getPaths()));
        System.out.println("Part Two result: " + calculateFewestStepsToIntersection(getPaths()));
    }

    public int calculateDistanceToClosestIntersection(List<List<Path>> paths) {
        List<Position> listPositionsOfWire = new ArrayList<>();
        List<List<Position>> listOfPositionList = new ArrayList<>();
        List<Integer> distancesFromCenterPoint = new ArrayList<>();
        Position positionOfWire = new Position(0, 0);
        int oldX;
        int oldY;

        for (var listPathsOfWire : paths) {
            for (Path path : listPathsOfWire) {
                switch (path.getDirection()) {
                    case 'R': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX + 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                    case 'L': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX - 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                    case 'U': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            oldY = positionOfWire.getPositionY();
                            positionOfWire.setPositionY(oldY + 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                    case 'D': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            oldY = positionOfWire.getPositionY();
                            positionOfWire.setPositionY(oldY - 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                }
            }
            positionOfWire.setPositionX(0);
            positionOfWire.setPositionY(0);
            listOfPositionList.add(new ArrayList<>(listPositionsOfWire));
            listPositionsOfWire.clear();
        }
        listOfPositionList.get(0).retainAll(listOfPositionList.get(1));

        for (Position position : listOfPositionList.get(0)) {
            distancesFromCenterPoint.add(Math.abs(position.getPositionX()) + Math.abs(position.getPositionY()));
        }
        return distancesFromCenterPoint.stream().mapToInt(v -> v).min().getAsInt();
    }

    public int calculateFewestStepsToIntersection(List<List<Path>> listOfPathList) {
        List<Map<Position, Integer>> listOfPathsDimensionMap = new ArrayList<>();
        Map<Position, Integer> mapOfDimensions = new HashMap<>();
        List<Integer> sumOfDimensions = new ArrayList<>();
        Position positionOfWire = new Position(0, 0);
        int pathDimension = 0;

        List<Position> listOfIntersectionPosition = getIntersectionPosition(listOfPathList);

        for (int wire = 0; wire < 2; wire++) {
            for (Path path : listOfPathList.get(wire)) {
                switch (path.getDirection()) {
                    case 'R': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX + 1);
                            pathDimension++;
                            if (isPositionCross(positionOfWire, listOfIntersectionPosition)) {
                                mapOfDimensions.put(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()), pathDimension);
                            }
                        }
                        break;
                    }
                    case 'L': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX - 1);
                            pathDimension++;
                            if (isPositionCross(positionOfWire, listOfIntersectionPosition)) {
                                mapOfDimensions.put(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()), pathDimension);
                            }
                        }
                        break;
                    }
                    case 'U': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldY = positionOfWire.getPositionY();
                            positionOfWire.setPositionY(oldY + 1);
                            pathDimension++;
                            if (isPositionCross(positionOfWire, listOfIntersectionPosition)) {
                                mapOfDimensions.put(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()), pathDimension);
                            }
                        }
                        break;
                    }
                    case 'D': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldY = positionOfWire.getPositionY();
                            positionOfWire.setPositionY(oldY - 1);
                            pathDimension++;
                            if (isPositionCross(positionOfWire, listOfIntersectionPosition)) {
                                mapOfDimensions.put(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()), pathDimension);
                            }
                        }
                        break;
                    }
                }
            }
            listOfPathsDimensionMap.add(new HashMap<>(mapOfDimensions));
            mapOfDimensions.clear();
            positionOfWire.setPositionX(0);
            positionOfWire.setPositionY(0);
            pathDimension = 0;
        }

        for (Position intersectionPosition1 : listOfPathsDimensionMap.get(0).keySet()) {
            for (Position intersectionPosition2 : listOfPathsDimensionMap.get(1).keySet()) {
                if (intersectionPosition1.equals(intersectionPosition2)) {
                    sumOfDimensions.add(listOfPathsDimensionMap.get(0).get(intersectionPosition1) + listOfPathsDimensionMap.get(1).get(intersectionPosition2));
                }
            }
        }
        return sumOfDimensions.stream().mapToInt(v -> v).min().getAsInt();
    }

    private boolean isPositionCross(Position positionOfWire, List<Position> listOfIntersectionPosition) {
        return listOfIntersectionPosition.contains(positionOfWire);
    }

    private List<Position> getIntersectionPosition(List<List<Path>> listOfPathList) {
        List<List<Position>> listOfPositionList = new ArrayList<>();
        List<Position> listPositionsOfWire = new ArrayList<>();
        for (List<Path> lp : listOfPathList) {
            Position positionOfWire = new Position(0, 0);
            for (Path path : lp) {
                switch (path.getDirection()) {
                    case 'R': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX + 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                    case 'L': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX - 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                    case 'U': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldY = positionOfWire.getPositionY();
                            positionOfWire.setPositionY(oldY + 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                    case 'D': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldY = positionOfWire.getPositionY();
                            positionOfWire.setPositionY(oldY - 1);
                            listPositionsOfWire.add(new Position(positionOfWire.getPositionX(), positionOfWire.getPositionY()));
                        }
                        break;
                    }
                }
            }
            listOfPositionList.add(new ArrayList<>(listPositionsOfWire));
            listPositionsOfWire.clear();
        }
        listOfPositionList.get(0).retainAll(listOfPositionList.get(1));
        return new ArrayList<>(listOfPositionList.get(0));
    }

    private List<List<Path>> getPaths() throws IOException {
        List<List<Path>> paths = new ArrayList<>();
        List<Path> pathsList = new ArrayList<>();

        java.nio.file.Path path = Paths.get("src/main/resources/Day3/data.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;

        while ((line = reader.readLine()) != null) {
            String[] linesWithSinglePaths = line.trim().split(",");
            for (String singlePath : linesWithSinglePaths) {
                pathsList.add(new Path(singlePath));
            }
            paths.add(new ArrayList<>(pathsList));
            pathsList.clear();
        }
        return paths;
    }
}
