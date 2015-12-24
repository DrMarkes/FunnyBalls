package ru.drmarkes.funnyballs;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Андрей on 17.12.2015.
 */
public class GameManager {
    private static final int MAX_ENEMYBALLS = 10;
    private MainBall mainBall;
    private ArrayList<EnemyBall> enemyBalls;
    private ICanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(ICanvasView canvasView, int width, int height) {
        this.canvasView = canvasView;
        GameManager.width = width;
        GameManager.height = height;
        initMainBall();
        initEnemyBalls();
    }

    private void initEnemyBalls() {
        SimpleBall mainBallArea = mainBall.getBallArea();
        enemyBalls = new ArrayList<>();
        for (int i = 0; i < MAX_ENEMYBALLS; i++) {
            EnemyBall enemyBall;
            do {
                enemyBall = EnemyBall.getRandomBall();
                enemyBall.setRadius(recalculateRadius(enemyBall.getRadius()));
            } while (enemyBall.isIntersect(mainBallArea));
            enemyBalls.add(enemyBall);
        }
        calculateAndSetBallsColor();
    }

    private void calculateAndSetBallsColor() {
        for(EnemyBall ball: enemyBalls) {
            ball.setEnemyOrFoodColorDependsOn(mainBall);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainBall() {
        mainBall = new MainBall(width / 2, height / 2);
        mainBall.setRadius(recalculateRadius(mainBall.getRadius()));
    }

    public void onDraw() {
        canvasView.drawBall(mainBall);
        for (EnemyBall enemyBall: enemyBalls) {
            canvasView.drawBall(enemyBall);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainBall.moveMainBallWhenTouchAt(x, y);
        checkCollision();
        moveBalls();
    }

    private void checkCollision() {
        SimpleBall ballForDel = null;
        for(EnemyBall ball: enemyBalls) {
            if(mainBall.isIntersect(ball)) {
                if(ball.isSmallerThan(mainBall)) {
                    mainBall.growRadius(ball);
                    ballForDel = ball;
                    calculateAndSetBallsColor();
                    break;
                } else {
                    gameOver("YOU LOSE!");
                    return;
                }
            }
        }
        if(ballForDel != null) {
            enemyBalls.remove(ballForDel);
        }
        if(enemyBalls.isEmpty()) {
            gameOver("YOU WIN!");
        }
    }

    private void gameOver(String text) {
        canvasView.showMessage(text);
        mainBall.initRadius();
        initEnemyBalls();
        canvasView.redraw();
    }


    private void moveBalls() {
        for(EnemyBall ball: enemyBalls) {
            ball.moveOneStep();
        }
    }

    public static int recalculateRadius(int radius) {
        return radius * (width < height ? width : height) / 768;
    }
}
