package sample.Tools;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.net.URL;
import java.util.ArrayList;

public class ResourceManager {

    public static ArrayList<ImagePattern> playerSprites = new ArrayList<>();
    public static ArrayList<ImagePattern> mapTextures = new ArrayList<>();

    public static void loadResources() {
        int i = 0;
        int j = 4;

        URL url = ResourceManager.class.getClassLoader().getResource("character//" + i + ".png");
        URL url2 = ResourceManager.class.getClassLoader().getResource("character//" + j + ".gif");

        while (i <= 3) {
            playerSprites.add(new ImagePattern(new Image(url.toString())));
            i++;
        }

        while (j <= 5) {
            playerSprites.add(new ImagePattern(new Image(url2.toString())));
            j++;

        }

    }
}

