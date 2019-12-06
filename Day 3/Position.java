package pl.kanthak;

import java.util.Objects;

public class Position {

    private Integer positionX;
    private Integer positionY;

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Position(Integer positionX, Integer positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getPositionX().equals(position.getPositionX()) &&
                getPositionY().equals(position.getPositionY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositionX(), getPositionY());
    }
}
