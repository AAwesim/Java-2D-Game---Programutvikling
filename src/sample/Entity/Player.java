package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Tools.ResourceManager;

import java.io.*;
import java.util.ArrayList;

import static javafx.scene.paint.Color.BLUE;

public class Player extends Rectangle implements Serializable {

    private double posX = 300;
    private double posY = 300;
    private double xSpeed = 4;
    private double ySpeed = 4;
    private int MaxySpeed = 7;

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void initPlayer(Pane p) {
        this.setHeight(45);
        this.setWidth(36);
        this.setX(posX);
        p.getChildren().add(this);
    }

    public void updatePlayerState() {
        setPosY(getPosY()+ySpeed);
    }

    public void gravity() {
        if (ySpeed<MaxySpeed) {
            ySpeed = ySpeed + 0.3;
        } else {setySpeed(MaxySpeed);}
    }

    public void renderPlayer() {
        setX(posX);
        setY(posY);
    }

    /**
     * Beveger et player object til venstre
     * setter player sin xSpeed lik -x og
     * setter player sin posX lik posX+xspeed     *
     * @param speed
     */
    public void MoveLeft(int speed) {
        //System.out.println("MLeft");
        setxSpeed(-speed);
        setPosX(getPosX()+xSpeed);
    }

    /**
     * Beveger en instanse av player til høyre:
     * setter player sin xSpeed lik x og
     * setter player sin posX lik posX+xSpeed
     * @param speed
     */
    public void MoveRight(int speed) {
      //  System.out.println("MRight");
        setxSpeed(speed);
        setPosX(getPosX()+xSpeed);
    }
    //Getters og setters

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
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

    public int getMaxySpeed() {
        return MaxySpeed;
    }

}