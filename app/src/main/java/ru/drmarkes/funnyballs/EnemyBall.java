package ru.drmarkes.funnyballs;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Андрей on 21.12.2015.
 */
public class EnemyBall extends SimpleBall{

    private static final int FROM_RADIUS = 10;
    private static final int TO_RADIUS = 110;
    private static final int ENEMY_COLOR = Color.RED;
    private static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    private static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyBall(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyBall getRandomBall() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyBall enemyBall = new EnemyBall(x, y, radius, dx, dy);
        return enemyBall;
    }

    public void setEnemyOrFoodColorDependsOn(MainBall mainBall) {
        if(isSmallerThan(mainBall)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    private boolean isSmallerThan(SimpleBall ball) {
        if(this.getRadius() < ball.getRadius()) {
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if(x > GameManager.getWidth() || x < 0) {
            dx = -dx;
        }
        if(y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }
    }
}
