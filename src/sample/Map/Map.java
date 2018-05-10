package sample.Map;

import java.io.Serializable;

public class Map implements Serializable{

    private static String[] mapArray;

    public static String[] getMapArray() {
        return mapArray;
    }

    public static void setMapArray(String[] mapArray) {
        Map.mapArray = mapArray;
    }
}
