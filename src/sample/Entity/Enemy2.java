package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Enemy2 extends Enemy {

    private double ySpeed;
    private int EposX;
    private int EposY;


    @Override
    public void initEnemy(Pane p) {
        this.setHeight(35);
        this.setWidth(35);
        setX(EposX);
        setY(EposY);
        this.setFill(Color.YELLOW);
        p.getChildren().add(this);
    }

    public void Enemygravity() {
        if (ySpeed<7)
            ySpeed = ySpeed+0.3;
    }

    public void renderEnemy() {
        setX(EposX);
        setY(EposY);
    }

    public void setySpeed(double ySpeed) {
    this.ySpeed = ySpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

}
