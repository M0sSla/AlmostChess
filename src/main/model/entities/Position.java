package main.model.entities;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if (x < 1 || y < 1 || x > 12 || y > 10) {
            //throw new IllegalAccessException("Invalid position: " + x + " " + y);

        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
