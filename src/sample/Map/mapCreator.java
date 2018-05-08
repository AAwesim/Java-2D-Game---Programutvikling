package sample.Map;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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

    private int scalar = 35;
    public ArrayList<Rectangle> map=new ArrayList<>();

    public static final String[] LEVEL1MAP = new String[] {
            "00000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000001000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000001000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000001000000000000000000000111000000000000000000000000000000000000000000000000000000000000000",
            "00000000000000001000000000000000000000111000000000000000000000000001100000000000000001100000000000000111",
            "00000000000000111110000000110001110000111000000000000000100000011111000000100000011111000010000001111100",
            "00000000000000000000001111330003330000000000000000000011100110000000000011100110000000001110011000000000",
            "00100100000111000001113333330003330000000000000110111033300000000000011033300000000000003330000000000000",
            "11111110011333000003333333330003330000000000111330333033300000000000033033300000000000003330000000000000",
            "33333330033333222223333333332223331100111100003330333033311111111111133033311111111111103331111111111111"
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
                        Rectangle mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(Color.DARKGREEN);
                        // mapPart1.setFill();
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

    //tar inn parameter som svarer til map 1,2 3 etc.. og returnerer lengden til mappet i piksler
    //tenkte å ha denne i en mer generel map klasse som inneholder string arrayene til de ulike levelene
    // har for nå bare adda det her
    public int getmapLength(int i) {
        int length=0;
        switch (i){
            case 1:
                length= scalar*LEVEL1MAP[0].length();
                break;
            case 2:
                length= scalar*LEVEL2MAP[0].length();
                break;
            case 3:
                length= scalar*LEVEL3MAP[0].length();
                break;
            case 4:
                length= scalar*LEVEL4MAP[0].length();
                break;
        }
        return length;
    }
}
