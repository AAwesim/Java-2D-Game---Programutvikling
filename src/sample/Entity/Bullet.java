package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class Bullet {
    private Pane gamePane;
    private double bulletSpeed=5;
    private double posx;
    private double posy;
    private double w=10;
    private double h=10;
    public ArrayList<Rectangle> bullets=new ArrayList<>();

    public Bullet(Pane gamePane) {
        this.gamePane = gamePane;
    }

    public void initBullet(double posx, double posy){
        Rectangle rectangle=new Rectangle();
        rectangle.setHeight(w);
        rectangle.setWidth(h);
        rectangle.setX(posx);
        rectangle.setY(posy);
        rectangle.setFill(Color.RED);
        gamePane.getChildren().add(rectangle);
        bullets.add(rectangle);
    }


    public void removeBullet(Rectangle other) {

        gamePane.getChildren().remove(other);
        bullets.remove(bullets);
        }
    public void collisionRemoveFirst(Rectangle rectangle1, Rectangle rectangle2 ){
        if(rectangle1.getBoundsInParent().intersects(rectangle2.getBoundsInParent())){
            removeBullet(rectangle1);
        }
    }


    public void setposx(double posx){ this.posx=posx;}
    public double getPosx(){ return posx;}

    public void setBulletSpeed(double bulletSpeed){this.bulletSpeed=bulletSpeed; }

    public double getBulletSpeed(){return bulletSpeed; }

    public void setPosy(double posy){this.posy=posy;}
    public double getPosy(){return posy;}


}

