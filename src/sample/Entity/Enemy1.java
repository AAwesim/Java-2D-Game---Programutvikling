package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Enemy1 extends Enemy{

    private int i;

    public Enemy1(int type, double EPosX, double EPosY, Pane p) {
        super(type, EPosX, EPosY, p);
    }

    public void Enemy1Movement(Enemy e) {
        if (e.getX() > e.getEPosX() + 200) {
            i = -2;
        }
        if (e.getX() <= e.getEPosX()) {
            i = 2;
        }
        e.setX(e.getX()+i);
    }
}