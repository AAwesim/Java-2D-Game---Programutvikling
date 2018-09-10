package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Tools.ResourceManager;

import java.io.*;

public class Player extends Rectangle implements Serializable {

    private int healthAmount = 3;
    private final int checksum = 123456789;
    public transient boolean KeyA = false;
    public transient boolean KeyD = false;



    //true == left
    public boolean direction ;
    private double posX = 90;
    private double posY = 260;
    private int xSpeed = 4;
    private double ySpeed = 4;
    private int MaxySpeed = 7;

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void initPlayer(Pane p) {
        this.setHeight(45);
        this.setWidth(36);
        setFill(ResourceManager.playerSprites.get(0));
        p.getChildren().add(this);
    }

    public void updatePlayerState() {
        setPosY(getPosY()+ySpeed);
    }


    /**
     * øker yspeed til player dersom den er mindre enn maxyspeed
     */
    public void gravity() {
        if (ySpeed<MaxySpeed) {
            ySpeed = ySpeed + 0.3;
        } else {setySpeed(MaxySpeed);}
    }

    /**
     *setterFill til player avhengig av verdiene til keyA, KeyD og ySpeed
     *kaller på setX og SetY metodene i Rectangle med posX og posY som parameter.
     */
    public void renderPlayer() {
        if (KeyA && ySpeed==0) {
            setFill(ResourceManager.playerSprites.get(5));
            direction=true;
        } else if (KeyD && ySpeed==0) {
            setFill(ResourceManager.playerSprites.get(4));
            direction=false;
        } else if (KeyA){
            setFill(ResourceManager.playerSprites.get(2));
            direction=true;
        } else if (KeyD){
            setFill(ResourceManager.playerSprites.get(3));
            direction=false;
        }
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
        //setxSpeed(-speed);
        setPosX(getPosX()-speed);
    }

    /**
     * Beveger en instanse av player til høyre:
     * setter player sin xSpeed lik x og
     * setter player sin posX lik posX+xSpeed
     * @param speed
     */
    public void MoveRight(int speed) {
      //  System.out.println("MRight");
        //setxSpeed(speed);
        setPosX(getPosX()+speed);
    }

    public void setPlayerPositionStart() {
        setySpeed(0);
        setxSpeed(0);
        setPosX(90);
        setPosY(260);
    }

    //Getters og setters

    //Position
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

    //Speed

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getMaxySpeed() {
        return MaxySpeed;
    }

    //Health

    public int getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }

    public int getChecksum() {
        return checksum;
    }

    public boolean getDirection() {
        return direction;
    }
}