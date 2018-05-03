package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Player extends Rectangle implements Entity {
    private double posX = 640 / 2 - 160;
    private double posY = 480 / 2 - 16;

    private double xSpeed = 3;
    public double ySpeed = 3;

    private int direction = 3;
    protected int left = 0;
    protected int right = 1;


    private static final String testPic = "file:ressurser\\\\char.png";
    Image img = new Image(testPic);
    final private ImagePattern imgPattern = new ImagePattern(img);

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void init(Pane p) {
        this.setHeight(50);
        this.setWidth(35);
        //this.setFill(imgPattern);
        this.setFill(Color.BLUE);
        this.setX(posX) ;
       // System.out.println(posX);
        this.setY(posY);
        //System.out.println(posY);
        p.getChildren().add(this);

    }

    public void updatePlayerState() {
        //gravity();
        setPosY(getPosY()+ySpeed);
      //  {System.out.println(ySpeed);}
       // {System.out.println(xSpeed);}
        playerMovement();
        // System.out.println(this.posX);
        // System.out.println(this.posY);
    }

    public void gravity() {
        ySpeed = ySpeed+0.2;
    }

    public void renderPlayer() {
        setX(posX);
        setY(posY);
    }

    public void playerMovement() {
        if (direction == left) {
            this.setPosX(getPosX()-xSpeed);
            this.setxSpeed(4);
        } else if (direction == right) {
            this.setPosX(getPosX()+xSpeed);
            setxSpeed(4);
        } else return;

    }

    //Getters og setters

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

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