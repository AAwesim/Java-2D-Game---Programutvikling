package sample.Entity;

public class EnemyMovingYDecorator extends EnemyDecorator {

    private int a;
    private int i;

    public EnemyMovingYDecorator(Enemy decoratedEnemy) {
        super(decoratedEnemy);
    }


    public void RenderEntity() {
        if (decoratedEnemy instanceof EnemyRect){
            MoveYEnemyRect((EnemyRect) decoratedEnemy);
        } else if (decoratedEnemy instanceof EnemyCircle){
            MoveYEnemyCircle((EnemyCircle) decoratedEnemy);
        }
    }

    private void MoveYEnemyRect(EnemyRect e) {
        if (e.getY() > e.getRPosY() + 200) {
            i = -2;
        }
        if (e.getY() <= e.getRPosY()) {
            i = 2;
        }
        e.setY(e.getY()+i);
    }

    private void MoveYEnemyCircle(EnemyCircle e) {
        if (e.getCenterY() > e.getCPosY() + 200) {
            i = -2;
        }
        if (e.getCenterY() <= e.getCPosY()) {
            i = 2;
        }
        e.setCenterY(e.getCenterY()+i);
    }
}







