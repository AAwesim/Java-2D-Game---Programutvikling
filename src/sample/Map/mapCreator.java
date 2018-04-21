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
        levelWidth = LEVEL1MAP[0].length() * 24;

        for (int i = 0; i < LEVEL1MAP.length; i++) {
            String line = LEVEL1MAP[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle mapParts = mapMaker(j*24,i*24,24,24, pe, Color.RED);
                        map.add(mapParts);
                        break;
                }
            }
        }

    }
    public Rectangle mapMaker(int x, int y, int w, int h, Pane pe, Color color) {

        Rectangle rect = new Rectangle();
        rect.setTranslateX(x);
        rect.setTranslateY(y);
        rect.setWidth(w);
        rect.setHeight(h);
        rect.setFill(color);
        pe.getChildren().add(rect);
        return rect;

    }

    //Iterer gjennom en ArrayList og hvis mapParts i map intersecter med rectangle så blir det true
   /* public void checkCollision(Rectangle r){
        System.out.println(r.getBoundsInLocal()); // Diagnostikk: sjekker bounds
        for(int i = 0; i < map.size(); i++){
            if(map.get(i).intersects(r.getBoundsInLocal())){
                System.out.println("hei");
            }else return;

        }
    }*/
   public void checker(Player p){
       for(Rectangle test: map){
           if(p.intersects(test.getBoundsInParent())){
               System.out.println("lets goooo");
               return;

           }
       }
   }

}
