package sample.Entity;

public class EntityMovingXDecorator extends EntityDecorator {

private int a;

    private int i;



    public EntityMovingXDecorator(Entity decoratedEntity) {
        super(decoratedEntity);
    }

    @Override
    public void RenderEntity() {
        if (decoratedEntity instanceof EnemyRect){
            MoveXEnemyRect((EnemyRect)decoratedEntity);
        } else if (decoratedEntity instanceof EnemyCircle){
            MoveXEnemyCircle((EnemyCircle)decoratedEntity);
        }
    }

    private void MoveXEnemyRect(EnemyRect e) {
        a++;
        if (a%60==0)
        System.out.println("MoveXEnemyRect/2: "+ a/60);

        if (e.getX() > e.getRPosX() + 200) {
            i = -2;
        }
        if (e.getX() <= e.getRPosX()) {
            i = 2;
        }
        e.setX(e.getX()+i);
    }
    private void MoveXEnemyCircle(EnemyCircle e) {
        a++;
        if (a%60==0)
            System.out.println("MoveXEnemyCircle/2: "+ a/60);

        if (e.getCenterX() > e.getCPosX() + 200) {
            i = -2;
        }
        if (e.getCenterX() <= e.getCPosX()) {
            i = 2;
        }
        e.setCenterX(e.getCenterX()+i);
    }
}


