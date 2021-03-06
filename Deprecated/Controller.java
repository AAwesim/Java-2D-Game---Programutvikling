package Deprecated;


import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.GAME_NAME;
import static sample.Main.SCREEN_HEIGHT;
import static sample.Main.SCREEN_WIDTH;


public class Controller implements Initializable, EventHandler<KeyEvent> {



    //Ballinfo
    private double ballRadius = 50;
    private double ballX = 0;
    private double ballY = SCREEN_HEIGHT / 2;
    private double xSpeed = 5;
    private double ySpeed = 5;

    /*String gameScreen = "gameScene.fxml";
    String hjelpScreen = "hjelpScene.fxml";*/

    public void setStartScene(ActionEvent e) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("gameScene.fxml"));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene startScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
<<<<<<< HEAD:src/sample/Controller.java

        //Keyboard input - Det som skjer er at en usynlig box blir en del av root. Den
        StackPane keyboardInputNode = new StackPane();
        keyboardInputNode.setFocusTraversable(true);
        keyboardInputNode.requestFocus();

        keyboardInputNode.setOnKeyReleased(this::handle);

        root.getChildren().add(keyboardInputNode);

        //Lager et element

        Canvas canvas= new Canvas(SCREEN_WIDTH,SCREEN_HEIGHT);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        
        gc.fillRect(60,60,60,60);
        gc.fillText("AnAAAAAAAAAeAAAAAAAAAAAg",60,60);
        root.getChildren().add(canvas);

        Circle ball = new Circle();
        ball.setCenterX(ballX);
        ball.setCenterY(ballY);
        ball.setRadius(ballRadius);
        ball.setFill(Color.GREEN);
        root.getChildren().add(ball);

        ball.setAccessibleText("er");

=======
>>>>>>> Asim:Deprecated/Controller.java
        stage.setOnCloseRequest(event -> exitScreen());
        stage.setResizable(false);
        stage.setTitle(GAME_NAME);
        stage.setScene(startScene);
        stage.show();

    }


    @Override
    public void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.SPACE) {
            xSpeed *= -1; //skifter retning
            System.out.println("Keypressed" + e.getCode()); //Debugging

        }
    }

    public void exitScreen() {
        System.exit(0);
    }

    public void update() {
        ballX += xSpeed;
        ballY += ySpeed;

        checkBorder(ballY, SCREEN_HEIGHT);
        checkBorder(ballX, SCREEN_WIDTH);

    }

    public void checkBorder(double ballCord, double screen) {
        if (screen == SCREEN_HEIGHT) {
            if (ballCord + ballRadius >= SCREEN_HEIGHT) {
                ballY = SCREEN_HEIGHT - ballRadius;
                ySpeed *= -1;
            } else if (ballCord - ballRadius < 0) {
                ballY = 0 + ballRadius;
                ySpeed *= -1;
            }
        } else if (screen == SCREEN_WIDTH) {
            if (ballCord + ballRadius >= SCREEN_WIDTH) {
                ballX = SCREEN_WIDTH - ballRadius;
                xSpeed *= -1;
            } else if (ballCord - ballRadius < 0) {
                ballX = 0 + ballRadius;
                xSpeed *= -1;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Keyboard input - Det som skjer er at en usynlig box blir en del av root. Den
        StackPane keyboardInputNode = new StackPane();
        keyboardInputNode.setFocusTraversable(true);
        keyboardInputNode.requestFocus();

        keyboardInputNode.setOnKeyReleased(this);

        //root.getChildren().add(keyboardInputNode);

        //Lager et element

        /*gc.setFill(Color.RED);
        gc.fillRect(50,50,50,50);*/


        Circle ball = new Circle();
        ball.setCenterX(ballX);
        ball.setCenterY(ballY);
        ball.setRadius(ballRadius);
        ball.setFill(Color.GREEN);
        //root.getChildren().add(ball);

        AnimationTimer animator = new AnimationTimer() {

            @Override
            public void handle(long now) {

                // UPDATE
                /*update();*/

                // RENDER
                /*ball.setCenterX(ballX);
                ball.setCenterY(ballY);*/

            }
        };

        /*ball.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            ball.setFill(Color.color(Math.random(), Math.random(), Math.random()));

        });*/

        animator.start();

    }
}
