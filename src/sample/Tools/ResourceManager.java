package sample.Tools;

import javafx.scene.paint.ImagePattern;

import java.net.URL;
import java.util.ArrayList;

public class ResourceManager {

    public static ArrayList<ImagePattern> playerSprites = new ArrayList<>();
    public static ArrayList<ImagePattern> mapTextures = new ArrayList<>();

    public static void loadResources(){
        ClassLoader cldr = ResourceManager.class.getClassLoader();
        URL url = cldr.getResource("/ressurser/");


    }

}
