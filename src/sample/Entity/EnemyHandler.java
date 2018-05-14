package sample.Entity;

import java.util.ArrayList;

public class EnemyHandler extends Enemy{

    //oppretter 2 arraylister av typen enemy
    public ArrayList<Enemy1> E1List = new ArrayList<>();
    public ArrayList<Enemy2> E2List = new ArrayList<>();

    public void renderEntity() {
            EnemyMove(1);
           // E1List.get(i).setX(E1List.get(i).getEPosX());
          //  getE1List().get(i).setY(getE1List().get(i).getEPosY());
            EnemyMove(2);
    }

    //Kaller på Enemyene sin Movement metode for hver Enemy avhengig om det er enemy 1 eller 2
    public void EnemyMove(int i) {
        switch (i) {
            case 1:
                for (int j= 0; j < getE1List().size(); j++) {
                    E1List.get(j).Enemy1Movement(E1List.get(j));
                }
                break;
            case 2:
                for (int j = 0; j < getsizeE2List(); j++) {
                    E2List.get(j).Enemy2Movement(E2List.get(j));
                }
                break;
        }
    }

    public ArrayList<Enemy1> getE1List() {
        return E1List;
    }

    public ArrayList<Enemy2> getE2List() {
        return E2List;
    }

    public void addE1List(Enemy1 e) {
        E1List.add(e);
    }

    public void addE2List(Enemy2 e) {
        E2List.add(e);
    }

    public int getsizeE2List() {
        return E2List.size();
    }

    public int getsizeE1List() {
        return E1List.size();
    }
}
