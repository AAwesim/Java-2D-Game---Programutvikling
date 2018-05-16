package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.Tools.ResourceManager;

import java.util.ArrayList;

public class Bullet {
    private Pane gamePane;
    private double bulletSpeed=5;
    private double posx;
    private double posy;
    private double w=10;
    private double h=10;
    public ArrayList<Circle> bullets=new ArrayList<>();

    public Bullet(Pane gamePane) {
        this.gamePane = gamePane;
    }

    public void initBullet(double posx, double posy){
        Circle circle= new Circle();
        circle.setRadius(w);
        circle.setCenterX(posx);
        circle.setCenterY(posy);
        circle.setFill(ResourceManager.mapTextures.get(4));
        gamePane.getChildren().add(circle);
        bullets.add(circle);
    }

    public void removeBullet(Circle other) {

        gamePane.getChildren().remove(other);
        bullets.remove(bullets);
        }
    public void collisionRemoveFirst(Circle circleB, Rectangle rectangle2 ){
        if(circleB.getBoundsInParent().intersects(rectangle2.getBoundsInParent())){
            removeBullet(circleB);
        }
    }


    public void setposx(double posx){ this.posx=posx;}
    public double getPosx(){ return posx;}

    public void setBulletSpeed(double bulletSpeed){this.bulletSpeed=bulletSpeed; }

    public double getBulletSpeed(){return bulletSpeed; }

    public void setPosy(double posy){this.posy=posy;}
    public double getPosy(){return posy;}


}

