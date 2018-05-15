package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import sample.Map.mapCreator;
import sample.Tools.ResourceManager;

import static javafx.scene.paint.Color.BLUE;

public class EnemyCircle extends Circle implements Entity {


    private double CPosX;
    private double CPosY;

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

    @Override
    public void RenderEntity() {
    }
}
