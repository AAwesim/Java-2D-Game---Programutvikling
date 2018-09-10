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

    /**
     * datafeltet til klassen EnemyRectSmall. int variablene Width og height definerer høyden og widten til
     * enemyrectsmall.
     */
    private int width = 20;
    private int height = 20;

    /**
     * Konstruktøren til klassen EnemyRectSmall. Ved kall på konstruktøren opprettes et object av typen EnemyRect
     * og parent constructor kalles. Setter Width og height slik de er definert i datafeltet.
     * @param RPosX
     * @param RPosY
     * @param p
     */
    public EnemyRectsmall(double RPosX, double RPosY, Pane p, char d) {
        super(RPosX, RPosY, p, d);
        this.setFill(ResourceManager.mapTextures.get(4));
        this.setWidth(width);
        this.setHeight(height);
    }
}
