package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

public class Enemy1 extends Rectangle implements Entity {

    private double EPosX= 50;
    private double EposY =50;
    private int i = 4;

    //Setter opp entiteten Player sine vilkårlige verdier.

    public Enemy1() {

    }

    public void initEnemy(Pane p) {
        this.setHeight(30);
        this.setWidth(30);
        setX(EPosX);
        setY(EposY);
        this.setFill(Color.RED);
        p.getChildren().add(this);
    }

    public void renderEnemy() {
        setX(EPosX);
        setY(EposY);
        if (EPosX>1200){this.i=-4;}
        if (EPosX<800){this.i=4;}
        enemymovement();
    }

    public void enemymovement() {
        setEPosX(getEPosX()+i);
    }



    //Getters og setters

    public void setEPosX(double EPosX) {
        this.EPosX = EPosX;
    }

    public void setEPosY(double EPosY) {
        this.EposY = EPosY;
    }

    public double getEPosX() {
        return EPosX;
    }

    public double getEPosY() {
        return EposY;
    }

}
