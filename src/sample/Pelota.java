package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pelota extends AnimationTimer{

    private Group areaDibujo;
    private Circle ball;
    private double radio = 10;
    private double ballSpeedX = 5;
    private double ballSpeedY = 5;
    private double anchoAreaDibujo;
    private double altoAreaDibujo;

    public Pelota(double radio, double speed, Group regDibujo, double ancho, double alto){
           this.areaDibujo = regDibujo;
           this.radio = radio;
           this.ballSpeedX = speed;
           this.ball = new Circle(radio);
           this.ball.setFill(Color.rgb((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
           this.areaDibujo.getChildren().add(ball);
           this.ball.setTranslateX((int) (Math.random()* ancho));
           this.ball.setTranslateY((int) (Math.random()* alto));
           this.altoAreaDibujo = alto;
                   //areaDibujo.getBoundsInParent().getHeight();
           this.anchoAreaDibujo = ancho;
                   //areaDibujo.getBoundsInParent().getWidth();
    }

    // Game loop usando AnimationTimer
    @Override
    public void handle(long now) {
        // Cambiar la dirección de la bola si llega a los extremos
        if (ball.getTranslateX() < 0 || ball.getTranslateX() > this.anchoAreaDibujo) {
            ballSpeedX *= -1;
        }

        ball.setTranslateX(ball.getTranslateX() + ballSpeedX);

        if (ball.getTranslateY() < 0 || ball.getTranslateY() > this.altoAreaDibujo) {
            ballSpeedY *= -1;
        }

        ball.setTranslateY(ball.getTranslateY() + ballSpeedY);
    }
}