package sample.Entity;

import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

public  abstract class Enemy extends Rectangle implements Entity {

    private double EPosX= 50;
    private double EposY =50;

    //Setter opp entiteten Player sine vilkårlige verdier.
    /*public void initEnemy(Pane p) {
        this.setHeight(30);
        this.setWidth(30);
        setX(EPosX);
        setY(EposY);
        this.setFill(Color.RED);
        p.getChildren().add(this);
    }

    public void renderEnemy() {

       /// for(int i = 0; i<mapCreator.getSizeEMap(); i++)
            setX(EPosX);
            setY(EposY);
    }

    //Getters og setters

    public void setEPosX(double EPosX) {
        this.EPosX = EPosX;
    }

    public void setEPosY(double EPosY) {
        this.EposY = EPosY;
    }

    public double getEPosX() {
        return EPosX;
    }

    public double getEPosY() {
        return EposY;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;

    }public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }



    public double getxSpeed() {
        return xSpeed;
    }
    /*

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
    }*/
}
