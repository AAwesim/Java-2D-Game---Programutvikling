package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rectangle implements Entity {

    private double EposX;
    private double EposY;

    private double xSpeed = 4;
    public double ySpeed = 4;

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void initEnemy(Pane p) {
        this.setHeight(60);
        this.setWidth(32);
        setX(EposX);
        setY(EposY);
        this.setFill(Color.RED);
        p.getChildren().add(this);
    }

    public void Enemygravity() {
        if (ySpeed<7)
            ySpeed = ySpeed+0.3;
    }

    public void renderEnemy() {
        setX(EposX);
        setY(EposY);
    }

    public void EnemyMoveLeft(int x) {
        System.out.println("MLeft");
        setxSpeed(-x);
        setPosX(getPosX()+xSpeed);
    }

    public void EnemyMoveRight(int x) {
        System.out.println("MRight");
        setxSpeed(x);
        setPosX(getPosX()+xSpeed);
    }

    //Getters og setters

    public void setPosX(double EposX) {
        this.EposX = EposX;
    }

    public double getPosX() {
        return EposX;
    }

    public double getPosY() {
        return EposY;
    }

    public void setPosY(double EposY) {
        this.EposY = EposY;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }
}
