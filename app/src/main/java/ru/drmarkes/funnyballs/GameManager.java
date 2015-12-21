package ru.drmarkes.funnyballs;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Андрей on 17.12.2015.
 */
public class GameManager {
    private MainBall mainBall;
    private Paint paint;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int width, int height) {
        this.canvasView = canvasView;
        GameManager.width = width;
        GameManager.height = height;
        initMainBall();
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainBall() {
        mainBall = new MainBall(width / 2, height / 2);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainBall.getX(), mainBall.getY(), mainBall.getRadius(), paint);
    }
}
