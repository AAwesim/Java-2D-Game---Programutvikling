package sample.Map;


import javafx.beans.binding.BooleanExpression;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class mapCreator{
    public  boolean tester=false;
    public  int levelWidth;
    public  String testPic = "file:ressurser\\\\testpic.jpeg";
    private int i;
    private int j;
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

    public void initMap(GraphicsContext g){
        levelWidth = LEVEL1MAP[0].length() * 24;

        for (int i = 0; i < LEVEL1MAP.length; i++) {
            String line = LEVEL1MAP[i];
            this.i= i;
            for (int j = 0; j < line.length(); j++) {
                this.j = j;
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        mapMaker(g);

                        break;
                    case '2':
                        break;
                }
            }
        }

    }
    public void mapMaker(GraphicsContext g) {
            Image img=new Image(testPic);
            Rectangle rect= new Rectangle(24, 24);
            rect.setX(j*24);
            rect.setY(i*24);
            rect.setFill(new ImagePattern(img,0,0,1,1, true));
            //g.fillRect(j*24,i*24, 24, 24);
            //g.setFill(new ImagePattern(img,0,0,1,1, true));

    }
   }

