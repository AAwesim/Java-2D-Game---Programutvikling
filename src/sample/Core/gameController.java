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

    private PlayerCreator pc = new PlayerCreator();
    protected Player mainPlayer = (Player) pc.getEntity("PLAYER");

    private AnimationTimer timer;
    private Collision collision;
    protected mapCreator mc;
    protected Bullet bully;

    private static boolean setNull = false;

    public int i = 0;

    private static boolean running = true;
    public boolean intervalShooting=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = new mapCreator();
        collision = new Collision();
        running = true;
        setNull = false;
        init(gamePane);
        bully=new Bullet(gamePane);

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
                    if (!collision.gravityCheck(mainPlayer, mc)) {
                        mainPlayer.gravity();
                    }

                    if (mainPlayer.KeyA) {
                        collision.PlayerCollisionX(4, mainPlayer, mc);
                        mainPlayer.setFill(ResourceManager.playerSprites.get(5));
                    } else if (mainPlayer.KeyD) {
                        collision.PlayerCollisionX(4, mainPlayer, mc);
                        mainPlayer.setFill(ResourceManager.playerSprites.get(4));
                    } else {
                        mainPlayer.setFill(ResourceManager.playerSprites.get(0));
                    }

                    PitCheck(mainPlayer,gamePane);
                    updateBullet();

                    for (int i=0; i<mc.getEntityMap().size();i++) {
                        mc.getEntityMap().get(i).RenderEntity();
                    }

                    mainPlayer.renderPlayer();
                    PlayerEnemyColl(mainPlayer);

                    mainPlayer.updatePlayerState();

                    view(mainPlayer,gamePane);
                    collision.playerCollisionY(mainPlayer, mc);

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

    public void keyHandlerInit(Pane p) {
        p.setFocusTraversable(true);
        p.requestFocus();
        p.setOnKeyPressed(this);
        p.setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                mainPlayer.KeyA = false;
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                mainPlayer.KeyD = false;
            }
            if (e.getCode()==KeyCode.C){
                intervalShooting=true;
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
                mainPlayer.KeyD = false ;
                mainPlayer.KeyA = true;
            case LEFT:
                mainPlayer.KeyD = false ;
                mainPlayer.KeyA = true;
                break;
            case D:
                mainPlayer.KeyA = false;
                mainPlayer.KeyD = true;

            case RIGHT:
                mainPlayer.KeyA = false;
                mainPlayer.KeyD = true;
                break;
            case W:
                if (collision.gravityCheck(mainPlayer, mc)) {
                    mainPlayer.setySpeed(-7.5);
                }
                break;
            case C:

                if(intervalShooting) {
                    intervalShooting=false;
                    bully.initBullet(mainPlayer.getPosX() + 10, mainPlayer.getPosY());
                }
                break;

            case UP:
                if (collision.gravityCheck(mainPlayer, mc)) {
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
        for (EnemyRect enemyRect : mapCreator.getERMap()) {
            if (p.intersects(enemyRect.getBoundsInParent())) {
                p.setPosX(110);
                p.setPosY(300);
            }
        }
        for (EnemyCircle enemyCircle : mapCreator.getECMap()) {
            if (p.intersects(enemyCircle.getBoundsInParent())) {
                p.setPosX(110);
                p.setPosY(300);
            }
        }
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
        mc.getEntityMap().clear();
        mapCreator.getERMap().clear();
        mapCreator.getECMap().clear();
        bully.bullets.clear();

        System.out.println("EMAP a"+mc.getEntityMap());
        System.out.println("EMAP b"+mapCreator.getERMap());

        mc.setEntityMap(null);
        mc.setMap(null);
        mc.setTextures(null);

        gamePane.removeEventHandler(KeyEvent.ANY, this);
        gamePane.setOnKeyPressed(null);
        gamePane.setOnKeyReleased(null);
       // EH = null;
        timer = null;
        gpWrap = null;
        gamePane = null;
        mc = null;
        mainPlayer = null;
        pc = null;
    }

    public static void setSetNull(boolean setNull) {
        gameController.setNull = setNull;
    }

    public void runtime(){
        i++;
        if (i%60==0){
            System.out.println("runtime:"+ i/60);
            System.out.println("ERMRMAP"+mapCreator.getERMap().size());

      /* System.out.println("ArraybulletsSize: "bully.bullets.size());
      System.out.println("Entities: "+mc.getEntityMap().size());
        System.out.println("EnemiesR: "+mapCreator.getERMap().size());
        System.out.println("EnemiesC: "+mapCreator.getECMap().size());*/
        }
    }
    public void updateBullet() {
        for (Rectangle bulsy : bully.bullets) {
            double rectX = bulsy.getX();
            bulsy.setX(rectX + bully.getBulletSpeed());
            for(Rectangle mapsy:mc.getMap()) {
                if (bulsy.getBoundsInParent().intersects(mapsy.getBoundsInParent())){
                    bully.collisionRemoveFirst(bulsy, mapsy);
                }

            }
        }
    }
}