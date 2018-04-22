package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Entity.*;
import sample.Map.mapCreator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable, EventHandler<KeyEvent> {
    @FXML Pane gamePane;

    //Oppretter Entity factory, deretter oppretter et player objekt
    private EntityCreator ec = new EntityCreator();
    private Player mainPlayer = (Player) ec.getEntity("PLAYER");
    private mapCreator mc = new mapCreator();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keyHandlerInit(gamePane);
        mainPlayer.init(gamePane);
        mc.initMap(gamePane);

        BackgroundImage BI= new BackgroundImage(new Image("file:ressurser\\\\Hills.png",640,480,
                false,true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        gamePane.setBackground(new Background(BI));

        //denne tester bare om den skriver heisann for hvert element i arraylisten
        //mc.checker();

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                mainPlayer.updatePlayerState();
                mainPlayer.renderPlayer();
                mc.playerMapCollisionChecker(mainPlayer);

            }
        };

        timer.start();

    }

    public void keyHandlerInit(Pane p){
        p.setFocusTraversable(true);
        p.requestFocus();
        p.setOnKeyPressed(this::handle);
        p.setOnKeyReleased(e -> {
            if(e.getCode() == KeyCode.A){
                mainPlayer.setDirection(5);
            }
            else if(e.getCode() == KeyCode.D){
                mainPlayer.setDirection(5);
            }
        });
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.SPACE){
           System.out.println(keyEvent.toString());
        }

        else if(keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT){
            mainPlayer.setDirection(0);
        }

        else if(keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT){
            mainPlayer.setDirection(1);
        }

        else if(keyEvent.getCode() == KeyCode.S || keyEvent.getCode() == KeyCode.DOWN){
            mainPlayer.setPosY(5);
        }

        else if(keyEvent.getCode() == KeyCode.W || keyEvent.getCode() == KeyCode.UP){
            mainPlayer.setPosY(-5);
        }

        else if(keyEvent.getCode() == KeyCode.F1){
            mainPlayer.setPosX(320-mainPlayer.getPosX());
            mainPlayer.setPosY(240-mainPlayer.getPosY());
            mainPlayer.setySpeed(0);
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
