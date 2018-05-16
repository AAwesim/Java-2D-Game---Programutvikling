package sample.Entity;
/**
* Abstact Klassse EnemyDecorator implementerer interfacet Enemy
 *
*/

public abstract class EnemyDecorator implements Enemy {

    /**
     *
     */
    protected Enemy decoratedEnemy;

    /**
     *
      * @param decoratedEnemy
     */
    public EnemyDecorator(Enemy decoratedEnemy) {
        this.decoratedEnemy = decoratedEnemy;
    }

    /**
     *
     */
    @Override
    public void RenderEntity(){
        decoratedEnemy.RenderEntity();
    }
}
