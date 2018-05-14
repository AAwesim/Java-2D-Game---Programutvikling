package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EnemyRect extends Rectangle implements Entity {

    protected static int width = 35;
    protected static int height = 35;
    protected double EPosX;
    protected double EPosY;
    private int i ;

    //konstruerer EnemyRect
    public EnemyRect(double EPosX, double EPosY, Pane p) {
        this.setEPosX(EPosX);
        this.setX(EPosX);
        this.setEPosY(EPosY);
        this.setY(EPosY);
        this.setFill(Color.RED);
        this.setWidth(width);
        this.setHeight(height);
        p.getChildren().add(this);
        mapCreator.getEMap().add(this);
        // if(type==1){this.setFill(Color.RED); }//EH().addE1List(this);}
        // if(type==2){this.setFill(Color.DARKBLUE); }//EH().addE2List(this);}
        //  if(type==3){this.setFill(Color.BLACK);}
    }


    public void RenderEntity(){
        i++;
        if (i%60==0)
            System.out.println("EnemyRect: "+ i/60);
        setX(getX());
        setY(getY());
    }


    //Getters og setters

    public void setEPosX(double EPosX) {
        this.EPosX = EPosX;
    }

    public void setEPosY(double EPosY) {
        this.EPosY = EPosY;
    }

    public double getEPosX() {
        return EPosX;
    }

    public double getEPosY() {
        return EPosY;
    }



}

/*    public void e1() {
        for(int i = 0; i<getE1List().size(); i++) {
            this().get(i).setX(getE1List().get(i).getCPosX());
            getE1List().get(i).setY(getE1List().get(i).getCPosY());
        }
    }

     public void Enemygravity() {
       if (ySpeed<7)
            ySpeed = ySpeed+0.3;
    }

    public void renderEnemy() {
        setX(EposX);
        setY(EposY);
        }
*/




//     p.getChildren().add(this);
    //    EH.addE1List(this);
      //  System.out.println(EH.E1List);
