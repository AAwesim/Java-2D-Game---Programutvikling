package sample.Core;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import sample.Entity.*;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;
import sample.Tools.StateManager;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable, Serializable, EventHandler<KeyEvent> {

    @FXML
    Pane gamePane;
    @FXML
    Pane gpWrap;

    private EntityCreator ec = new EntityCreator();
    private Player mainPlayer = (Player) ec.getEntity("PLAYER");

    private AnimationTimer timer;
    private mapCreator mc;

    private boolean KeyA = false;
    private boolean KeyD = false;
    private static boolean setNull = false;

    public int i = 0;
    public int d = 0;

    private static boolean running = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = new mapCreator();
        running = true;
        setNull = false;
        init(gamePane);

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if(!running){
                    if(setNull){
                        Terminate();
                    }
                }

                if (running) {
                    runtime();
                    EnemyHandler.getEnemyHandler().renderEnemies();

                    if (!gravitycheck(mainPlayer)) {
                        mainPlayer.gravity();
                    }

                    if (KeyA) {
                        PlayerCollisionX(4, mainPlayer);
                        mainPlayer.setFill(ResourceManager.playerSprites.get(5));
                    } else if (KeyD) {
                        PlayerCollisionX(4, mainPlayer);
                        mainPlayer.setFill(ResourceManager.playerSprites.get(4));
                    } else if(!KeyA && !KeyD) {
                        mainPlayer.setFill(ResourceManager.playerSprites.get(0));
                    }

                    PitCheck(mainPlayer,gamePane);

                    PlayerEnemyColl(mainPlayer);

                    mainPlayer.updatePlayerState();
                    mainPlayer.renderPlayer();

                    view(mainPlayer,gamePane);
                    playerMapCollisionChecker2(mainPlayer);

                } else return;


            }
        };

        timer.start();
    }

    public void init(Pane p) {
        BackgroundImage BI = new BackgroundImage((ResourceManager.background), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        keyHandlerInit(p);
        mc.initMap(p);
        p.setBackground(new Background(BI));
        mainPlayer.initPlayer(p);
    }


    /*private int KeyA = 0;
    private int KeyD = 1;*/

    public void keyHandlerInit(Pane p) {
        p.setFocusTraversable(true);
        p.requestFocus();
        p.setOnKeyPressed(this);
        p.setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                this.KeyA = false;
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                this.KeyD = false;
            }
        });
    }

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case SPACE:
                System.out.println(e.toString());
                break;
            case A:
                this.KeyD = false ;
                this.KeyA = true;
            case LEFT:
                this.KeyD = false ;
                this.KeyA = true;
                break;
            case D:
                this.KeyA = false;
                this.KeyD = true;

            case RIGHT:
                this.KeyA = false;
                this.KeyD = true;
                break;
            case W:
                if (gravitycheck(mainPlayer)) {
                    mainPlayer.setySpeed(-7.5);
                }

            case UP:
                if (gravitycheck(mainPlayer)) {
                    mainPlayer.setySpeed(-7.5);
                }
                break;
            case F1:
                mainPlayer.setPosX(150);
                mainPlayer.setPosY(300);
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
                System.out.println(StateManager.State);
                running = false;
                StateManager.changeScene(e, StateManager.GameState.PAUSE);
                break;
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
                if ((p.getPosY() + p.getHeight()) < (mapPart.getY() + p.getMaxySpeed()) && p.getySpeed() > 0) {
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
                if (mapPart.intersects(p.getPosX() + speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning høyre
                    if (KeyD) {
                        speed--;
                        p.setPosX(mapPart.getX() - p.getWidth() - 1);
                    }
                }

                if (mapPart.intersects(p.getPosX() - speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning venstre
                    if (KeyA) {
                        speed--;
                        p.setPosX(mapPart.getX() + mapPart.getWidth() + 1);
                    }
                }
            }
        }
        System.out.println(p.getPosX());
        System.out.println(speed);
        if (KeyD) {
            p.MoveRight(speed);
        } else if (KeyA) {
            p.MoveLeft(speed);
        }
    }


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
        mainPlayer.initPlayer(gamePane);
        System.out.println("Load Complete");
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

    public void PlayerEnemyColl(Player p) {
        for (Enemy enemy : mc.getEMap()) {
            if (p.intersects(enemy.getBoundsInLocal())) {
                p.setPosX(110);
                p.setPosY(300);
            }
        }
    }

    /*//må kalles hver gang vi endrer map, dersom map størrelsene skal være forskjellige.
    //Setter gamePane witdh lik maplengden
    public void setGamePaneWidth() {
           gamePane.setPrefWidth(mc.getmapLength(1));
           System.out.println(mc.getmapLength(1));
           System.out.println(gamePane.getWidth());
    }*/

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
            p.setPosX(110);
            p.setPosY(300);
        }
    }



    public void Terminate() {
        System.out.println("TERMINATED");
        timer.stop();
        running = false;

        gamePane.getChildren().clear();
        gpWrap.getChildren().clear();
        mc.getMap().clear();
        mc.getEMap().clear();

        EnemyHandler.getEnemyHandler().getEnemyXList().clear();
        EnemyHandler.getEnemyHandler().getEnemyYList().clear();

        mc.setEmap(null);
        mc.setMap(null);
        mc.setTextures(null);

        gamePane.removeEventHandler(KeyEvent.ANY, this);
        gamePane.setOnKeyPressed(null);
        gamePane.setOnKeyReleased(null);

        timer = null;
        gpWrap = null;
        gamePane = null;
        mc = null;
        mainPlayer = null;
        ec = null;
    }

    public static void setSetNull(boolean setNull) {
        gameController.setNull = setNull;
    }

    public void runtime(){
        i++;
        if (i%60==0)
            System.out.println("runtime: "+ i/60);
    }
}