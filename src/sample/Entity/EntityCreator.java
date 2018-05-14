package sample.Entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class EntityCreator {

    public EnemyHandler EH = new EnemyHandler();

    public Entity getEntity(String type) {
        switch (type.toUpperCase()) {
            case "PLAYER":
                return new Player();
            default:
                return null;
        }
    }

    public Entity getEnemy(int type, double EPosX, double EPosY, Pane pe) {
        switch (type) {
            case 1:
                new Enemy1(EPosX, EPosY, pe );
            case 2:
                new Enemy2(EPosX, EPosY, pe);
            case 3:
                new Enemy3(EPosX, EPosY, pe);
            default :
                return null;
        }
    }

}