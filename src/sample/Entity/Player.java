package sample.Entity;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Player extends Rectangle implements Entity, EventHandler<KeyEvent> {
    private int posX = 640/2-16;
    private int posY = 480/2-16;

    private int xSpeed = 8;
    private int ySpeed = 1;

    private int direction = 5;
    private int left = 0;
    private int right = 1;


/*    private static final String testPic = "file:ressurser\\\\mate.png";
    Image img = new Image(testPic);
    final private ImagePattern imgPattern = new ImagePattern(img);*/

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void init(Pane p){
        this.setHeight(25);
        this.setWidth(25);
        /*this.setFill(imgPattern);*/
        this.setFill(Color.BLUE);
        this.setX(posX);
        this.setY(posY);
        p.getChildren().add(this);
    }

    public void updatePlayerState(){
        gravity();
        playerMovement();
       // System.out.println(this.posX);
       // System.out.println(this.posY);

    }

    public void gravity(){
        if(posY+32>480){
            this.setySpeed(ySpeed * -1);
        }
        else {
            ySpeed += 1;
        }
        setPosY(ySpeed);
    }

    public void renderPlayer(){
        setX(posX);
        setY(posY);
    }

    public void playerMovement() {
        if(direction == left){
            this.setPosX(-xSpeed);
        }
        else if(direction == right) {
            this.setPosX(xSpeed);
        }
        else return;
    }

    //Getters og setters

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX += posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY += posY;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void handle(KeyEvent event) {

    }
}
