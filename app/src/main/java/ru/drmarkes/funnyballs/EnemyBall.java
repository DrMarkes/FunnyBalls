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

    public EnemyBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyBall getRandomBall() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyBall enemyBall = new EnemyBall(x, y, radius);
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
}
