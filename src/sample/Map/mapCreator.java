package sample.Map;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Entity.Enemy;
import sample.Entity.EntityCreator;
import sample.Entity.Player;

import java.util.ArrayList;
import java.util.BitSet;

import static javafx.scene.paint.Color.DARKGREEN;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.color;


public class mapCreator{

    private static String[] LEVEL2MAP;
    private static String[] LEVEL3MAP;
    private static String[] LEVEL4MAP;

    private int scalar = 75;
    private int widthscalar = 70;

    private EntityCreator ec = new EntityCreator();

    private static final String Dit = "file:ressurser\\\\Dirt.png";
    Image D = new Image(Dit);
    final private ImagePattern Dirt = new ImagePattern(D);

    private static final String testPic = "file:ressurser\\\\Grass.png";
    Image img = new Image(testPic);
    final private ImagePattern Grass = new ImagePattern(img);

    public ArrayList<Rectangle> map=new ArrayList<>();
    public ArrayList<Enemy> Emap=new ArrayList<>();

    public static final String[] LEVEL1MAP = new String[] {

            "0000000000000000000000000000000000000033300000000000000",
            "0000000000000000000000000000000000000033300000000000000",
            "0000000000000000000000000000000004000000001111111001111",
            "0500000000400000000001111110001110000000003333333300003",
            "0000400001111101011113333333003333000000003333333003333",
            "1111111003333300033333333333300000000044000000000033333",
            "3333333003333322233333333333222222100111113333233333333",
            //bredde: 69 høyde:15
            //Hvis dere lager maps sørg for at de er rektangel formet slik  0000  ikke 000
            //        
    };

    public void initMap(Pane pe){


        for (int i = 0; i < mapCreator.LEVEL1MAP.length; i++) {
            String line = mapCreator.LEVEL1MAP[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapPart1 = mapMaker1(j*widthscalar,i*scalar,widthscalar,scalar, pe);
                       // mapPart1.setFill(Color.DARKGREEN);
                         mapPart1.setFill(Grass);
                        map.add(mapPart1);
                        break;
                    case '2':
                        mapPart1 = mapMaker1(j*widthscalar,i*scalar,widthscalar,scalar, pe);
                        mapPart1.setFill(color(0.70,0.20,0.10));
                        //p.add(mapPart1);
                        break;
                    case '3':
                        mapPart1 = mapMaker1(j*widthscalar,i*scalar,widthscalar,scalar, pe);
                        //mapPart1.setFill(Color.rgb(97, 63, 16));
                        mapPart1.setFill(Dirt);
                        map.add(mapPart1);
                        break;
                    case '4':
                        Enemy enemy1 = (Enemy) ec.getEntity("ENEMY1");
                        enemy1.setPosX(j*widthscalar);
                        enemy1.setPosY(i*scalar+30);
                        enemy1.initEnemy(pe);
                        Emap.add(enemy1);
                        break;
                    case '5':
                        Enemy enemy2 = (Enemy) ec.getEntity("ENEMY2");
                        enemy2.setPosX(j*widthscalar);
                        enemy2.setPosY(i*scalar);
                        enemy2.initEnemy(pe);
                        Emap.add(enemy2);
                        break;
                    case '6':
                        Enemy enemy3 = (Enemy) ec.getEntity("ENEMY3");
                        enemy3.setPosX(j*widthscalar);
                        enemy3.setPosY(i*scalar);
                        enemy3.initEnemy(pe);
                        Emap.add(enemy3);
                        break;
                }
            }
        }
    }

    private Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x,y,w,h);
        pe.getChildren().add(rect);
        return rect;
    }
    public ArrayList<Enemy>  getEMap() {
        return Emap;
    }



    public ArrayList<Rectangle> getMap() {
        return map;
    }

  /* public void RemoveMap() {
        map.remove(Rectangle);
    }*/

    //tar inn parameter som svarer til map 1,2 3 etc.. og returnerer lengden til mappet i piksler
    //tenkte å ha denne i en mer generel map klasse som inneholder string arrayene til de ulike levelene
    // har for nå bare adda det her
    public int getmapLength(int i) {
        int length=0;
        switch (i){
            case 1:
                length=widthscalar*LEVEL1MAP[0].length();
                break;
            case 2:
                length= widthscalar*LEVEL2MAP[0].length();
                break;
            case 3:
                length= widthscalar*LEVEL3MAP[0].length();
                break;
            case 4:
                length= widthscalar*LEVEL4MAP[0].length();
                break;
        }
        return length;
    }
}
