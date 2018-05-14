package sample.Entity;

import java.util.ArrayList;

public final class EnemyHandler {

    //oppretter 2 arraylister av typen enemy
    public ArrayList<Enemy> EnemyXList = new ArrayList<>();
    public ArrayList<Enemy> EnemyYList = new ArrayList<>();

    private static final EnemyHandler eh = new EnemyHandler();

    public void renderEnemies() {
            EnemyMove('X');
            EnemyMove('Y');
    }

    //Kaller på Enemyene sin Movement metode for hver Enemy avhengig om det er enemy 1 eller 2
    public void EnemyMove(char Dir) {
        switch (Dir) {
            case 'X':
                for (int j = 0; j < getsizeEnemyXList(); j++) {
                    EnemyDecoration.getEnemy().EnemyXMovement(EnemyXList.get(j));
                }
                break;
            case 'Y':
                for (int jj = 0; jj < getsizeEnemyYList(); jj++) {
                    EnemyDecoration.getEnemy().EnemyYMovement(EnemyYList.get(jj));
                }
                break;
        }
    }

    public static EnemyHandler getEnemyHandler() {
        return eh;
    }

    public ArrayList<Enemy> getEnemyXList() {
        return EnemyXList;
    }

    public ArrayList<Enemy> getEnemyYList() {
        return EnemyYList;
    }

    public void addEnemyXList(Enemy e) {
        EnemyXList.add(e);
    }

    public void addEnemyYList(Enemy e) {
        EnemyYList.add(e);
    }

    public int getsizeEnemyYList() {
        return EnemyYList.size();
    }

    public int getsizeEnemyXList() {
        return EnemyXList.size();
    }
}
