package sample.Core;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.Entity.*;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;
import sample.Tools.StateManager;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class gameController implements Initializable, Serializable, EventHandler<KeyEvent> {

    @FXML
    Pane gamePane;
    @FXML
    Pane gpWrap;
    @FXML
    Label LivesCounter;

    private PlayerCreator pc = new PlayerCreator();
    protected Player mainPlayer = (Player) pc.getEntity("PLAYER");

    private AnimationTimer timer;
    private Collision collision;
    protected mapCreator mc;
    protected Bullet bullet;

    private int Runtime = 0;

    private static boolean setNull = false;
    private static boolean running = true;
    private boolean intervalShooting = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collision = new Collision();
        mc = new mapCreator(StateManager.LEVEL);
        running = true;
        setNull = false;
        init(gamePane);
        setGamePaneWidth();
        bullet = new Bullet(gamePane);
        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (!running) {
                    if (setNull) {
                        Terminate();
                    }
                }

                if (running) {
                    runtime();

                    if (!collision.gravityCheck(mainPlayer, mc)) {
                        mainPlayer.gravity();
                    }
                    updateHealth(mainPlayer);
                    //collision()

                    PlayerMoveXColl();

                    PitCheck(mainPlayer, gamePane);

                    updateBullet();

                    Render();

                    //System.out.println(mainPlayer.getxSpeed());


                    mainPlayer.updatePlayerState();

                    view(mainPlayer, gamePane);
                    collision.playerCollisionY(mainPlayer, mc);
                    collision.PlayerEnemyColl(mainPlayer);


                } else return;
            }
        };

        timer.start();

    }


    public void init(Pane p) {
        p.setBackground(new Background(new BackgroundImage((ResourceManager.background), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        keyHandlerInit(p);

        if (mc == null)
            System.out.println("MC NULL");

        if (mc.getLEVELARRAY() == null) {
            System.out.println("LEVELARRAY NULL");
        } else System.out.println("not null");
        mc.initMap(p);

        mainPlayer.initPlayer(p);
    }

    public void keyHandlerInit(Pane p) {
        p.setFocusTraversable(true);
        p.requestFocus();
        p.setOnKeyPressed(this);
        p.setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                mainPlayer.KeyA = false;
                mainPlayer.setFill(ResourceManager.playerSprites.get(1));
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                mainPlayer.KeyD = false;
                mainPlayer.setFill(ResourceManager.playerSprites.get(0));
            }
            if (e.getCode() == KeyCode.F) {
                intervalShooting = true;
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
            case LEFT:
                if(mainPlayer.getxSpeed()==0){mainPlayer.setxSpeed(4);}
                mainPlayer.KeyD = false;
                mainPlayer.KeyA = true;
                break;
            case D:
            case RIGHT:
                if(mainPlayer.getxSpeed()==0){mainPlayer.setxSpeed(4);}
                mainPlayer.KeyA = false;
                mainPlayer.KeyD = true;
                break;
            case W:
                if (collision.gravityCheck(mainPlayer, mc)) {
                    mainPlayer.setySpeed(-7.5);
                }
                break;
            case I:
                mainPlayer.setxSpeed(16);
                break;
            case U:
                mainPlayer.setxSpeed(8);
                break;
            case Y:
                mainPlayer.setxSpeed(4);
                break;
            case F:
                if (intervalShooting) {
                    intervalShooting = false;
                    bullet.initBullet(mainPlayer.getPosX() + mainPlayer.getWidth(), mainPlayer.getPosY() + mainPlayer.getHeight() / 2);
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
                playerSave();
                break;

            case F3:
                loadSave();
                break;

            case ESCAPE:
                gameController.running = false;
                StateManager.changeScene(e, StateManager.GameState.PAUSE);
                break;
        }
    }

    public void playerSave() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("player.sav"))) {
            out.writeObject(mainPlayer);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save Complete");
    }

    public void loadSave() {
        Player backupPlayer = mainPlayer;
        gamePane.getChildren().remove(mainPlayer);
        try (FileInputStream fi = new FileInputStream("player.sav")) {
            ObjectInputStream in = new ObjectInputStream(fi);
            Player tempPlayer = (Player) in.readObject();
            if (tempPlayer.getChecksum() % 9 == 0) {
                mainPlayer = tempPlayer;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("KORRUPT");
                alert.setHeaderText("FILEN ER KORRUPT OG DERMED ER DET IKKE MULIG Å LOADE SAVEN.");
                alert.setContentText("PLAYERDATA ER KORRUPT OG UMULIG Å HENTE");
                backupPlayer.initPlayer(gamePane);
                alert.showAndWait();
            }
        } catch (FileNotFoundException fnfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("LOAD SAVE ERROR");
            alert.setHeaderText("FINNER IKKE PLAYER SAVE.");
            alert.setContentText("Filen for player sine tilstander finnes ikke eller eksisterer ikke. Det kan hende " +
                    "at filen er slettet.");
            backupPlayer.initPlayer(gamePane);
            backupPlayer.KeyA = false;
            backupPlayer.KeyD = false;
            alert.showAndWait();
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("IO Funker ikke");
            alert.setHeaderText("FINNER IKKE PLAYER SAVE.");
            alert.setContentText("Filen for player sine tilstander finnes ikke eller eksisterer ikke. Det kan hende " +
                    "at filen er slettet.");
            backupPlayer.initPlayer(gamePane);
            backupPlayer.KeyA = false;
            backupPlayer.KeyD = false;
            alert.showAndWait();
            ioe.printStackTrace();
            return;

        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("JARFILE CORRUPT ERROR");
            alert.setHeaderText("KAN IKKE DESERIALIZE SAVE FIL.");
            alert.setContentText("LAST NED .JAR FILEN PÅ NYTT");
            alert.showAndWait();
            System.exit(5);
            e.printStackTrace();
        }
        mainPlayer.initPlayer(gamePane);
        System.out.println("Load Complete");
    }

    //må kalles hver gang vi endrer map, dersom map størrelsene skal være forskjellige.
    //Setter gamePane witdh lik maplengden
    public void setGamePaneWidth() {
        gamePane.setMaxWidth((mc.getmapLength()));
        /*System.out.println(mc.getmapLength());*/
        System.out.println(gamePane.getWidth());
    }

    public static void setRunning(boolean running) {
        gameController.running = running;
    }

    //endrer visningfeltet
    public void view(Player p, Pane pa) {
        int OffSetLeft = 300;
        int OffSetRight = 505;
        if (p.getPosX() > OffSetLeft && p.getPosX() < pa.getWidth() - OffSetRight) {
            pa.setLayoutX(-p.getPosX() + OffSetLeft);
        } else if (p.getPosX() < OffSetLeft) {
            pa.setLayoutX(0);
        }
    }

    //checker om mainplayer har falt ned Runtime høøøøl
    private void PitCheck(Player p, Pane pa) {
        if (p.getPosY() > pa.getHeight()) {
            p.setHealthAmount(p.getHealthAmount() - 1);
            updateHealth(p);
            p.setPlayerPositionStart();
            if (p.getHealthAmount() == 0)
                changeScene(StateManager.GameState.GAMEOVER);
        }
    }

    void updateHealth(Player p) {
        LivesCounter.setText(Integer.toString(p.getHealthAmount()));
    }

    public void Terminate() {
        System.out.println("TERMINATED");
        timer.stop();
        running = false;

        gamePane.getChildren().clear();
        gpWrap.getChildren().clear();
        mc.getMap().clear();
        mc.getEnemyMap().clear();
        mapCreator.getERMap().clear();
        mapCreator.getECMap().clear();
        bullet.bullets.clear();

        mc.setEnemyMap(null);
        mc.setMap(null);
        gamePane.removeEventHandler(KeyEvent.ANY, this);
        gamePane.setOnKeyPressed(null);
        gamePane.setOnKeyReleased(null);

        bullet = null;
        timer = null;
        gpWrap = null;
        gamePane = null;
        mc = null;
        mainPlayer = null;
        pc = null;
        collision = null;

        StateManager.removeGameRoot();
    }

    public void changeScene(StateManager.GameState gameState) {
        StateManager.changeScene(gameState);
        gameController.setSetNull(true);
        running = false;
    }

    public static void setSetNull(boolean setNull) {
        gameController.setNull = setNull;
    }

    public void runtime() {
        Runtime++;
        if (Runtime % 60 == 0) {
            System.out.println("runtime:" + Runtime / 60);
            System.out.println("ERMAP" + mapCreator.getERMap().size());
            System.out.println("EnemyMAP" + mc.getEnemyMap().size());


      /* System.out.println("ArraybulletsSize: "bully.bullets.size());
      System.out.println("Entities: "+mc.getEnemyMap().size());
        System.out.println("EnemiesR: "+mapCreator.getERMap().size());
        System.out.println("EnemiesC: "+mapCreator.getECMap().size());*/
        }
    }

    public void updateBullet() {
        ArrayList<Circle> bulletsToRemove = new ArrayList<>();
        for (ListIterator<Circle> itBT = bullet.bullets.listIterator(); itBT.hasNext(); ) {
            Circle BT = itBT.next();
            double CircleX = BT.getCenterX();
            //Removes bullet if distance to player is greater than 200
            if((CircleX-mainPlayer.getPosX())>200){
                itBT.remove();
                gamePane.getChildren().remove(BT);
            }
            BT.setCenterX(CircleX + bullet.getBulletSpeed());
            for (ListIterator<Rectangle> itMP = mc.getMap().listIterator(); itMP.hasNext(); ) {
                Rectangle MP = itMP.next();
                if (BT.getBoundsInParent().intersects(MP.getBoundsInParent())) {
                    bulletsToRemove.add(BT);
                    gamePane.getChildren().remove(BT);
                }
            }
            for (ListIterator<EnemyRect> itER = mapCreator.getERMap().listIterator(); itER.hasNext(); ) {
                EnemyRect ER = itER.next();
                if (BT.intersects(ER.getBoundsInParent())) {
                    bulletsToRemove.add(BT);
                    itER.remove();
                    mc.getEnemyMap().remove(ER);
                    gamePane.getChildren().remove(ER);
                    gamePane.getChildren().remove(BT);
                }
            }
        }
        bullet.bullets.removeAll(bulletsToRemove);
    }


    /**
     * Kaller på RenderEntity metoden for hver entitet
     * Kaller på Player sin renderPlayer metode
     */
    private void Render() {
        for (int i = 0; i < mc.getEnemyMap().size(); i++) {
            mc.getEnemyMap().get(i).RenderEntity();
        }
        mainPlayer.renderPlayer();
    }

    /**
     * Kaller på metoden PlayerCollisionX dersom en av mainPlayer sin instanse variabeler
     * KeyA eller KeyD er sann
     */
    private void PlayerMoveXColl() {
        if (mainPlayer.KeyA) {
            collision.PlayerCollisionX(mainPlayer.getxSpeed(), mainPlayer, mc);
        } else if (mainPlayer.KeyD) {
            collision.PlayerCollisionX(mainPlayer.getxSpeed(), mainPlayer, mc);
        }
    }
}