package ru.drmarkes.funnyballs;

import android.graphics.Color;

/**
 * Created by Андрей on 17.12.2015.
 */
public class MainBall extends SimpleBall {
    private static final int MAIN_SPEED = 30;
    private static final int INIT_RADIUS = 50;
    private static final int OUR_COLOR = Color.BLUE;

    public MainBall(int x, int y) {
        super(x, y, INIT_RADIUS);
        setColor(OUR_COLOR);
    }

    public void moveMainBallWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    public void initRadius() {
        this.radius = GameManager.recalculateRadius(INIT_RADIUS);
    }

    public void growRadius(SimpleBall ball) {
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(ball.radius, 2));
    }
}

