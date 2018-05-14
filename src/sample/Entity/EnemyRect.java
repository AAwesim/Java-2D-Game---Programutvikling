package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

public class EnemyRect extends Rectangle implements Entity {

    protected static int width = 35;
    protected static int height = 35;
    protected double RPosX;
    protected double RPosY;
    private int i;

    //konstruerer EnemyRect
    public EnemyRect(double RPosX, double RPosY, Pane p) {
        this.setRPosX(RPosX);
        this.setX(RPosX);
        this.setRPosY(RPosY);
        this.setY(RPosY);
        this.setFill(Color.RED);
        this.setWidth(width);
        this.setHeight(height);
        p.getChildren().add(this);
        mapCreator.getERMap().add(this);
    }

    @Override
    public void RenderEntity(){
        i++;
        if (i%60==0)
            System.out.println("EnemyRect: "+ i/60);
        setX(getX());
        setY(getY());
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

