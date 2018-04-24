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

    private int scalar = 25;
    public  int levelWidth;
    public ArrayList<Rectangle> map=new ArrayList<>();
    public  String testPic = "file:ressurser\\\\testpic.jpeg";
    Image img = new Image(testPic);

    public static final String[] LEVEL1MAP = new String[] {
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "00000000000000000000000001110000",
            "00000000000000000000000001110000",
            "00000000000000000000000001110000",
            "00000000000000000000000001110000",
            "00000000000000000011110001110000",
            "00000110011110111011110000000000",
            "11111110011110000011110000000111",
            "11111112211112222211112121111111"
    };

    public void initMap(Pane pe){
        levelWidth = LEVEL1MAP[0].length() * scalar;
        for (int i = 0; i < LEVEL1MAP.length; i++) {
            String line = LEVEL1MAP[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        map.add(mapPart1);
                        break;
                    case '2':
                        Rectangle mapPart2 = mapMaker2(j*scalar,i*scalar,scalar,scalar, pe);
                        map.add(mapPart2);
                        break;

                }
            }
        }

    }
    public Rectangle mapMaker1(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x,y,w,h);
        rect.setFill(Color.rgb(44,210,39));
        pe.getChildren().add(rect);
        return rect;
    }

    public Rectangle mapMaker2(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x,y,w,h);
        rect.setFill(color(0.0,0.20,0.50));
        pe.getChildren().add(rect);
        return rect;
    }

   public void playerMapCollisionChecker(Player p){
       for(Rectangle mapPart:map){
           if(p.intersects(mapPart.getBoundsInParent())){
               p.setySpeed(0);
               return;
           }
       }
   }

}
