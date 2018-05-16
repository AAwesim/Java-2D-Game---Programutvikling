package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;

/**
 * Denne klassen extender Circle og implementerer Enemy interfacet
 * Klassen gjør at man kan opprette SirkelFormede enemies
 */


public class EnemyCircle extends Circle implements Enemy {

    /**
     * dataFeltet består av CPosX og CPosY
     */
    private double CPosX;
    private double CPosY;

    /**
     * Konstruktøren til klassen EnemyCircle. Ved kall på konstruktøren oppretter den et object av typen EnemyCircle
     * og setter CenterX, CenterY,CPosX og CposY lik parameterne centerX og centerY. setter radius lik radius
     * og add objectet til Pane p.
     * @param centerX
     * @param centerY
     * @param radius
     * @param p
     */
    public EnemyCircle(double centerX, double centerY, double radius, Pane p){
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setRadius(radius);
        this.setCPosX(centerX);
        this.setCPosY(centerY);
        this.setFill(ResourceManager.mapTextures.get(5));
        p.getChildren().add(this);
        mapCreator.getECMap().add(this);
    }


    public void setCPosX(double CPosX) {
        this.CPosX = CPosX;
    }

    public void setCPosY(double CPosY) {
        this.CPosY = CPosY;
    }

    public double getCPosX() {
        return CPosX;
    }

    public double getCPosY() {
        return CPosY;
    }

    /**
     * overrider metoden i Enemy interfacet.
     */
    @Override
    public void RenderEntity() {
    }
}
