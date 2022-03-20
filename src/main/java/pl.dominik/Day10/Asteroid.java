package main.java.pl.dominik.Day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Asteroid {

    private final Position position;
    private List<Asteroid> neighborsAsteroids = new ArrayList<>();
    private Map<Asteroid, Position> neighborsWithVectors = new HashMap<>();

    public Asteroid(Position position) {
        this.position = position;
    }

    public void computeVisibleNeighbors(int sizeOfMap) {
        for (Map.Entry<Asteroid, Position> entry : neighborsWithVectors.entrySet()) {
            Position asteroidPosition = entry.getKey().getPosition();
            List<Asteroid> neighbors = entry.getKey().getNeighborsAsteroids();
            Position vector = entry.getValue();
            Asteroid asteroid = entry.getKey();

            for (Asteroid neighbor : neighbors) {
                Position movedPosition = new Position(neighbor.getPosition().getX() + vector.getX(), neighbor.getPosition().getY() + vector.getY());

                asteroid.getNeighborsAsteroids()

            }

        }
    }

    public void computeVectors() {
        for (Asteroid neighbor : neighborsAsteroids) {
            int vectorX = neighbor.position.getX() - position.getX();
            int vectorY = neighbor.position.getY() - position.getY();

            int greatestCommonDivisor = Math.abs(getGreatestCommonDivisor(vectorX, vectorY));

            vectorX = vectorX / greatestCommonDivisor;
            vectorY = vectorY / greatestCommonDivisor;

            Position vector = new Position(vectorX, vectorY);
            neighborsWithVectors.put(neighbor, vector);
        }
    }

    private void findPositionInNeighbors(Position position){
        neighborsAsteroids.
    }

    private int getGreatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGreatestCommonDivisor(b, a % b);
    }

    public void setNeighbors(List<Asteroid> neighborsAsteroids) {
        this.neighborsAsteroids = neighborsAsteroids;
    }

    public List<Asteroid> getNeighborsAsteroids() {
        return neighborsAsteroids;
    }

    public Position getPosition() {
        return position;
    }
}
