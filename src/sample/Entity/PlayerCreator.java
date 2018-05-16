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
/*
    public Enemy getEnemy(int type, double CPosX, double CPosY, Pane pe) {
        switch (type) {
            case 1:
                new EnemyRect(CPosX, CPosY, pe );
           /* case 2:
                new Enemy2(CPosX, CPosY, pe);
            case 3:
                new Enemy3(CPosX, CPosY, pe);
            default :
                return null;
        }
    }

}*/