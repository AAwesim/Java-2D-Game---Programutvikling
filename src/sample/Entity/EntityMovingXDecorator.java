package sample.Entity;

public class EntityMovingXDecorator extends EntityDecorator {

private int a;
    private int ba;
    private int i;



    public EntityMovingXDecorator(Entity decoratedEntity) {
        super(decoratedEntity);
    }


    public void RenderEntity() {
        if (decoratedEntity instanceof EnemyRect){
            MoveXEnemyRect((EnemyRect)decoratedEntity);
        } else if (decoratedEntity instanceof EnemyCircle){
            MoveXEnemyCircle((EnemyCircle)decoratedEntity);
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


