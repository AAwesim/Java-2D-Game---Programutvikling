package sample.Entity;

public class EntityCreator {

    public Entity getEntity(String type) {
        switch (type.toUpperCase()) {
            case "PLAYER":
                return new Player();
            case "ENEMY1":
                return new Enemy1();
            case "ENEMY2":
                return new Enemy2();
            case "ENEMY3":
                return new Enemy3();
            default:
                return null;
        }
    }

}
