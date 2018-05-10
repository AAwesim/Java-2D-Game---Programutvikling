package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.*;

<<<<<<< HEAD
public class Player extends Rectangle implements Entity {

    private double posX = 300;
    private double posY = 300;

    private double xSpeed = 4;
    public double ySpeed = 4;

    private static final String testPic = "file:ressurser\\\\char.png";
    Image img = new Image(testPic);
    final private ImagePattern imgPattern = new ImagePattern(img);

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void initPlayer(Pane p) {
        this.setHeight(32);
        this.setWidth(32);
        //this.setFill(imgPattern);
        //this.setFill();
        this.strokeProperty();
        this.setStroke(Color.ALICEBLUE);
        this.setX(posX) ;
       // System.out.println(posX);
=======

public class Player extends Rectangle implements Entity, Serializable {
    private double posX = 640 / 2 - 160;
    private double posY = 480 / 2 - 16;

    private double xSpeed = 8;
    private double ySpeed = 0.7;

    private double height = 50;
    private double width = 35;

    private int direction = 5;
    private int left = 0;
    private int right = 1;

    private static transient final String testPic = "file:ressurser\\\\char.png";
    transient Image img = new Image(testPic);
    transient final private ImagePattern imgPattern = new ImagePattern(img);

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void init(Pane p) {
        this.setHeight(height);
        this.setWidth(width);
        /*this.setFill(imgPattern);*/
        this.setFill(Color.BLUE);
        this.setX(posX);
>>>>>>> Asim
        this.setY(posY);
        //System.out.println(posY);
        p.getChildren().add(this);
    }

    public void updatePlayerState() {
        //gravity();
        setPosY(getPosY()+ySpeed);
      //  setPosX(getPosX()+xSpeed);

      //  {System.out.println(ySpeed);}
       // {System.out.println(xSpeed);}
        // System.out.println(this.posX);
        // System.out.println(this.posY);
    }

    public void gravity() {
        if (ySpeed<7)
        ySpeed = ySpeed+0.3;
    }

    public void renderPlayer() {
        setX(posX);
        setY(posY);
    }


    public void MoveLeft(int x) {
        System.out.println("MLeft");
        setxSpeed(-x);
        setPosX(getPosX()+xSpeed);
    }

    public void MoveRight(int x) {
        System.out.println("MRight");
        setxSpeed(x);
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

}