package sample.Entity;

import javafx.scene.shape.Shape;

public class EntityMovingYDecorator extends EntityDecorator {

    private int a;

    private int i;



    public EntityMovingYDecorator(Entity decoratedEntity) {
        super(decoratedEntity);
    }

    @Override
    public void RenderEntity() {
        if (decoratedEntity instanceof EnemyRect){
            MoveYEnemyRect((EnemyRect)decoratedEntity);
        } else if (decoratedEntity instanceof EnemyCircle){
            MoveYEnemyCircle((EnemyCircle)decoratedEntity);
        }
    }

    private void MoveYEnemyRect(EnemyRect e) {
        a++;
        if (a%60==0)
            System.out.println("MoveYEnemyRect/2: "+ a/60);

        if (e.getY() > e.getEPosY() + 200) {
            i = -2;
        }
        if (e.getY() <= e.getEPosY()) {
            i = 2;
        }
        e.setY(e.getY()+i);
    }

    private void MoveYEnemyCircle(EnemyCircle e) {
        a++;
        if (a%60==0)
            System.out.println("MoveYEnemyCircle/2: "+ a/60);

        if (e.getCenterY() > e.getCPosY() + 200) {
            i = -2;
        }
        if (e.getCenterY() <= e.getCPosY()) {
            i = 2;
        }
        e.setCenterY(e.getCenterY()+i);
    }
}







