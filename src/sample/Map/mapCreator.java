package sample.Map;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Entity.Player;

import java.util.ArrayList;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.color;


public class mapCreator{

    
    private static String[] LEVEL2MAP;
    private static String[] LEVEL3MAP;
    private static String[] LEVEL4MAP;

    private int scalar = 35;
    public ArrayList<Rectangle> map=new ArrayList<>();

    public static final String[] LEVEL1MAP = new String[] {
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000010000000000000000000001110000000000000000000000000000",
            "000000000000000010000000000000000000001110000000000000000000000000000",
            "000000000000000010000000000000000000001110000000000000000000000000000",
            "000000000000000010000000000000000000001110000000000000000000000000111",
            "000000000000001111100000001101011100001110000000000000010000001111100",
            "000000000000000000000011113300033300000000000000000001110011000000000",
            "001001000001110000011133333300033300000000000001101103330000000000000",
            "111111100113330000033333333300033300000000001113303303330000000000000",
            "333333300333332222233333333322233311001111000033303303331111111111111"
            //bredde: 69 høyde:15
    };

    public void initMap(Pane pe){

        for (int i = 0; i < mapCreator.LEVEL1MAP.length; i++) {
            String line = mapCreator.LEVEL1MAP[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(Color.rgb(44,190,49));
                        map.add(mapPart1);
                        break;
                    case '2':
                        mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(color(0.0,0.20,0.50));
                        map.add(mapPart1);
                        break;
                    case '3':
                        mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(Color.rgb(97, 63, 16));
                        map.add(mapPart1);
                        break;
                }
            }
        }

    }

    public Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x,y,w,h);
        pe.getChildren().add(rect);
        return rect;
    }

    public ArrayList<Rectangle> getMap() {
        return map;
    }
}
