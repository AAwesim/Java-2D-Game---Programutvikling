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
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.color;

public class gameController implements Initializable, EventHandler<KeyEvent> {

    @FXML Pane gamePane;
    @FXML Pane gpWrap;

    private EntityCreator ec = new EntityCreator();
    private Player mainPlayer = (Player) ec.getEntity("PLAYER");
    private AnimationTimer timer;

    private int scalar = 35;
    private int levelWidth;
    private ArrayList<Rectangle> map=new ArrayList<>();

    BackgroundImage BI= new BackgroundImage(new Image("file:ressurser\\\\Hills.png",805,525,false,true),BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keyHandlerInit(gamePane);
        mainPlayer.init(gamePane);
        initMap(gamePane);

        gamePane.setBackground(new Background(BI));

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {


                //System.out.println(mainPlayer.getPosX());
                if(playerMapCollisionChecker(mainPlayer)) {
                    mainPlayer.gravity();
                }
                //mainPlayer.gravity();
               // System.out.println(playerMapCollisionChecker(mainPlayer));
                mainPlayer.updatePlayerState();
                mainPlayer.renderPlayer();
                playerMapCollisionChecker(mainPlayer);
                view();
                playerMapCollisionChecker2(mainPlayer);
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
            mainPlayer.setPosY(mainPlayer.getPosY()-4);
            mainPlayer.setySpeed(-7);
        }

        else if(keyEvent.getCode() == KeyCode.F1){
            mainPlayer.setPosX(320.0);
            mainPlayer.setPosY(100.0);
            mainPlayer.setySpeed(0);
        }

        else if(keyEvent.getCode() == KeyCode.ESCAPE){
            Stage stage = (Stage) ((Node)keyEvent.getSource()).getScene().getWindow();

            StateManager.setState(StateManager.GameState.MAINMENU);
            stage.setScene(StateManager.update());

            stage.setResizable(false);
            stage.show();
        }
    }


    public void initMap(Pane pe){
        levelWidth = mapCreator.LEVEL1MAP[0].length() * scalar;
        for (int i = 0; i < mapCreator.LEVEL1MAP.length; i++) {
            String line = mapCreator.LEVEL1MAP[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(Color.rgb(44,190,49));
                        map.add(mapPart1);
                        break;
                    case '2':
                        mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(color(0.0,0.20,0.50));
                        map.add(mapPart1);
                        break;

                }
            }
        }

    }

    public Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x,y,w,h);
        pe.getChildren().add(rect);
        return rect;
    }

    //Vet ikke lenger, men tror det eneste formålet til metoden er for å sjekke om gravity()
    //skal kjøres, derfor er Width og Height en pixel større enn metoden under.
    public boolean playerMapCollisionChecker(Player p){
        for(Rectangle mapPart:map){
            if(mapPart.intersects(p.getX(),mainPlayer.getY(),mainPlayer.getWidth()+1,mainPlayer.getHeight()+1)){
                //mainPlayer.setySpeed(0);
                //p.setxSpeed(0);

                //p.setDirection(5);
                //System.out.println("h");
                return false;
            } //else { mainPlayer.gravity();
            //}
        }
        return true;
    }

    public void playerMapCollisionChecker2(Player p){
        for(Rectangle mapPart:map){
            if(mapPart.intersects(p.getX(),p.getY(),p.getWidth(),p.getHeight())){
               /* if (mainPlayer.getySpeed()>0){ mainPlayer.setPosY(p.getPosY()-1);}
                if (mainPlayer.getySpeed()>0) { mainPlayer.setySpeed(-1);}
                if ()*/

               /* if (p.getySpeed()<0.5){mainPlayer.setySpeed(0);}
                else {mainPlayer.setySpeed(mainPlayer.getySpeed()/4);}*/
                p.setPosY(mainPlayer.getPosY()-1);
                p.setySpeed(0);
                p.setxSpeed(0);
                p.setDirection(5);
                //System.out.println("h");


               // else if(mainPlayer.getySpeed()>0)

                return;
            } //else { mainPlayer.gravity();
            //}
        }

    }

        //endrer visningfeltet
    public void view() {
        if (mainPlayer.getPosX() > 300 && mainPlayer.getPosX() < gamePane.getWidth() - 505) {
            gamePane.setLayoutX(-mainPlayer.getPosX() + 300);
        } else if (mainPlayer.getPosX() < 300) {
            gamePane.setLayoutX(0);
        }
    }



}
