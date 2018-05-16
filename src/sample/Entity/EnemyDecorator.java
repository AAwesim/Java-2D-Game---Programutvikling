package sample.Entity;
/**
* Decorates Entities
*/

public abstract class EnemyDecorator implements Enemy {

    protected Enemy decoratedEnemy;

    public EnemyDecorator(Enemy decoratedEnemy) {
        this.decoratedEnemy = decoratedEnemy;
    }

    public void RenderEntity(){
        decoratedEnemy.RenderEntity();
    }
}
