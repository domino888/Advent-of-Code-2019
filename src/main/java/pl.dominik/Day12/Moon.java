package main.java.pl.dominik.Day12;

public class Moon {

    private Coordinate position;
    private Coordinate velocity;

    private Boolean checked = false;

    public Moon() {
        velocity = new Coordinate(0, 0, 0);
    }

    public Moon deepCopy() {
        Moon deepCopy = new Moon();
        Coordinate positionCopy = new Coordinate(getPosition());
        Coordinate velocityCopy = new Coordinate(getVelocity());
        deepCopy.setPosition(positionCopy);
        deepCopy.setVelocity(velocityCopy);
        deepCopy.setChecked(getChecked());
        return deepCopy;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Coordinate getVelocity() {
        return velocity;
    }

    public void setVelocity(Coordinate velocity) {
        this.velocity = velocity;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
