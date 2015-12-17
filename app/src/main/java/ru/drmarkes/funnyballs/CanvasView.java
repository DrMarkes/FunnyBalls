package ru.drmarkes.funnyballs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Андрей on 17.12.2015.
 */
public class CanvasView extends View {
    private MainBall mainBall;
    private Paint paint;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMainBall();
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainBall() {
        mainBall = new MainBall(200, 500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mainBall.getX(), mainBall.getY(), mainBall.getRadius(), paint);
    }
}
