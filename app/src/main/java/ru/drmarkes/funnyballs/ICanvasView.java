package ru.drmarkes.funnyballs;

/**
 * Created by Андрей on 21.12.2015.
 */
public interface ICanvasView {
    void drawBall(SimpleBall ball);

    void redraw();

    void showMessage(String text);
}
