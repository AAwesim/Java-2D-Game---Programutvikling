package sample.Entity;

public class EntityCreater {

    public Entity getEntity(String type){
        if(type == null){
            return null;
        }
        else if(type.equalsIgnoreCase("PLAYER")){
            return new Player();
        }
        else if(type.equalsIgnoreCase("ENEMY")){
            return new Enemy();
        }
        return null;
    }
}
