package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Player extends Rectangle implements Entity {
    private double posX = 300;
    private double posY = 300;

    private double xSpeed = 3;
    public double ySpeed = 3;


    protected int left = 0;
    protected int right = 1;


    private static final String testPic = "file:ressurser\\\\char.png";
    Image img = new Image(testPic);
    final private ImagePattern imgPattern = new ImagePattern(img);

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void init(Pane p) {
        this.setHeight(32);
        this.setWidth(32);
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
      //  setPosX(getPosX()+xSpeed);

      //  {System.out.println(ySpeed);}
       // {System.out.println(xSpeed);}
        // System.out.println(this.posX);
        // System.out.println(this.posY);
    }

    public void gravity() {
        if (ySpeed<9)
        ySpeed = ySpeed+0.3;
    }

    public void renderPlayer() {
        setX(posX);
        setY(posY);
    }

    public void MoveLeft() {
        setxSpeed(-1);
        setPosX(getPosX()+xSpeed);
    }

    public void MoveRight() {
        setxSpeed(1);
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