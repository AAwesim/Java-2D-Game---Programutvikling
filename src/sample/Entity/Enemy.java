package sample.Entity;

import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Map.mapCreator;

import java.util.ArrayList;

public class Enemy extends Rectangle {



    private static int width = 35;
    private static int height = 35;
    private double EPosX;
    private double EPosY;
    private int a ;


    public Enemy(double EPosX, double EPosY, Pane p) {
        setEPosX(EPosX);
        setX(EPosX);
        setEPosY(EPosY);
        setY(EPosY);
        System.out.println("Enemy");
        this.setFill(Color.RED);
        this.setWidth(width);
        this.setHeight(height);
        Enemyh.getEnemyh().addE1List(this);
        p.getChildren().add(this);
    }

    public void EnemyMove(int i){
        switch (i) {
            case 1:
                for(int j=0;j<Enemyh.getEnemyh().getE1List().size();j++){
                    Enemy1.getEnemy().Enemy1Movement(Enemyh.getEnemyh().getE1List().get(j));
                }
        }
    }


    //renderEnemy ved å bruke setX/Y metoden i Rectangle som tar inn EPosX/Y til Hvert Enemy1 object
    // for loopen kjøres en gang for hvert element i E1Listen som inneholder alle Enemy Objektene.

    /*public void e1() {
        for(int i = 0; i<getE1List().size(); i++) {


            getE1List().get(i).setX(getE1List().get(i).getEPosX());
            getE1List().get(i).setY(getE1List().get(i).getEPosY());
        }
    }*/
    //public void renderEnemy2() {


    //Getters og setters

    /*public void setEPosX(double EPosX) {
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
    }*/
/*
    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;

    }public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }



    public double getxSpeed() {
        return xSpeed;
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

    public void EnemyMoveLeft(int x) {
        System.out.println("MLeft");
        setxSpeed(-x);
        setPosX(getPosX()+xSpeed);
    }

    public void EnemyMoveRight(int x) {
        System.out.println("MRight");
        setxSpeed(x);
        setPosX(getPosX()+xSpeed);
    }*/

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
