package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.Entity.EntityCreater;
import sample.Entity.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable, EventHandler<KeyEvent> {
    //Instansierer FXML Variabelen til Canvas i gameController
    @FXML Canvas can1;

    //Oppretter Entity factory, deretter oppretter et player objekt
    private EntityCreater ec = new EntityCreater();
    private Player mainPlayer = (Player) ec.getEntity("PLAYER");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Setter opp canvas, GraphicsContext, keyInput
        GraphicsContext gc = can1.getGraphicsContext2D();
        can1.setFocusTraversable(true);
        can1.requestFocus();
        can1.setOnKeyPressed(this::handle);

        // Ber EntityCreater om å lage et player objekt
        mainPlayer.createAvatar();

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                mainPlayer.render(gc);
            }

        };

        timer.start();

    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.SPACE){
            System.out.println(keyEvent.toString());
        }

        else if(keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT){
            mainPlayer.setPosX(5);
            System.out.println(keyEvent.toString());
        }

        else if(keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT){
            mainPlayer.setPosX(-5);
        }

        else if(keyEvent.getCode() == KeyCode.S || keyEvent.getCode() == KeyCode.DOWN){
            mainPlayer.setPosY(5);
        }

        else if(keyEvent.getCode() == KeyCode.W || keyEvent.getCode() == KeyCode.UP){
            mainPlayer.setPosY(-5);
        }

        else if(keyEvent.getCode() == KeyCode.ESCAPE){
            Stage stage = (Stage) ((Node)keyEvent.getSource()).getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("meny.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

}
