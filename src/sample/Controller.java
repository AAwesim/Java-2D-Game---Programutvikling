package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Main.GAME_NAME;
import static sample.Main.SCREEN_HEIGHT;
import static sample.Main.SCREEN_WIDTH;


public class Controller {

    //Ballinfo
    double ballRadius = 40;
    double ballX = 0;
    double ballY = SCREEN_HEIGHT/2;
    double xSpeed = 4;

    String gameScreen = "gameScene.fxml";
    String hjelpScreen = "hjelpScene.fxml";

    public void setStartScene(ActionEvent e) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource(gameScreen));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene startScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);

        //Lager et element
        Circle ball = new Circle();
        ball.setCenterX(ballX);
        ball.setCenterY(ballY);
        ball.setRadius(ballRadius);
        ball.setFill(Color.BLUE);
        root.getChildren().add(ball);

        stage.setOnCloseRequest(event -> {
            exitScreen();
        });
        stage.setResizable(false);
        stage.setTitle(GAME_NAME);
        stage.setScene(startScene);
        stage.show();

        AnimationTimer animator = new AnimationTimer() {

            @Override
            public void handle(long arg0) {

                // UPDATE
                ballX += xSpeed;

                if (ballX + ballRadius >= SCREEN_WIDTH)
                {
                    ballX = SCREEN_WIDTH - ballRadius;
                    xSpeed *= -1;
                }
                else if (ballX - ballRadius < 0)
                {
                    ballX = 0 + ballRadius;
                    xSpeed *= -1;
                }

                // RENDER
                ball.setCenterX(ballX);

            }
        };

        animator.start();
    }

    public void exitScreen() {
        System.exit(0);
    }

}
