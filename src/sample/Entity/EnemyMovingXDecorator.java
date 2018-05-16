package sample.Entity;

public class EnemyMovingXDecorator extends EnemyDecorator {

private int a;
    private int ba;
    private int i;



    public EnemyMovingXDecorator(Enemy decoratedEnemy) {
        super(decoratedEnemy);
    }


    public void RenderEntity() {
        if (decoratedEnemy instanceof EnemyRect){
            MoveXEnemyRect((EnemyRect) decoratedEnemy);
        } else if (decoratedEnemy instanceof EnemyCircle){
            MoveXEnemyCircle((EnemyCircle) decoratedEnemy);
        }
    }

    private void MoveXEnemyRect(EnemyRect e) {
        if (e.getX() > e.getRPosX() + 200) {
            i = -2;
        } else if (e.getX() <= e.getRPosX()) {
            i = 2;
        }
        e.setX(e.getX()+i);
    }

    private void MoveXEnemyCircle(EnemyCircle e) {
        if (e.getCenterX() > e.getCPosX() + 200) {
            i = -2;
        } else if (e.getCenterX() <= e.getCPosX()) {
            i = 2;
        }
        e.setCenterX(e.getCenterX()+i);
    }
}


