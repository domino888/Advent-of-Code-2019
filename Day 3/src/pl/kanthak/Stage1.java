package pl.kanthak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stage1 {

    public static void main(String[] args) {

        List<Position> listPositionsOfWire = new ArrayList<>();
        List<List<Position>> listOfPositionList = new ArrayList<>();
        List<Integer> distancesFromCenterPoint = new ArrayList<>();
        Position positionOfWire = new Position(0, 0);
        int oldX;
        int oldY;

        for (int counter = 0; counter < 2; counter++) {
            List<Path> listPathsOfWire = getPaths();

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

        for(Position position: listOfPositionList.get(0)){
            distancesFromCenterPoint.add(Math.abs(position.getPositionX()) + Math.abs(position.getPositionY()));
        }

        System.out.println(distancesFromCenterPoint
                .stream()
                .mapToInt(v -> v)
                .min()
                .getAsInt());
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
