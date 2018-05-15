package sample.Map;

import java.io.Serializable;

public class Map implements Serializable{

    private final int check = 5555;
    private String[] mapArray;

    public Map(String [] mapArray){
        this.mapArray = mapArray;
    }

    public String[] getMapArray() {
        return mapArray;
    }

    public int getCheck() {
        return check;
    }
}
