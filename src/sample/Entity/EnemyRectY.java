package sample.Entity;

import sample.Map.mapCreator;

public class EnemyRectY extends EnemyDecorator {

    /**
     * kaller på konstrukerør i parent klaassen EnemyDocrator
     * @param decoratedEnemy
     */
    public EnemyRectY(Enemy decoratedEnemy) {
        super(decoratedEnemy);
    }

    private static int i;

    /**
     * kjøres dersom enemy har denne decoratoren. kaller derfor på supermetoden for å kjøre metodene i
     * de andre decoratorene.
     */
    @Override
    public void RenderEntity() {
        super.RenderEntity();
    }

    /**
     * samme som MoveYEnemyRect bare langs X-aksen
     * @param e
     */
    public static void MoveYEnemyRect(EnemyRect e) {
        if (e.getY() > e.getRPosY() + 200) {
            i = -2;
        }
        if (e.getY() <= e.getRPosY()) {
            i = 2;
        }
        e.setY(e.getY()+i);
    }
}
