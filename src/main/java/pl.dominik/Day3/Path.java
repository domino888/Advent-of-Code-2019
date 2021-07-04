package main.java.pl.dominik.Day3;

public class Path {
    private Character direction;
    private Integer distance;

    public Character getDirection() {
        return direction;
    }

    public void setDirection(Character direction) {
        this.direction = direction;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Path(String instructionInString) {
        direction = instructionInString.charAt(0);
        distance = Integer.parseInt(instructionInString.substring(1));
    }

    @Override
    public String toString() {
        return "Path{" +
                "direction=" + direction +
                ", distance=" + distance +
                '}';
    }
}
