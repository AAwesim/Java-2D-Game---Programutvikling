package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Player extends Rectangle implements Entity {
    private int posX;
    private int posY;

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
        this.setX(0);
        this.setY(0);
        p.getChildren().add(this);
    }

    public void update(){
        if(this.posY < (int)(480.0 - 32.0)){
            this.setPosY(ySpeed);
            this.setySpeed(1);
            System.out.println(posY);
        }
        else {
            setPosY(0);
            ySpeed = 2;
        }

        if(direction == left){
            this.setPosX(-xSpeed);
        }
        else if(direction == right) {
            this.setPosX(xSpeed);
        }

        else return;

    }

    public void render(){
        setX(posX);
        setY(posY);
        this.setFill(imgPattern);
    }

    public void checkBorderCollision(double playerX, double playerY){
        return;
    }

    //Getters og setters
    public Image getImg() {
        return null;
    }

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
        this.ySpeed += ySpeed;
    }
}
