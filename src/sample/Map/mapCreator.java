package sample.Map;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Entity.Player;

import java.util.ArrayList;

public class mapCreator{

    private int scalar = 24;
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
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000000000000000000000000000000",
            "000111000000000000000000000000",
            "000000001110000000000000000000",
            "000001000000011100001000000000",
            "000001110000000000011100011000",
            "111111110011110001111100111111"
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
                        Rectangle mapParts = mapMaker(j*scalar,i*scalar,scalar,scalar, pe);
                        map.add(mapParts);
                        break;
                }
            }
        }

    }
    public Rectangle mapMaker(int x, int y, int w, int h, Pane pe) {
        Rectangle rect = new Rectangle(x,y,w,h);
        pe.getChildren().add(rect);
        return rect;

    }

   public void playerMapCollisionChecker(Player p){
       for(Rectangle mapPart:map){
           if(p.intersects(mapPart.getBoundsInParent())){
               System.out.println("lets goooo");
               return;
           }
       }
   }

}
