package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends AnimationTimer{
    private Circle ball;

    private double ballSpeedX = 10;
    private double ballSpeedY = 10;
    private double radio = 10;

    private double scene_width = 300;
    private double scene_heigth = 250;
    private Group areaDibujo;

    public Ball(double ballSpeedX, double ballSpeedY, double radio, double scene_width,
                double scene_heigth, Group areaDibujo) {
        this.ballSpeedX = ballSpeedX;
        this.ballSpeedY = ballSpeedY;
        this.radio = radio;
        this.scene_width = scene_width;
        this.scene_heigth = scene_heigth;
        this.areaDibujo = areaDibujo;

        ball = new Circle(this.radio);
        ball.setFill(Color.rgb((int) (Math.random() * 255),
                                    (int) (Math.random() * 255),
                                    (int) (Math.random() * 255)));
        ball.setTranslateX((int) (Math.random() * this.scene_width));
        ball.setTranslateY((int) (Math.random() * this.scene_heigth));

        this.areaDibujo.getChildren().add(ball);
    }

    public void handle(long now) {
        // Mostrar la frecuencia de refresco FPS
        // PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
        //label.setText("FPS (AnimationTimer) = " + perfTracker.getInstantFPS());
        // Cambiar la dirección de la bola si llega a los extremos
        if(ball.getTranslateX() < 0 || ball.getTranslateX() > this.scene_width) {
            ballSpeedX *= -1;
        }
        ball.setTranslateX(ball.getTranslateX() + ballSpeedX);

        if(ball.getTranslateY() < 0 || ball.getTranslateY() > this.scene_heigth) {
            ballSpeedY *= -1;
        }

        ball.setTranslateY(ball.getTranslateY() + ballSpeedY);
    }
}
