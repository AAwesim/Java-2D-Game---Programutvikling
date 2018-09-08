package sample.Entity;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class EntityCreator {

    public Player getEntity(String type) {
        switch (type.toUpperCase()) {
            case "PLAYER":
                return new Player();
            default:
                return null;
        }
    }

    public Enemy getEnemy(int type, double EPosX, double EPosY, Pane pe) {
        switch (type) {
            case 1:
                return new Enemy(type,EPosX, EPosY, pe );
            case 2:
                return new Enemy(type,EPosX, EPosY, pe);
            case 3:
                return new Enemy(type, EPosX,EPosY,pe);
            default :
                return null;
        }
    }
}