package sample.Map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Entity.Enemy;
import sample.Entity.Enemy1;
import sample.Entity.EntityCreator;
import sample.Tools.ResourceManager;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;

public class mapCreator {

    private int scalar = 50;
    private int widthscalar = 50;

    private EntityCreator ec = new EntityCreator();

    private  ArrayList<ImagePattern> textures;
    private  ArrayList<Rectangle> map = new ArrayList<>();
    private  ArrayList<Enemy> Emap = new ArrayList<>();

    public mapCreator(){
        textures = ResourceManager.mapTextures;
    }

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
                        mapPart1.setFill(textures.get(0));
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
                        mapPart1.setFill(textures.get(1));
                        map.add(mapPart1);
                        break;
                    case '4':
                        Enemy enemy1 = ec.getEnemy(1,j * widthscalar,i * scalar, pe);
                        if(enemy1!=null)
                            Emap.add(enemy1);
                        //System.out.println("mapCreator Emap: "+Emap);
                        break;
                     case '5':
                        Enemy enemy2 = ec.getEnemy(2,j * widthscalar,i * scalar, pe);
                        if(enemy2!=null)
                            Emap.add(enemy2);
                        break;
                    case '6':
                        Enemy enemy3 = ec.getEnemy(3,j * widthscalar,i * scalar, pe);
                        if(enemy3!=null)
                            Emap.add(enemy3);
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

    public ArrayList<ImagePattern> getTextures() {
        return textures;
    }

    public void setTextures(ArrayList<ImagePattern> textures) {
        this.textures = textures;
    }

    public void setMap(ArrayList<Rectangle> map) {
        this.map = map;
    }

    public ArrayList<Enemy> getEmap() {
        return Emap;
    }

    public void setEmap(ArrayList<Enemy> emap) {
        Emap = emap;
    }
}
