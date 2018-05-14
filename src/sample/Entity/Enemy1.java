package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.Entity;
import sample.Map.mapCreator;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Enemy1 extends Enemy  {

    private int i;




    public Enemy1(){
        EnemyHandler.getE1List().add(this);
    }




   //     p.getChildren().add(this);
    //    EH.addE1List(this);
      //  System.out.println(EH.E1List);
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