package sample;

//import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static final double SCENE_WIDTH = 500;
    public static final double SCENE_HEIGHT = 500;
    public static final double BALL_RADIUS = 10;
    public static double ballSpeedX = 10;
    public static double ballSpeedY = 10;


    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        //Creación de pelotas

        // Bola que se usará para la animación
        /*Circle ball = new Circle(BALL_RADIUS);
        //ball.setTranslateX(SCENE_WIDTH * 0.5);
        ball.setTranslateX((int) (Math.random() * SCENE_WIDTH));
        ball.setTranslateY((int) (Math.random() * SCENE_HEIGHT));

        ball.setFill(Color.rgb((int) (Math.random() * 255),
                                (int) (Math.random() * 255),
                                (int) (Math.random() * 255)));
        root.getChildren().addAll(ball);*/

        //Creación de varias pelotas

        /*
        for (int cont = 0; cont < 1000; cont++){
            Ball b1 = new Ball(10, 10, 15, SCENE_WIDTH,
                    SCENE_HEIGHT, root);

            b1.start();
        }
        */

        Button btnAgregar = new Button("Agregar");
        btnAgregar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ball b1 = new Ball(10, 10, 15, SCENE_WIDTH,
                        SCENE_HEIGHT, root);

                b1.start();
            }
        });

        btnAgregar.setPrefWidth(70);
        btnAgregar.setLayoutX((SCENE_WIDTH - 70) / 2);
        btnAgregar.setLayoutY(20);
        root.getChildren().addAll(btnAgregar);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();


        // Game loop usando AnimationTimer

        /*AnimationTimer animationTimer = new AnimationTimer() {

            public void handle(long now) {
                // Mostrar la frecuencia de refresco FPS
               // PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
                //label.setText("FPS (AnimationTimer) = " + perfTracker.getInstantFPS());
                // Cambiar la dirección de la bola si llega a los extremos
                if(ball.getTranslateX() < 0 || ball.getTranslateX() > SCENE_WIDTH) {
                    ballSpeedX *= -1;
                }
                ball.setTranslateX(ball.getTranslateX() + ballSpeedX);

                if(ball.getTranslateY() < 0 || ball.getTranslateY() > SCENE_HEIGHT) {
                    ballSpeedY *= -1;
                }

                ball.setTranslateY(ball.getTranslateY() + ballSpeedY);

            }
        };

        animationTimer.start();*/

    }

    public static void main(String[] args) {
        launch(args);
    }

}