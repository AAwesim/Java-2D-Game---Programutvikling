package sample.Entity;

/**
 * EnemyMovingXDecorator
 * extender EnemyDecorator og tilbyr funksjonalitet for å automatisk animere Enemies Som beveger seg
 * langs X-aksen
 * NB! Kan IKKE brukes i kombinasjon med alle andre decorators feks EnemyYMovementDecorator
 */

public class EnemyMovingXDecorator extends EnemyDecorator {

    /**
     * datafeltet i klassen består av int i som brukes i MoveXEnemyRect/Circle metodene
     */
    private int i;

    /**
     * kaller på konstrukerør i parent klaassen EnemyDocrator
     * @param decoratedEnemy
     */
    public EnemyMovingXDecorator(Enemy decoratedEnemy) {
        super(decoratedEnemy);
    }

    /**
     * ovverrides metod renderentity i enemydecorator
     * sjekker om decoratedEnemy er en instanse av enemyRect eller EnemyCircle ved kjøretid
     * og avhengig av dette castes decoratedEnemy til EnemyRect eller EnemyCircle og en av metodene MoveXEnemyRect og MoveXnememyCircle
     * kjøres
     */
    @Override
    public void RenderEntity() {
        if (decoratedEnemy instanceof EnemyRect){
            MoveXEnemyRect((EnemyRect) decoratedEnemy);
        } else if (decoratedEnemy instanceof EnemyCircle){
            MoveXEnemyCircle((EnemyCircle) decoratedEnemy);
        }
    }

    /**
     * samme som MoveYEnemyRect bare langs X-aksen
     * @param e
     */
    private void MoveXEnemyRect(EnemyRect e) {
        if (e.getX() > e.getRPosX() + 500) {
            i = -5;
        } else if (e.getX() <= e.getRPosX()) {
            i = 5;
        }
        e.setX(e.getX()+i);
    }

    /**
     * samme som MoveYEnemyCircle bare langs X-aksen
     * @param e
     */
    private void MoveXEnemyCircle(EnemyCircle e) {
        if (e.getCenterX() > e.getCPosX() + 200) {
            i = -2;
        } else if (e.getCenterX() <= e.getCPosX()) {
            i = 2;
        }
        e.setCenterX(e.getCenterX()+i);
    }
}


