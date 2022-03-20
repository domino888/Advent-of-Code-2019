package main.java.pl.dominik.Day10;

import java.util.*;

public class Asteroid {

    private final Position position;
    private List<Position> neighborsPositions = new ArrayList<>();
    private final Map<Position, Position> neighborsWithVectors = new HashMap<>();

    public Asteroid(Position position) {
        this.position = position;
    }

    public int getNumberOfVisibleNeighbors() {
        return neighborsPositions.size();
    }

    public void computeVisibleNeighbors(int sizeOfMap) {
        for (Map.Entry<Position, Position> entry : neighborsWithVectors.entrySet()) {
            Position neighbor = entry.getKey();
            Position vector = entry.getValue();

            int movedX = neighbor.getX() + vector.getX();
            int movedY = neighbor.getY() + vector.getY();

            while (movedX >= 0 && movedX < sizeOfMap && movedY >= 0 && movedY < sizeOfMap) {
                Position movedPosition = new Position(movedX, movedY);
                neighborsPositions.removeIf(key -> Objects.equals(key, movedPosition));

                movedX = movedX + vector.getX();
                movedY = movedY + vector.getY();
            }
        }
    }

    public void computeVectors() {
        for (Position neighborPosition : neighborsPositions) {
            int vectorX = neighborPosition.getX() - position.getX();
            int vectorY = neighborPosition.getY() - position.getY();

            int greatestCommonDivisor = Math.abs(getGreatestCommonDivisor(vectorX, vectorY));

            vectorX = vectorX / greatestCommonDivisor;
            vectorY = vectorY / greatestCommonDivisor;

            Position vector = new Position(vectorX, vectorY);
            neighborsWithVectors.put(neighborPosition, vector);
        }
    }

    private int getGreatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGreatestCommonDivisor(b, a % b);
    }

    public void setNeighborsPositions(List<Position> neighborsPositions) {
        this.neighborsPositions = neighborsPositions;
    }

    public Position getPosition() {
        return position;
    }
}
