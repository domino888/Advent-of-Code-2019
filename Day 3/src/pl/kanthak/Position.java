package pl.kanthak;

import java.util.Objects;

public class Position {

    private int positionX;
    private int positionY;

    public int getPositionX() {
        return positionX;
    }

    public Position(Position position) {

    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getPositionX() == position.getPositionX() &&
                getPositionY() == position.getPositionY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositionX(), getPositionY());
    }
}
