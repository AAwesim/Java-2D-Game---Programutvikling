package sample.Core;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    @FXML Pane gamePane;
    @FXML Pane gpWrap;
    @FXML Label healthLabel;

    private PlayerCreator pc = new PlayerCreator();
    private Player mainPlayer = (Player) pc.getEntity("PLAYER");
    private mapCreator mc;

    private AnimationTimer timer;
    public Bullet bully;

    private boolean KeyA = false;
    private boolean KeyD = false;

    public int i = 0;

    private static boolean setNull = false;
    private static boolean running = true;
    private boolean intervalShooting = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = new mapCreator(StateManager.LEVEL);
        running = true;
        setNull = false;
        init(gamePane);

        bully = new Bullet(gamePane);

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

                    if (!gravitycheck(mainPlayer)) {
                        mainPlayer.gravity();
                    }

                    if (KeyA) {
                        PlayerCollisionX(4, mainPlayer);
                        mainPlayer.setFill(ResourceManager.playerSprites.get(5));
                    } else if (KeyD) {
                        PlayerCollisionX(4, mainPlayer);
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
                    playerMapCollisionChecker2(mainPlayer);

                } else return;
            }
        };

        timer.start();
    }

    public void init(Pane p) {
        p.setBackground(new Background(new BackgroundImage((ResourceManager.background), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        keyHandlerInit(p);

        if(mc == null)
            System.out.println("MC NULL");

        if(mc.getLEVELARRAY() == null){
            System.out.println("LEVELARRAY NULL");
        } else System.out.println("not null");
               mc.initMap(p);

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
            case LEFT:
                this.KeyD = false ;
                this.KeyA = true;
                break;
            case D:
            case RIGHT:
                this.KeyA = false;
                this.KeyD = true;
                break;
            case W:
                if (gravitycheck(mainPlayer)) {
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

            case ESCAPE:
                gameController.running = false;
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
            /*p.setHealthAmount(p.getHealthAmount() - 1);
            healthLabel.setText(Integer.toString(p.getHealthAmount()));*/
            changeScene(StateManager.GameState.MAINMENU);
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

        /*System.out.println("EMAP a "+mc.getEntityMap());
        System.out.println("EMAP b "+mapCreator.getERMap());
        System.out.println("gamePane children " + gamePane.getChildren());
        System.out.println("gpWrap children " + gpWrap.getChildren());
        System.out.println("gamepane "+gamePane);
        System.out.println("gpWrap" + gpWrap);*/

        mc.setEntityMap(null);
        mc.setMap(null);

        gamePane.removeEventHandler(KeyEvent.ANY, this);
        gamePane.setOnKeyPressed(null);
        gamePane.setOnKeyReleased(null);

        timer = null;
        gpWrap = null;
        gamePane = null;
        mc = null;
        mainPlayer = null;
        pc = null;

        StateManager.removeGameRoot();
    }

    public void changeScene(StateManager.GameState gameState){
        StateManager.changeScene(gameState);
        gameController.setSetNull(true);
        running = false;
    }

    public static void setSetNull(boolean setNull) {
        gameController.setNull = setNull;
    }

    public void runtime(){
        i++;
        if (i%60==0){
            System.out.println("runtime:"+ i/60);
      /*  System.out.println("Entities: "+mc.getEntityMap().size());
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