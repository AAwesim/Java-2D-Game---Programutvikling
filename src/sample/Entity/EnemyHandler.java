package sample.Entity;

import java.util.ArrayList;

public final class EnemyHandler {

    //oppretter 2 arraylister av typen enemy
    public ArrayList<Enemy> E1List = new ArrayList<>();
    public ArrayList<Enemy> E2List = new ArrayList<>();

    private static final EnemyHandler eh = new EnemyHandler();

    public void renderEnemies() {
            EnemyMove(1);
           // E1List.get(i).setX(E1List.get(i).getEPosX());
          //  getE1List().get(i).setY(getE1List().get(i).getEPosY());
            EnemyMove(2);
    }

    //Kaller på Enemyene sin Movement metode for hver Enemy avhengig om det er enemy 1 eller 2
    public void EnemyMove(int i) {
        switch (i) {
            case 1:
                for (int j = 0; j < getE1List().size(); j++) {
                    EnemyDecoration.getEnemy().EnemyXMovement(E1List.get(j));
                }
                break;
            case 2:
                for (int jj = 0; jj < getsizeE2List(); jj++) {
                    EnemyDecoration.getEnemy().EnemyYMovement(E2List.get(jj));
                }
                break;
        }
    }

    public static EnemyHandler getEnemyh() {
        return eh;
    }

    public ArrayList<Enemy> getE1List() {
        return E1List;
    }

    public ArrayList<Enemy> getE2List() {
        return E2List;
    }

    public void addE1List(Enemy e) {
        E1List.add(e);
    }

    public void addE2List(Enemy e) {
        E2List.add(e);
    }
    public int getsizeE2List() {
        return E2List.size();
    }

    public int getsizeE1List() {
        return E1List.size();
    }
}
