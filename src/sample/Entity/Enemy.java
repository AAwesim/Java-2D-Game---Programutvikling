package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemy extends rectangle {

    protected static int width = 35;
    protected static int height = 35;
    protected double EPosX;
    protected double EPosY;


    //konstruerer Enemy
    public Enemy() {
        this.setEPosX(EPosX);
        this.setX(EPosX);
        this.setEPosY(EPosY);
        this.setY(EPosY);
        this.setFill(Color.RED);
        this.setWidth(width);
        this.setHeight(height);
       // if(type==1){this.setFill(Color.RED); }//EH().addE1List(this);}
       // if(type==2){this.setFill(Color.DARKBLUE); }//EH().addE2List(this);}
      //  if(type==3){this.setFill(Color.BLACK);}
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

    /*public void e1() {
        for(int i = 0; i<getE1List().size(); i++) {
            getE1List().get(i).setX(getE1List().get(i).getEPosX());
            getE1List().get(i).setY(getE1List().get(i).getEPosY());
        }
    }
 /*
     public void Enemygravity() {
       if (ySpeed<7)
            ySpeed = ySpeed+0.3;
    }

    public void renderEnemy() {
        setX(EposX);
        setY(EposY);
        }
*/


