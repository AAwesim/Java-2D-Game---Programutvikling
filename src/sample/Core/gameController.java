package sample.Core;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
<<<<<<< HEAD
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
=======
>>>>>>> Asim
import sample.Entity.*;
import sample.Map.Map;
import sample.Map.mapCreator;
import sample.Tools.StateManager;
import java.io.*;
import java.net.URL;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.MAGENTA;
import static javafx.scene.paint.Color.color;

public class gameController implements Initializable, EventHandler<KeyEvent> {
=======
import java.util.Arrays;
import java.util.ResourceBundle;

public class gameController implements Initializable, Serializable, EventHandler<KeyEvent> {
>>>>>>> Asim

    @FXML
    Pane gamePane;
    @FXML
    Pane gpWrap;

    private EntityCreator ec = new EntityCreator();
    private Player mainPlayer = (Player) ec.getEntity("PLAYER");
   // private Enemy enemy = (Enemy) ec.getEntity("ENEMY");
    private AnimationTimer timer;
<<<<<<< HEAD
    private mapCreator mc = new mapCreator();

    private boolean left = false;
    private boolean right = false;

    public int i = 0;
    public int d = 0;

    BackgroundImage BI = new BackgroundImage(new Image("file:ressurser\\\\Hills.png", 805, 525, false, true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keyHandlerInit(gamePane);
        mainPlayer.initPlayer(gamePane);
        //mc.enemy1(gamePane);
       // enemy.initEnemy(gamePane);

        mc.initMap(gamePane);
        setGamePaneWidth();
        gamePane.setBackground(new Background(BI));
=======
    private static boolean running = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        running = true;
        init(gamePane);
        /*setGamePaneWidth();*/
        System.out.println(Arrays.toString(Map.getMapArray()));
>>>>>>> Asim

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

<<<<<<< HEAD
                if (!gravitycheck(mainPlayer)) {mainPlayer.gravity();}
                if (left) {PlayerCollisionX(4, mainPlayer);}
                if (right) {PlayerCollisionX(4, mainPlayer);}



                PitCheck(mainPlayer,gamePane);

                PlayerEnemyColl(mainPlayer);

                mainPlayer.updatePlayerState();
                mainPlayer.renderPlayer();
                view(mainPlayer,gamePane);

<<<<<<< HEAD
=======

                view(mainPlayer, gamePane);
>>>>>>> JakobMain
                playerMapCollisionChecker2(mainPlayer);



=======
                if (running) {
                    camera(mainPlayer, gamePane);
                    mainPlayer.updatePlayerState();
                    mainPlayer.renderPlayer();
                    mc.playerMapCollisionChecker(mainPlayer);
                } else return;

>>>>>>> Asim
            }
        };

        timer.start();
    }

