package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Map.mapCreator;

public class EnemyRectsmall extends EnemyRect {
    protected static int width = 10;
    protected static int height = 10;
    protected double RPosX;
    protected double RPosY;

    //konstruerer EnemyRect
    public EnemyRectsmall(double RPosX, double RPosY, Pane p) {
        super(RPosX, RPosY, p);
        this.setFill(Color.YELLOW);
        this.setWidth(width);
        this.setHeight(height);
    }

    //Getters og setters

    public void setRPosX(double RPosX) {
        this.RPosX = RPosX;
    }

    public void setRPosY(double RPosY) {
        this.RPosY = RPosY;
    }

    public double getRPosX() {
        return RPosX;
    }

    public double getRPosY() {
        return RPosY;
    }

}
