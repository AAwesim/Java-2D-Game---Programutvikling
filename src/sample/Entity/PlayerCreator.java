package sample.Entity;

import javafx.scene.layout.Pane;

public class PlayerCreator {

    public Player getEntity(String type) {
        switch (type.toUpperCase()) {
            case "PLAYER":
                return new Player();
            default:
                return null;
        }
    }
}