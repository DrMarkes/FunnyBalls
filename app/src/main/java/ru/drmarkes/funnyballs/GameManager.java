package ru.drmarkes.funnyballs;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Андрей on 17.12.2015.
 */
public class GameManager {
    private MainBall mainBall;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int width, int height) {
        this.canvasView = canvasView;
        GameManager.width = width;
        GameManager.height = height;
        initMainBall();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainBall() {
        mainBall = new MainBall(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawBall(mainBall);
    }

    public void onTouchEvent(int x, int y) {
        mainBall.moveMainBallWhenTouchAt(x, y);
    }
}
