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

    private int scalar = 35;
    public  int levelWidth;
    public ArrayList<Rectangle> map=new ArrayList<>();
    public  String testPic = "file:ressurser\\\\testpic.jpeg";
    Image img = new Image(testPic);

    public static final String[] LEVEL1MAP = new String[] {
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000111000000000000000000011110000000000000000000000000111",
            "000111000000001000100000001100011100001110000000000000010000001111100",
            "000000000000000000000011111100011100000000000000000001110011000000000",
            "000000000000110000011111111100011100000000000001101101110000000000000",
            "111111100111110000011111111100011100000000001101101101110000000000000",
            "111111100111112222211111111122211101101101100001101101111111111111111"
            //bredde: 69 høyde:15
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
                        mapPart1.setFill(Color.rgb(44,190,49));
                        map.add(mapPart1);
                        break;
                    case '2':
                        mapPart1 = mapMaker1(j*scalar,i*scalar,scalar,scalar, pe);
                        mapPart1.setFill(color(0.0,0.20,0.50));
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

   public void playerMapCollisionChecker(Player p){
       for(Rectangle mapPart:map){
           if(p.intersects(mapPart.getBoundsInLocal())){
               p.setySpeed(0);
               p.setxSpeed(0);
               p.setDirection(5);
               System.out.println("h");
               return;
           }
       }
   }

}
