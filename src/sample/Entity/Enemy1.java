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

        private int  a ;

        private static final Enemy1 e = new Enemy1();

        public static Enemy1 getEnemy() {
            return e;
        }

    public void Enemy1Movement(Enemy e) {
            System.out.println(e.getEPosX()+" "+e.getX());
        if (e.getX() > e.getEPosX() + 200) {
            i = -2;
        }
        if (e.getX() <= e.getEPosX()) {
            i = 2;
        }
        e.setX(e.getX()+i);
    }
    //Setter opp entiteten Player sine vilkårlige verdier.

  /*  public void initEnemy(Pane p) {
        this.setHeight(30);
        this.setWidth(30);
        setX(EPosX);
        setY(EposY);
        p.getChildren().add(this);
    }*/

   /* public void renderEnemy() {
        setX(EPosX);
        setY(EposY);
        enemymovement();
    }*/
}