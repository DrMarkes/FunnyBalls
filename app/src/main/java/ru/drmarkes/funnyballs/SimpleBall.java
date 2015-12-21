package ru.drmarkes.funnyballs;

/**
 * Created by Андрей on 21.12.2015.
 */
public class SimpleBall {
    protected int x, y, radius;

    public SimpleBall(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
