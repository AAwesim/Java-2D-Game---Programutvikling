package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;

public class EnemyRect extends Rectangle implements Enemy {

    protected static int width = 50;
    protected static int height = 50;
    protected double RPosX;
    protected double RPosY;

    //konstruerer EnemyRect
    public EnemyRect(double RPosX, double RPosY, Pane p) {
        this.setRPosX(RPosX);
        this.setX(RPosX);
        this.setRPosY(RPosY);
        this.setY(RPosY);
        this.setFill(ResourceManager.mapTextures.get(3));
      //  this.setFill(Color.BLUE);
        this.setWidth(width);
        this.setHeight(height);
        p.getChildren().add(this);
        mapCreator.getERMap().add(this);
    }

    @Override
    public void RenderEntity(){
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

