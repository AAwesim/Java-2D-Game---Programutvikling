package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class Enemy1 {

    private int i;
    private int ce1;

        private int  a ;

        private static final Enemy1 e1 = new Enemy1();

        public static Enemy1 getEnemy() {
            return e1;
        }

    public void Enemy1Movement(Enemy e) {
            ce1++;
        System.out.println(ce1);
            //     System.out.println(e.getEPosX()+" "+e.getX());
        if (e.getX() > e.getEPosX() + 200) {
            i = -2;
        }
        if (e.getX() <= e.getEPosX()) {
            i = 2;
        }
        e.setX(e.getX()+i);
    }
}