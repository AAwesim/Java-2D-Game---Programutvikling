package sample.Entity;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Player extends Rectangle implements Entity {
    private int posX;
    private int posY;
    public static final String testPic = "file:ressurser\\\\mate.png";
    Image img=new Image(testPic);
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

    public void render(){
        setX(posX);
        setY(posY);
        this.setFill(imgPattern);
    }

    //Getters og setters
    public Image getImg() {
        return null;
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
}
