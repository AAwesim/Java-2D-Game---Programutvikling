package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Enemy2 extends Enemy {

    private double ySpeed;
    private double EPosX;
    private double EPosY;


    //@Override
    public void initEnemy(Pane p) {
        this.setHeight(30);
        this.setWidth(30);
        setEPosX(getEPosX());
        setEPosX(getEPosY());
        this.setFill(Color.YELLOW);
        p.getChildren().add(this);
    }

    public void Enemygravity() {
        if (ySpeed<7)
            ySpeed = ySpeed+0.3;
    }

    public void renderEnemy() {
        setX(EPosX);
        setY(EPosY);
    }

    public void setEPosX(double EPosX) {
        this.EPosX = EPosX;
    }

    public void setEPosY(double EposY) {
        this.EPosY = EPosY;
    }

    public double getEPosX() {
        return EPosX;
    }

    public double getEPosY() {
        return EPosY;
    }

}
