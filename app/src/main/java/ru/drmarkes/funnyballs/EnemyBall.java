package ru.drmarkes.funnyballs;

import java.util.Random;

/**
 * Created by Андрей on 21.12.2015.
 */
public class EnemyBall extends SimpleBall{


    private static final int FROM_RADIUS = 10;
    private static int TO_RADIUS = 110;

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
}
