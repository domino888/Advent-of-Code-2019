package pl.kanthak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stage2 {

    private static List<Position> listPositionsOfWire = new ArrayList<>();
    private static List<List<Position>> listOfPositionList = new ArrayList<>();
    private static List<List<Path>> listOfPathList = new ArrayList<>();
    private static List<Position> listOfIntersectionPosition = getIntersectionPosition();

    public static void main(String[] args) {

        List<Map<Position, Integer>> listOfPathsDimensionMap = new ArrayList<>();
        Map<Position, Integer> mapOfDimensions = new HashMap<>();
        List<Integer> sumOfDimensions = new ArrayList<>();
        Position positionOfWire = new Position(0, 0);
        int pathDimension = 0;

        for (int wire = 0; wire < 2; wire++) {
            for (Path path : listOfPathList.get(wire)) {
                switch (path.getDirection()) {
                    case 'R': {
                        for (int i = 0; i < path.getDistance(); i++) {
                            int oldX = positionOfWire.getPositionX();
                            positionOfWire.setPositionX(oldX + 1);
                            pathDimension++;
                            if (isPositionCross(positionOfWire)) {
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
                            if (isPositionCross(positionOfWire)) {
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
                            if (isPositionCross(positionOfWire)) {
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
                            if (isPositionCross(positionOfWire)) {
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
            for(Position intersectionPosition2 : listOfPathsDimensionMap.get(1).keySet()){
                if(intersectionPosition1.equals(intersectionPosition2)){
                    sumOfDimensions.add(listOfPathsDimensionMap.get(0).get(intersectionPosition1) + listOfPathsDimensionMap.get(1).get(intersectionPosition2));
                }
            }
        }
        System.out.println(sumOfDimensions
                .stream()
                .mapToInt(v -> v)
                .min()
                .getAsInt());
    }

    static private boolean isPositionCross(Position positionOfWire) {
        return listOfIntersectionPosition.contains(positionOfWire);
    }

    static private List<Position> getIntersectionPosition() {

        for (int counter = 0; counter < 2; counter++) {
            Position positionOfWire = new Position(0, 0);
            listOfPathList.add(getPaths());

            for (Path path : listOfPathList.get(counter)) {
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

    static private List<Path> getPaths() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        List<Path> pathsList = new ArrayList<>();

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] linesWithSinglePaths = line.trim().split(",");

        for (String singlePath : linesWithSinglePaths) {
            pathsList.add(new Path(singlePath));
        }
        return pathsList;
    }
}
