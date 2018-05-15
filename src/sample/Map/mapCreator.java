package sample.Map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Entity.*;
import sample.Tools.ResourceManager;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;

public class mapCreator {

    private int scalar = 50;
    private int widthscalar = 50;

    private  ArrayList<Rectangle> map = new ArrayList<>();
    private static ArrayList<EnemyRect> ERMap = new ArrayList<>();
    private static ArrayList<EnemyCircle> ECMap = new ArrayList<>();
    private ArrayList<Entity> EntityMap = new ArrayList<>();

    private String[] LEVELARRAY = Map.getMapArray();

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
                        Entity enemy1 = new EntityMovingYDecorator(new EnemyRect(j * widthscalar, i * scalar, pe));
                        EntityMap.add(enemy1);
                        break;
                    case '5':
                        Entity enemy2 = new EntityMovingXDecorator(new EnemyRect( j * widthscalar, i * scalar, pe));
                        EntityMap.add(enemy2);
                        break;
                    case '6':
                        Entity enemy3 = new EntityMovingYDecorator(new EnemyCircle( j * widthscalar, i * scalar,30, pe));
                        EntityMap.add(enemy3);
                        break;
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

    public ArrayList<Entity> getEntityMap() {
        return EntityMap;
    }

    public void setEntityMap(ArrayList<Entity> entityMap) {
        EntityMap = entityMap;
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
}
