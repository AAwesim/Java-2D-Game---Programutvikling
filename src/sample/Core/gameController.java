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
    private mapCreator mc = new mapCreator();
    private AnimationTimer timer;

    private int scalar = 35;
    public  int levelWidth;
    public ArrayList<Rectangle> map=new ArrayList<>();

    BackgroundImage BI= new BackgroundImage(new Image("file:ressurser\\\\Hills.png",805,525,false,true),BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keyHandlerInit(gamePane);
        mainPlayer.init(gamePane);
        initMap(gamePane);

        gamePane.setBackground(new Background(BI));

        System.out.println("stage: " + gpWrap.getWidth());
        System.out.println("scene: " + gamePane.getWidth());

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if(mainPlayer.getPosX()>300 && mainPlayer.getPosX()<gamePane.getWidth()-505) {
                    gamePane.setLayoutX(-mainPlayer.getPosX()+300);
                } else if (mainPlayer.getPosX()<300) {
                    gamePane.setLayoutX(0);
                }

               // System.out.println(mainPlayer.getPosX());
                if(playerMapCollisionChecker(mainPlayer)){
                    mainPlayer.gravity();
                }
                System.out.println(playerMapCollisionChecker(mainPlayer));
                mainPlayer.updatePlayerState();
                mainPlayer.renderPlayer();
                playerMapCollisionChecker(mainPlayer);
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
            mainPlayer.setPosY(-20);
        }

        else if(keyEvent.getCode() == KeyCode.F1){
            mainPlayer.setPosX(320-mainPlayer.getPosX());
            mainPlayer.setPosY(240-mainPlayer.getPosY());
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

    public boolean playerMapCollisionChecker(Player p){
        for(Rectangle mapPart:map){
            if(p.intersects(mapPart.getBoundsInLocal())){
                p.setySpeed(0);
                p.setxSpeed(0);
                p.setDirection(5);
                System.out.println("h");
                return false;
            }
        }

        return true;
    }
}
