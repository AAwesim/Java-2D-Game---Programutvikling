package sample.Core;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import sample.Entity.*;
import sample.Map.mapCreator;
import sample.helper.StateManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.color;

public class gameController implements Initializable {

    @FXML Pane gamePane;
    @FXML Pane gpWrap;

    private EntityCreator ec = new EntityCreator();
    private Player mainPlayer = (Player) ec.getEntity("PLAYER");
    private AnimationTimer timer;
    private mapCreator mc = new mapCreator();
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public int i = 0;

    BackgroundImage BI= new BackgroundImage(new Image("file:ressurser\\\\Hills.png",805,525,false,true),BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keyHandlerInit(gamePane);
        mainPlayer.init(gamePane);
        mc.initMap(gamePane);

        gamePane.setBackground(new Background(BI));

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {


               /* System.out.println(mainPlayer.getPosX());
                if(playerMapCollisionChecker(mainPlayer)) {
                    mainPlayer.gravity();
                }*/
               keys();
                //mainPlayer.gravity();
               // System.out.println(playerMapCollisionChecker(mainPlayer));
               // mainPlayer.updatePlayerState();
                mainPlayer.updatePlayerState();
                mainPlayer.renderPlayer();

                //playerMapCollisionChecker(mainPlayer);
                view();
               // playerMapCollisionChecker2(mainPlayer);
              //  System.out.println(mainPlayer.getySpeed());
               // System.out.println(mainPlayer.getPosY());
            }
        };

        timer.start();

    }


    /*private int left = 0;
    private int right = 1;*/
    public void keyHandlerInit(Pane p){
        p.setFocusTraversable(true);
        p.requestFocus();
        p.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        p.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });
    ;}

    private boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }


    public void keys() {

       if (isPressed(KeyCode.A)){
            Direction(-1);
        }

        else if (isPressed(KeyCode.D)){
            Direction(1);
        }

        else if (isPressed(KeyCode.W)) {
            //if(!playerMapCollisionChecker(mainPlayer)){
            mainPlayer.setPosY(mainPlayer.getPosY() - 4);
            //mainPlayer.setySpeed(-7);
       // }
        }

        else if(isPressed(KeyCode.F1)){
            mainPlayer.setPosX(
                    0.0);
            mainPlayer.setPosY(0.0);
            mainPlayer.setySpeed(0);
        }

<<<<<<< HEAD
        else if(keyEvent.getCode() == KeyCode.ESCAPE){
=======
        /*else if(keyEvent.getCode() == KeyCode.ESCAPE){
>>>>>>> jakobtemp
            Stage stage = (Stage) ((Node)keyEvent.getSource()).getScene().getWindow();

            StateManager.setState(StateManager.GameState.MAINMENU);
            stage.setScene(StateManager.update());

            stage.setResizable(false);
            stage.show();
        }*/
    }

    public void Direction(int dir) {
        for (int a = 0; a<4;a++){
            mainPlayer.setX(mainPlayer.getPosX());
            mainPlayer.setY(mainPlayer.getPosY());

             for(Rectangle mapPart:mc.getMap()){
                 if(mapPart.intersects(mainPlayer.getPosX(),mainPlayer.getPosY(),mainPlayer.getWidth(),mainPlayer.getHeight())
                         );{
                    if(dir== -1) {
                        if (mainPlayer.getX() == (mapPart.getX() + mapPart.getWidth())) {

                         return;
                        }
                    }
                    if(dir == 1) {
                        if ((mainPlayer.getPosX() + mainPlayer.getWidth()) == (mapPart.getX())) {
                            System.out.println(mainPlayer.getX() + mainPlayer.getWidth());
                            System.out.println(mapPart.getX());
                            System.out.println(mapPart.getBoundsInLocal());
                            System.out.println(mainPlayer.getBoundsInLocal());
                            return;
                        }

                        }
                    }
                 }mainPlayer.setDirection(dir);

             }

        }
          //mainPlayer.setySpeed(0);
     //else { mainPlayer.gravity();
            //}



 /*   public void playerMapCollisionChecker2(Player p){
        for(Rectangle mapPart:mc.getMap()){
            if(mapPart.intersects(mainPlayer.getX(),mainPlayer.getY(),mainPlayer.getWidth(),mainPlayer.getHeight())){
                if(mainPlayer.getDirection()==0 && 0.4<mainPlayer.getySpeed() && mainPlayer.getySpeed()<0.4) {
                    mainPlayer.setPosX(mapPart.getX()+mapPart.getWidth()+1);
                    mainPlayer.setxSpeed(0);
                    return;
                } else if(mainPlayer.getDirection()==1 && 0.4<mainPlayer.getySpeed() && mainPlayer.getySpeed()<0.4 ) {
                    mainPlayer.setPosX(mapPart.getX()-mainPlayer.getWidth()-1);
                    mainPlayer.setxSpeed(0);
                    return;
                }

                // formålet er å sjekke om mainPlayer kolliderer med mapPart ovenfra eller nedenifra
                // condition uttrykket: sjekker om player sin posisjon er mindre(lenger opp på sjermen)enn summen av mapPart sin posisjon+høyde/2 og i
                // tillegg om direction er 0 eller 1 (om a eller d holdes inne)
                if((mainPlayer.getPosY()+mainPlayer.getHeight())<(mapPart.getY()+mapPart.getHeight()/2) &&( mainPlayer.getDirection()!=0 || mainPlayer.getDirection()!=1) ) {
                    mainPlayer.setySpeed(0);
                    mainPlayer.setPosY(mapPart.getY()-mainPlayer.getHeight()-1);
                    return;
                }

                //samme som over bare motsatt.om player pos er lenger ned en senter på mappart.
                if((mainPlayer.getPosY())>(mapPart.getY()+mapPart.getHeight()/2) && (mainPlayer.getDirection()!=0 || mainPlayer.getDirection()!=1) ) {
                    mainPlayer.setySpeed(0);
                    mainPlayer.setPosY(mapPart.getY()+mapPart.getHeight()+1);
                    return;
                }

                mainPlayer.setDirection(5);
                //System.out.println("h");
                 //   System.out.println("mappartgetX: " +(mapPart.getX()+mapPart.getWidth()));
                  //  System.out.println("playergetx: " +mainPlayer.getX());
               // else if(mainPlayer.getySpeed()>0)
                return;
            }

        }
    }*/

        //endrer visningfeltet
    public void view() {
        if (mainPlayer.getPosX() > 300 && mainPlayer.getPosX() < gamePane.getWidth() - 505) {
            gamePane.setLayoutX(-mainPlayer.getPosX() + 300);
        } else if (mainPlayer.getPosX() < 300) {
            gamePane.setLayoutX(0);
        }
    }

}
