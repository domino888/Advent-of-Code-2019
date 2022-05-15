package main.java.pl.dominik.Day10;

import java.util.*;
import java.util.stream.Collectors;

public class Asteroid {

    private final Position position;
    private Position vaporisedAsteroidPosition;
    private List<Position> visibleNeighbors = new ArrayList<>();
    private Map<Position, Double> visibleNeighborsWithAngles = new LinkedHashMap<>();
    private final Map<Position, Position> neighborsWithVectors = new HashMap<>();
    int vaporisedAsteroidCounter = 0;

    public Asteroid(Position position) {
        this.position = position;
    }

    public void clear() {
        visibleNeighbors.clear();
        visibleNeighborsWithAngles.clear();
        neighborsWithVectors.clear();
    }

    public boolean runLaserAround(List<Asteroid> asteroids) {
        for (Map.Entry<Position, Double> entry : visibleNeighborsWithAngles.entrySet()) {
            if(vaporisedAsteroidCounter < 200){
                vaporisedAsteroidPosition = entry.getKey();
                asteroids.removeIf(asteroid -> asteroid.getPosition().equals(vaporisedAsteroidPosition));
                vaporisedAsteroidCounter++;
            }
        }
        return vaporisedAsteroidCounter < 200;
    }

    public void computeAngles() {
        for (Map.Entry<Position, Position> entry : neighborsWithVectors.entrySet()) {
            Position neighbor = entry.getKey();
            Position vector = entry.getValue();

            if (visibleNeighbors.contains(neighbor)) {
                Double angle = getAngle(vector);
                visibleNeighborsWithAngles.put(neighbor, angle);
            }
        }
        visibleNeighborsWithAngles = visibleNeighborsWithAngles.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public void computeVisibleNeighbors(int sizeOfMap) {
        for (Map.Entry<Position, Position> entry : neighborsWithVectors.entrySet()) {
            Position neighbor = entry.getKey();
            Position vector = entry.getValue();

            int movedX = neighbor.getX() + vector.getX();
            int movedY = neighbor.getY() + vector.getY();
            Position movedPosition = new Position(0, 0);

            while (movedX >= 0 && movedX < sizeOfMap && movedY >= 0 && movedY < sizeOfMap) {
                movedPosition.setNewPosition(movedX, movedY);
                visibleNeighbors.removeIf(key -> Objects.equals(key, movedPosition));

                movedX = movedX + vector.getX();
                movedY = movedY + vector.getY();
            }
        }
    }

    public void computeVectors(boolean blocked) {
        for (Position neighbor : visibleNeighbors) {
            int vectorX = neighbor.getX() - position.getX();
            int vectorY = neighbor.getY() - position.getY();

            if (blocked) {
                int greatestCommonDivisor = Math.abs(getGreatestCommonDivisor(vectorX, vectorY));
                vectorX = vectorX / greatestCommonDivisor;
                vectorY = vectorY / greatestCommonDivisor;
            }

            Position vector = new Position(vectorX, vectorY);
            neighborsWithVectors.put(neighbor, vector);
        }
    }

    public void setNeighborsPositions(List<Position> neighborsPositions) {
        this.visibleNeighbors = neighborsPositions;
    }

    private Double getAngle(Position vector) {
        Position startVector = new Position(0, -position.getY());
        Double numerator = (double) ((startVector.getX() * vector.getX()) + (startVector.getY() * vector.getY()));
        Double denominator = Math.sqrt(Math.pow(startVector.getX(), 2D) + Math.pow(startVector.getY(), 2D)) * Math.sqrt(Math.pow(vector.getX(), 2D) + Math.pow(vector.getY(), 2D));
        Double angle = (Math.acos(numerator / denominator) * 180) / Math.PI;

        if (vector.getX() < 0) {
            angle = 360 - angle;
        }
        return angle;
    }

    private int getGreatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGreatestCommonDivisor(b, a % b);
    }

    public int getNumberOfVisibleNeighbors() {
        return visibleNeighbors.size();
    }

    public Position getPosition() {
        return position;
    }

    public Position getVaporisedAsteroidPosition() {
        return vaporisedAsteroidPosition;
    }
}
