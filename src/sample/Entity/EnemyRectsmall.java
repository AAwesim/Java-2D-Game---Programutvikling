package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;

public class EnemyRectsmall extends EnemyRect {
    protected static int width = 20;
    protected static int height = 20;
    protected double RPosX;
    protected double RPosY;

    //konstruerer EnemyRect
    public EnemyRectsmall(double RPosX, double RPosY, Pane p) {
        super(RPosX, RPosY, p);
        this.setFill(ResourceManager.mapTextures.get(4));
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
