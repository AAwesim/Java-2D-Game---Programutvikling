package sample.Entity;

import java.util.ArrayList;

public final class Enemyh {

    private int  a ;

    private static final Enemyh eh = new Enemyh();

    public static Enemyh getEnemyh() {
        return eh;
    }

    public void renderEnemy1() {
        for(int i = 0; i<getE1List().size(); i++) {
            E1List.get(i).EnemyMove(1);
           // E1List.get(i).setX(E1List.get(i).getEPosX());
          //  getE1List().get(i).setY(getE1List().get(i).getEPosY());
        }
    }


    public ArrayList<Enemy> E1List = new ArrayList<>();

    public ArrayList<Enemy> getE1List() {
        return E1List;
    }

    public void addE1List(Enemy e) {
        E1List.add(e);
    }


}
