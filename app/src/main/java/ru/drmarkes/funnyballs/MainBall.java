package ru.drmarkes.funnyballs;

/**
 * Created by Андрей on 17.12.2015.
 */
public class MainBall {
    private int x, y, radius;
    private static final int INIT_RADIUS = 50;

    public MainBall(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = INIT_RADIUS;
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

