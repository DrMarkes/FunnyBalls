package ru.drmarkes.funnyballs;

/**
 * Created by Андрей on 21.12.2015.
 */
public class SimpleBall {
    protected int x, y, radius;
    private int color;

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public SimpleBall getBallArea() {
        return new SimpleBall(x, y, radius * 3);
    }

    public boolean isIntersect(SimpleBall ball) {
        return radius + ball.radius >= Math.sqrt(Math.pow(x - ball.x, 2) + Math.pow(y - ball.y, 2));
    }
}
