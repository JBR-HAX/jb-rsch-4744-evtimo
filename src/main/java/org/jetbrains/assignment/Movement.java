package org.jetbrains.assignment;

public class Movement {
    public Movement(Direction direction, int steps) {
        setDirection(String.valueOf(direction));
        setSteps(steps);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    private int steps;

    private String direction;

    public String getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "{" +
            "\"direction\":\"" + direction + "\"," +
            "\"steps\":" + steps +
            '}';
    }
}