    public void init(Pane p) {
        BackgroundImage BI = new BackgroundImage(new Image("file:ressurser\\\\Hills.png", 805, 525, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        keyHandlerInit(p);
        mainPlayer.init(p);
        mc.initMap(p);
        p.setBackground(new Background(BI));

      //  System.out.println("stage: " + gpWrap.getWidth());
        System.out.println("scene: " + p.getWidth());
    }
<<<<<<< HEAD
    
=======

<<<<<<< HEAD
    /*private int left = 0;
    private int right = 1;*/
>>>>>>> JakobMain
=======
>>>>>>> Asim
    public void keyHandlerInit(Pane p) {
        p.setFocusTraversable(true);
        p.requestFocus();

        p.setOnKeyPressed(this);

        p.setOnKeyReleased(e -> {
<<<<<<< HEAD
            if (e.getCode() == KeyCode.A) {
                //   mainPlayer.setDirection(5);
                this.left = false;
            } else if (e.getCode() == KeyCode.D) {
                //  mainPlayer.setDirection(5);
                this.right = false;
                System.out.println("BAAAAAAAAAAls");
=======
            switch (e.getCode()) {
                case A:
                    mainPlayer.setDirection(5);
                    break;
                case D:
                    mainPlayer.setDirection(5);
                    break;
>>>>>>> Asim
            }
        });
    }

<<<<<<< HEAD
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.SPACE) {
            System.out.println(keyEvent.toString());
        } else if (keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT) {
            this.right = false ;
            this.left = true;

        } else if (keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT) {
             this.left = false;
             this.right = true;


        } else if (keyEvent.getCode() == KeyCode.S || keyEvent.getCode() == KeyCode.DOWN) {
            mainPlayer.setySpeed(2);

        } else if (keyEvent.getCode() == KeyCode.W || keyEvent.getCode() == KeyCode.UP) {
            if (gravitycheck(mainPlayer)) {
                // mainPlayer.setPosY(mainPlayer.getPosY()-4);
                mainPlayer.setySpeed(-7.5);
            }
        } else if (keyEvent.getCode() == KeyCode.F1) {
            mainPlayer.setPosX(150);
            mainPlayer.setPosY(300);
            mainPlayer.setySpeed(0);
        } else if (keyEvent.getCode() == KeyCode.ESCAPE) {
            Stage stage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();

            StateManager.setState(StateManager.GameState.MAINMENU);
            stage.setScene(StateManager.update());

            stage.setResizable(false);
            stage.show();
        }
    }

    //Vet ikke lenger, men tror det eneste formålet til metoden er for å sjekke om gravity()
    //skal kjøres, derfor er Width og Height en pixel større enn metoden under.
    public boolean gravitycheck(Player p) {
        for (Rectangle mapPart : mc.getMap()) {
            if (mapPart.intersects(p.getX(), p.getY(), p.getWidth() + 0.5, p.getHeight() + 1)) {
                return true;
            }
        }
        return false;
    }

    //kan forbedres ved å adde en for loop her, metoden må da ta inn en parameter som tilsvarer
    //xspeed. Antall iterasjoner i for løkken avhenger av denne parameteren med mer
    //dette kan gjøre at vi kan skjekke collision for hver piksel
    //TODO
    public void playerMapCollisionChecker2(Player p) {
        for (Rectangle mapPart : mc.getMap()) {
            if (mapPart.intersects(p.getPosX(), p.getPosY(), p.getWidth(), p.getHeight())) {
                // Collision Ovenifra
                if ((p.getPosY() + p.getHeight()) < (mapPart.getY() + 7.1) && p.getySpeed() > 0) {
                    p.setySpeed(0);
                    p.setPosY(mapPart.getY() - p.getHeight() - 1);
                    return;
                }
                // Collision Nedenifra
                if ((p.getPosY()) > (mapPart.getY() + mapPart.getHeight() / 2) && p.getySpeed() < 0) {
                    p.setySpeed(0);
                    p.setPosY(mapPart.getY() + mapPart.getHeight() + 1);
                    return;
                }
            }
        }
    }

    public void PlayerCollisionX(int x, Player p) {
        int speed = 4;
        for (int i = 1; i <= x; i++) {
            for (Rectangle mapPart : mc.getMap()) {
                if (mapPart.intersects(p.getPosX()+speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning høyre
                    if (right) {
                        speed--;
                        //p.setxSpeed(0);
                        //this.right = false;
                        System.out.println("høyre movement løkke");
                        p.setPosX(mapPart.getX() - p.getWidth()-1);
                        System.out.println("sjekk");
                    }
                }
                if (mapPart.intersects(p.getPosX()-speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning venstre
                    if (left) {
                        speed--;
                        //p.setxSpeed(0);
                        //this.left = false;
                        p.setPosX(mapPart.getX() + mapPart.getWidth()+1);
                    }
                }
            }

        } System.out.println(p.getPosX());

        System.out.println(speed);
        if (right) {
            p.MoveRight(speed);
        } else if (left) {
            p.MoveLeft(speed);
=======
    public void playerSave(Player p) throws IOException {
        FileOutputStream fo = new FileOutputStream("playersave.ser");
        ObjectOutputStream out = new ObjectOutputStream(fo);
        out.writeObject(p);
        out.close();
        fo.close();
        System.out.println("Save Complete");
    }

    public void loadSave() throws Exception {
        gamePane.getChildren().remove(mainPlayer);
        FileInputStream fi = new FileInputStream("playersave.ser");
        ObjectInputStream in = new ObjectInputStream(fi);
        mainPlayer = (Player) in.readObject();
        in.close();
        fi.close();
        mainPlayer.init(gamePane);
        System.out.println("Load Complete");
    }

    public void camera(Player p, Pane pane) {
        if (p.getPosX() > 300 && p.getPosX() < pane.getWidth() - 505) {
            pane.setLayoutX(-p.getPosX() + 300);
        } else if (p.getPosX() < 300) {
            pane.setLayoutX(0);
        }
    }

    //må kalles hver gang vi endrer map, dersom map størrelsene skal være forskjellige.
    //Setter gamePane witdh lik maplengden
    public void setGamePaneWidth() {
        gamePane.setPrefWidth(mc.getmapLength());
        /*System.out.println(mc.getmapLength());*/
        System.out.println(gamePane.getWidth());
    }

    public static void setRunning(boolean running) {
        gameController.running = running;
    }

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case SPACE:
                System.out.println(e.toString());
                break;
            case A:
            case LEFT:
                mainPlayer.setDirection(0);
                break;
            case D:
            case RIGHT:
                mainPlayer.setDirection(1);
                break;
            case S:
            case DOWN:
                mainPlayer.setPosY(5);
                break;
            case W:
            case UP:
                mainPlayer.setPosY(-20);
                break;
            case F1:
                mainPlayer.setPosX(320 - mainPlayer.getPosX());
                mainPlayer.setPosY(240 - mainPlayer.getPosY());
                mainPlayer.setySpeed(0);
                break;
            case F2:
                try {
                    playerSave(mainPlayer);
                    System.out.println(mainPlayer.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;

            case F3:
                try {
                    loadSave();
                    mainPlayer.renderPlayer();
                    System.out.println(mainPlayer.toString());
                } catch (Exception e2) {
                    System.out.println(e);
                }
                break;

            case F5:
                    Terminate();
                break;

            case ESCAPE:
                running = false;
                StateManager.changeScene(e, StateManager.GameState.PAUSE);
                break;
>>>>>>> Asim
        }
    }

<<<<<<< HEAD
    }

    //må kalles hver gang vi endrer map, dersom map størrelsene skal være forskjellige.
    //Setter gamePane witdh lik maplengden
    public void setGamePaneWidth() {
           gamePane.setPrefWidth(mc.getmapLength(1));
           System.out.println(mc.getmapLength(1));
           System.out.println(gamePane.getWidth());
    }


    //endrer visningfeltet
    public void view(Player p, Pane pa) {
        if (p.getPosX() > 300 && p.getPosX() < pa.getWidth() - 505) {
            pa.setLayoutX(-p.getPosX() + 300);
        } else if (p.getPosX() < 300) {
            pa.setLayoutX(0);
        }
    }

    //checker om mainplayer har falt ned i høøøøl
    public void PitCheck(Player p, Pane pa) {
        if (p.getPosY() > pa.getHeight() - 65) {
            p.setPosX(300);
            p.setPosY(300);
        }
    }

    public void PlayerEnemyColl(Player p) {
        for (Enemy enemy : mc.getEMap()) {
        if (p.intersects(enemy.getBoundsInLocal())) {
            p.setPosX(110);
            p.setPosY(300);
            }
        }
    }
}
=======
    public void Terminate(){
        if(gamePane != null && mainPlayer != null && timer != null){
            gamePane.getChildren().clear();
            gpWrap.getChildren().clear();
            mc.getMap().clear();

            timer.stop();

            gamePane.removeEventHandler(KeyEvent.ANY,this);
            gamePane.setOnKeyPressed(null);
            gamePane.setOnKeyReleased(null);

            gpWrap = null;
            gamePane = null;
            mc = null;
            mainPlayer = null;
            ec = null;

        } else System.exit(2);
    }

}
>>>>>>> Asim
