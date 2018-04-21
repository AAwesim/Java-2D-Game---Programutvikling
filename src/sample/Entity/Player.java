package sample.Entity;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Player extends Rectangle implements Entity, EventHandler<KeyEvent> {
    private int posX = 640/2-16;
    private int posY = 480/2-16;

    private int xSpeed = 3;
    private int ySpeed = 2;

    private int direction = 5;
    private int left = 0;
    private int right = 1;


    private static final String testPic = "file:ressurser\\\\mate.png";
    Image img = new Image(testPic);
    final private ImagePattern imgPattern = new ImagePattern(img);

    //Setter opp entiteten Player sine vilkårlige verdier.
    public void init(Pane p){
        this.setHeight(32);
        this.setWidth(32);
        this.setFill(imgPattern);
        this.setX(posX);
        this.setY(posY);
        p.getChildren().add(this);
    }

    public void updatePlayerState(){
       // gravity();
        playerMovement();

    }

    public void gravity(){
        if(posY+33>480){
            this.setySpeed(ySpeed * -1);
        }
        else {
            ySpeed += 1;
        }
        setPosY(ySpeed);
        //System.out.println(ySpeed);

    }

    public void renderPlayer(){
        setX(posX);
        setY(posY);
        this.setFill(imgPattern);
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
