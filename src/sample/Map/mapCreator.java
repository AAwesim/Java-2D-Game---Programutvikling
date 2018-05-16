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


    public mapCreator(String levelID){

        this.levelID = levelID;
        MapIO mapIO = new MapIO(this.levelID);
        this.LEVELARRAY = mapIO.getMapArray();

    }

    /**
     * en metode som går gjennom en string av tall og bruker en dobbel for loop for å angi posisjonen
     * til rektanglene som blir skapt, deretter har vi angitt forskjellige konstruktører til
     * de forskjellige tallene.
     * der 1 instansierer et rektangel som har gress og jord som texture og legger den i arraylisten map
     * case 2 instansierer et rektangel med oransje farge
     * case 3 instansierer et rektangel med bare jord og den blir også lagt til i arraylisten map.
     * case 4,5,6,7 instansierer objekter av ulike instanser av enemy og legger dem i en arraylist enemy
     * @param pe blir brukt for å sette inn i konstruktøren av de forskjellige objektene.
     */
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

    /**
     * konstruktør for rektangel som legger til en rektangel på vår gamepane;
     * @param x posisjon x
     * @param y posisjon y
     * @param w bredden av rektangel
     * @param h høyden av rektangel
     * @param pe Pane
     * @return
     */
    private Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x, y, w, h);
        pe.getChildren().add(rect);
        return rect;
    }

    /**
     * returnerer enemy arraylist der enemy er en sirkel
     * @return arraylisten av enemy sirkel
     */
    public static ArrayList<EnemyCircle> getECMap() {
        return ECMap;
    }

    /**
     * setter enemy sirkel map
     * @param ECMap tar inn arraylist av enemymap av sirkel
     */
    public static void setECMap(ArrayList<EnemyCircle> ECMap) {
        mapCreator.ECMap = ECMap;
    }

    /**
     * gir arraylist av enemies av type rektangel
     * @return arraylisten av enemy av typen rektangel
     */
    public static ArrayList<EnemyRect> getERMap() {
        return ERMap;
    }

    /**
     * gir hvilken arraylist som blir brukt for hvilken type enemy det er
     * @return hvilken arraylist det er
     */
    public ArrayList<Enemy> getEnemyMap() {
        return enemyMap;
    }

    /**
     * setter hvilken arraylist det er
     * @param enemyMap angir hvilken arraylist det er
     */
    public void setEnemyMap(ArrayList<Enemy> enemyMap) {
        this.enemyMap = enemyMap;
    }

    /**
     * gir lengden av mappet basert på hvilken string det er
     * @return et tall som er lengden av mappet
     */
    public int getmapLength() {
        return scalar * LEVELARRAY[0].length();
    }

    /**
     * gir arraylisten av map som er platformen
     * @return arraylisten av vår platform
     */
    public ArrayList<Rectangle> getMap() {
        return map;
    }

    /**
     * setter platformen vår til map arraylisten
     * @param map tar inn en arraylist som parameter
     */
    public void setMap(ArrayList<Rectangle> map) {
        this.map = map;
    }

    /**
     * angir hvilken string array det er som blir brukt
     * @return string array som blir brukt
     */
    public String[] getLEVELARRAY() {
        return LEVELARRAY;
    }
}
