package sample.Map;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Entity.Enemy;
import sample.Entity.Enemy1;
//import sample.Entity.Enemy2;
import sample.Entity.EntityCreator;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;

public class mapCreator {

    private int scalar = 35;
    private int widthscalar = 35;
    private int levelWidth;

    private EntityCreator ec = new EntityCreator();

    private static final String Dit = "file:ressurser\\\\Dirt.png";
    Image D = new Image(Dit);
    final private ImagePattern Dirt = new ImagePattern(D);

    private static final String testPic = "file:ressurser\\\\Grass.png";
    Image img = new Image(testPic);
    final private ImagePattern Grass = new ImagePattern(img);

    public Enemy1 e1;
    public Enemy1 e2;
    public int ecount = 0;

    public  ArrayList<Rectangle> map = new ArrayList<>();
    public static final ArrayList<Enemy> Emap = new ArrayList<>();


    private String[] LEVELARRAY = Map.getMapArray();

    public void initMap(Pane pe) {
        levelWidth = LEVELARRAY[0].length() * scalar;
        for (int i = 0; i < LEVELARRAY.length; i++) {
            String line = LEVELARRAY[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapPart1 = mapMaker1(j * widthscalar, i * scalar, widthscalar, scalar, pe);
                        // mapPart1.setFill(Color.DARKGREEN);
                        mapPart1.setFill(Grass);
                        map.add(mapPart1);
                        break;
                    case '2':
                        mapPart1 = mapMaker1(j * widthscalar, i * scalar, widthscalar, scalar, pe);
                        mapPart1.setFill(color(0.70, 0.20, 0.10));
                        //p.add(mapPart1);
                        break;
                    case '3':
                        mapPart1 = mapMaker1(j * widthscalar, i * scalar, widthscalar, scalar, pe);
                        //mapPart1.setFill(Color.rgb(97, 63, 16));
                        mapPart1.setFill(Dirt);
                        map.add(mapPart1);
                        break;
                    case '4':
                        ecount++;
                        Enemy enemy1 = ec.getEnemy(1,j * widthscalar,i * scalar, pe);
                       // enemy1.initEnemy(pe);
                        System.out.println("MapCReator");
                        Emap.add(enemy1);
                        System.out.println("mapCreator Emap: "+Emap);
                        break;
                     case '5':
                        Enemy enemy2 = ec.getEnemy(2,j * widthscalar,i * scalar, pe);
                        Emap.add(enemy2);
                        break;
                   /* case '6':
                        Enemy enemy3 = (Enemy) ec.getEntity("ENEMY3");
                        enemy3.setEPosX(j * widthscalar);
                        enemy3.setEPosY(i * scalar);
                        enemy3.initEnemy(pe);
                        Emap.add(enemy3);
                        break;*/
                }
            }
        }
    }

    public Enemy1 getEnemy1(int e) {
        switch (e) {
            case 1 :
                return e1;
            case 2 :
                return e2;
            default:
                return null;
        }
    }

    private Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x, y, w, h);
        pe.getChildren().add(rect);
        return rect;
    }

    public ArrayList<Enemy> getEMap() {
        return Emap;
    }

    public int getSizeEMap() {
        return Emap.size();
    }

    public int getmapLength() {
        return scalar * LEVELARRAY[0].length();
    }

    public ArrayList<Rectangle> getMap() {
        return map;
    }

}
