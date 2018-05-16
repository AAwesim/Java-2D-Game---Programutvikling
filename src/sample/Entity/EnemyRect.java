package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;

/**
 * Denne klassen extender Rectangle og implementerer Enemy interface
 * Klassen gjør at man kan opprette rectangelformede enemies i mapcreator
 */


public class EnemyRect extends Rectangle implements Enemy {

    /**
     * datafeltet til klassen EnemyRect. int variablene Width og height definerer høyden og widten til
     * enemyrect, mens RPosX og Y brukes til å sette posisjonen
     */
    protected int width = 50;
    protected int height = 50;
    protected double RPosX;
    protected double RPosY;

    /**
     * Konstruktøren til klassen EnemyRect. Ved kall på konstruktøren opprettes et object av typen EnemyRect
     * og setter X og RPosX lik parametern RposX tilsvareende for Y. setter Width og height slik de er definert i datafeltet
     * adder så instansen objectet til Parameteren p som er av typen Pane. adder
     * @param RPosX
     * @param RPosY
     * @param p
     */
    public EnemyRect(double RPosX, double RPosY, Pane p) {
        this.setRPosX(RPosX);
        this.setX(RPosX);
        this.setRPosY(RPosY);
        this.setY(RPosY);
        this.setFill(ResourceManager.mapTextures.get(3));
        this.setWidth(width);
        this.setHeight(height);
        p.getChildren().add(this);
        mapCreator.getERMap().add(this);
    }

    /**
     * overrider metoden i interfacet Enemy
     */
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

