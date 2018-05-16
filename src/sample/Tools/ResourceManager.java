package sample.Tools;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.net.URL;
import java.util.ArrayList;

/**
 * Denne klassen tar seg hånd om å laste inn ressurser ved programstart. Alle filene blir lest og lagret ved
 * programstart.
 */

public final class ResourceManager {

    public static ArrayList<ImagePattern> playerSprites = new ArrayList<>();
    public static ArrayList<ImagePattern> mapTextures = new ArrayList<>();
    public static Image background = new Image(ResourceManager.class.getClassLoader().getResource("backgrounds/Hills.png").toString(),805, 525, false, true);

    public static void loadCharacterResources() {
        int i = 0;
        ClassLoader cldr = ResourceManager.class.getClassLoader();

        while (i <= 3) {
            URL url = cldr.getResource("character/" + i + ".png");
            System.out.println(url.toString());
            playerSprites.add(new ImagePattern(new Image(url.toString())));
            i++;
        }

        while (i <= 5) {
            URL url = cldr.getResource("character/" + i + ".gif");
            System.out.println(url.toString());
            playerSprites.add(new ImagePattern(new Image(url.toString())));
            i++;
        }
    }

    public static void loadTextureResources() {
        int i = 0;
        ClassLoader cldr = ResourceManager.class.getClassLoader();

        while (i <= 5) {
            URL url = cldr.getResource("textures/"+ i +".png");
            mapTextures.add(new ImagePattern(new Image(url.toString())));
            i++;
        }
    }

    public static void loadResources(){
        loadCharacterResources();
        loadTextureResources();
    }
}

