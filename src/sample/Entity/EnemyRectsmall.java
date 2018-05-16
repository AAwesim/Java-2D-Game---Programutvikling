package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;

/**
 * klassen extender EnemyRect og tillater funksjonalitet for å opprette mindre
 * rectangelformede Enemies i mapcreator
 */

public class EnemyRectsmall extends EnemyRect {

    protected int width = 20;
    protected int height = 20;
    protected double RPosX;
    protected double RPosY;

    //konstruerer EnemyRect
    public EnemyRectsmall(double RPosX, double RPosY, Pane p) {
        super(RPosX, RPosY, p);
        this.setFill(ResourceManager.mapTextures.get(3));
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
