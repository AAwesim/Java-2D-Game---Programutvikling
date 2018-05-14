package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import static javafx.scene.paint.Color.BLUE;

public class EnemyCircle extends Circle implements Entity {


    protected double CPosX;
    protected double CPosY;

    public EnemyCircle(double centerX, double centerY, double radius, Pane p){
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
        setCPosX(centerX);
        setCPosY(centerY);
        setFill(BLUE);
        p.getChildren().add(this);
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


}
