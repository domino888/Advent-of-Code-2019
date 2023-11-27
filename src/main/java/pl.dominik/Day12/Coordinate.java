package main.java.pl.dominik.Day12;

import java.util.Objects;

public class Coordinate {

    private Integer x;
    private Integer y;
    private Integer z;

    public Coordinate(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate coordinate)) return false;
        return Objects.equals(getX(), coordinate.getX()) && Objects.equals(getY(), coordinate.getY()) && Objects.equals(getZ(), coordinate.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Coordinate(Coordinate coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
        this.z = coordinate.getZ();
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }
}
