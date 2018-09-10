package sample.Entity;

import javafx.scene.shape.Rectangle;

/**
* Abstact Decorator Klassse som implementerer Enemy
 *
*/

public abstract class EnemyDecorator implements Enemy {

    /**
     *  Datafeltet består av decoratedEnemy som er av typen Enemy
     *
     */
    Enemy decoratedEnemy;

    /**
     *
      * @param decoratedEnemy
     */
    public EnemyDecorator(Enemy decoratedEnemy) {
        this.decoratedEnemy = decoratedEnemy;
    }

    /**
     * kaller render en
     */
    @Override
    public void RenderEntity(){
        decoratedEnemy.RenderEntity();
    }

}
