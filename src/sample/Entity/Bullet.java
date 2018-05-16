package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.Tools.ResourceManager;

import java.util.ArrayList;

public class Bullet {
    private Pane gamePane;
    private final double bulletSpeed=5;
    private double posx;
    private double posy;
    private double w=10;
    private double h=10;
    public ArrayList<Circle> bullets=new ArrayList<>();

    /**
     * tar inn en Pane som parameter og gir en referanse til den slik at den kan bli brukt senere
     * som refereanse i andre metoder.
     * @param gamePane
     */
    public Bullet(Pane gamePane) {
        this.gamePane = gamePane;
    }

    /**
     * denne metoden skaper en sirkel med posisjon posx, og posy som parametere, i tillegg tar
     * den inn textures som blir hentet fra klassen resoursemanager.
     * denne sirkelen blir lagt inn i Panen vår og sirkelene blir lagret i en Arraylist.
     * @param posx angitt posisjon x
     * @param posy angitt posisjon y
     */
    public void initBullet(double posx, double posy){
        Circle circle= new Circle();
        circle.setRadius(w);
        circle.setCenterX(posx);
        circle.setCenterY(posy);
        circle.setFill(ResourceManager.mapTextures.get(4));
        gamePane.getChildren().add(circle);
        bullets.add(circle);
    }

    /**
     * gir bulletspeeden til bulleten
     * @return bullet sin fart
     */
    public double getBulletSpeed(){return bulletSpeed; }

}

