package sample.Map;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Entity.*;
import sample.Tools.ResourceManager;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;

public class mapCreator {
    private String levelID;

    private int scalar = 50;
    private int widthscalar = 50;

    public  ArrayList<Rectangle> map = new ArrayList<>();
    private static ArrayList<EnemyRect> ERMap = new ArrayList<>();
    private static ArrayList<EnemyCircle> ECMap = new ArrayList<>();
    private ArrayList<Enemy> enemyMap = new ArrayList<>();

    private String[] LEVELARRAY;

    /**
     * Konstruktøren til mapCreator tar inn
     * @param levelID
     */
    public mapCreator(String levelID){
        this.levelID = levelID;
        MapIO mapIO = new MapIO(this.levelID);
        this.LEVELARRAY = mapIO.getMapArray();
    }

    public void initMap(Pane pe) {
        for (int i = 0; i < LEVELARRAY.length; i++) {
            String line = LEVELARRAY[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapPart1 = mapMaker1(j * widthscalar, i * scalar, widthscalar, scalar, pe);
                        // mapPart1.setFill(Color.DARKGREEN);
                        mapPart1.setFill(ResourceManager.mapTextures.get(1));
                        map.add(mapPart1);
                        break;
                    case '2':
                        mapPart1 = mapMaker1(j * widthscalar, i * scalar, widthscalar, scalar, pe);
                        mapPart1.setFill(color(0.90, 0.20, 0.10));
                        //p.add(mapPart1);
                        break;
                    case '3':
                        mapPart1 = mapMaker1(j * widthscalar, i * scalar, widthscalar, scalar, pe);
                        //mapPart1.setFill(Color.rgb(97, 63, 16));
                        mapPart1.setFill(ResourceManager.mapTextures.get(0));
                        map.add(mapPart1);
                        break;
                    case '4':
                        Enemy enemy1 = new EnemyMovingYDecorator(new EnemyRect(j * widthscalar, i * scalar, pe));
                        enemyMap.add(enemy1);
                        break;
                    case '5':
                        Enemy enemy2 = new EnemyRect( j * widthscalar, i * scalar, pe);
                        enemyMap.add(enemy2);
                        break;
                    case '6':
                        Enemy enemy3 = new EnemyMovingYDecorator(new EnemyCircle( j * widthscalar, i * scalar,20, pe));
                        enemyMap.add(enemy3);
                        break;
                    case '7':
                        Enemy enemy4 = new EnemyMovingXDecorator(new EnemyRectsmall( j * widthscalar, i * scalar, pe));
                        enemyMap.add(enemy4);
                    default:
                        break;
                }
            }
        }
    }

    private Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x, y, w, h);
        pe.getChildren().add(rect);
        return rect;
    }

    public static ArrayList<EnemyCircle> getECMap() {
        return ECMap;
    }

    public static void setECMap(ArrayList<EnemyCircle> ECMap) {
        mapCreator.ECMap = ECMap;
    }
    public static ArrayList<EnemyRect> getERMap() {
        return ERMap;
    }

    public ArrayList<Enemy> getEnemyMap() {
        return enemyMap;
    }

    public void setEnemyMap(ArrayList<Enemy> enemyMap) {
        this.enemyMap = enemyMap;
    }

    public int getmapLength() {
        return scalar * LEVELARRAY[0].length();
    }

    public ArrayList<Rectangle> getMap() {
        return map;
    }

    public void setMap(ArrayList<Rectangle> map) {
        this.map = map;
    }

    public void setERMap(ArrayList<EnemyRect> ERMap) {
        mapCreator.ERMap = ERMap;
    }

    public String[] getLEVELARRAY() {
        return LEVELARRAY;
    }
}
