package main.java.pl.dominik.Day10;

import java.util.*;

public class Asteroid {

    private final Position position;
    private Position movedPosition = new Position(-1, -1);
    private List<Position> neighborsPositions = new ArrayList<>();
    private List<Position> vaporisedAsteroids = new ArrayList<>();
    private final Map<Position, Position> neighborsWithVectors = new HashMap<>();

    public Asteroid(Position position) {
        this.position = position;
    }

    public void move(int sizeOfMap) {


        //to delete
//        position.setNewPosition(4, 2);

//        while (!neighborsPositions.isEmpty()) {
        for (int i = 0; i < 4; i++) {
            int upMax = position.getY();
            int downMax = sizeOfMap - 1 - position.getY();
            int leftMax = position.getX();
            int rightMax = sizeOfMap - 1 - position.getX();

            moveUp(upMax);
            moveRight(rightMax);
            moveDown(downMax);
            moveLeft(leftMax);
            System.out.println(vaporisedAsteroids.size());
        }
    }

    private void moveUpAndRight(int upMax, int rightMax) {
        movedPosition.setNewPosition(position);
        int up = this.getPosition().getY();
        int right = this.getPosition().getX();

        for (int i = 0; i < upMax; i++) {
            up--;
            movedPosition.setNewPosition(position.getX(), up);
            if (neighborsPositions.removeIf(position -> Objects.equals(position, movedPosition))) {
                vaporisedAsteroids.add(movedPosition);
                break;
            }
        }
    }

    private void moveUp(int upMax) {
        movedPosition.setNewPosition(position);
        int up = this.getPosition().getY();

        for (int i = 0; i < upMax; i++) {
            up--;
            movedPosition.setNewPosition(position.getX(), up);
            if (neighborsPositions.removeIf(position -> Objects.equals(position, movedPosition))) {
                vaporisedAsteroids.add(movedPosition);
                break;
            }
        }
    }

    private void moveDown(int downMax) {
        movedPosition.setNewPosition(position);
        int down = this.getPosition().getY();

        for (int i = 0; i < downMax; i++) {
            down++;
            movedPosition.setNewPosition(position.getX(), down);
            if (neighborsPositions.removeIf(position -> Objects.equals(position, movedPosition))) {
                vaporisedAsteroids.add(movedPosition);
                break;
            }
        }
    }

    private void moveRight(int rightMax) {
        movedPosition.setNewPosition(position);
        int right = this.getPosition().getX();

        for (int i = 0; i < rightMax; i++) {
            right++;
            movedPosition.setNewPosition(right, position.getY());
            if (neighborsPositions.removeIf(position -> Objects.equals(position, movedPosition))) {
                vaporisedAsteroids.add(movedPosition);
                break;
            }
        }
    }

    private void moveLeft(int leftMax) {
        movedPosition.setNewPosition(position);
        int left = this.getPosition().getX();

        for (int i = 0; i < leftMax; i++) {
            left--;
            movedPosition.setNewPosition(left, position.getY());
            if (neighborsPositions.removeIf(position -> Objects.equals(position, movedPosition))) {
                vaporisedAsteroids.add(movedPosition);
                break;
            }
        }
    }

    public void resetNeighborsPositions() {
        neighborsPositions.clear();
        neighborsPositions = new ArrayList<>(neighborsWithVectors.keySet());
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
            Position movedPosition = new Position(0, 0);

            while (movedX >= 0 && movedX < sizeOfMap && movedY >= 0 && movedY < sizeOfMap) {
                movedPosition.setNewPosition(movedX, movedY);
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
