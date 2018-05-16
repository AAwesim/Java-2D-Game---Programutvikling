package sample.Entity;

/**
 * EnemyMovingYDecorator
 * extender EnemyDecorator og tilbyr funksjonalitet for å automatisk animere Enemies Som beveger seg
 * langs Y-aksen
 */

public class EnemyMovingYDecorator extends EnemyDecorator {

    private int a;
    private int i;

    public EnemyMovingYDecorator(Enemy decoratedEnemy) {
        super(decoratedEnemy);
    }

    /**
     * ovverrides metod renderentity i enemydecorator
     * sjekker om decoratedEnemy er en instanse av enemyRect eller EnemyCircle ved kjøretid
     * og avhengig av dette castes decoratedEnemy til EnemyRect eller EnemyCircle og en av metodene MoveYEnemyRect og MoveYnememyCircle
     * kjøres
     */
    @Override
    public void RenderEntity() {
        if (decoratedEnemy instanceof EnemyRect){
            MoveYEnemyRect((EnemyRect) decoratedEnemy);
        } else if (decoratedEnemy instanceof EnemyCircle){
            MoveYEnemyCircle((EnemyCircle) decoratedEnemy);
        }
    }

    /**
     * parameter e er av typen EnemyRect. metoden gjør at e flyttes fram og tilbake langs Y aksen over et område på 200 piskler.
     * @param e
     */
    private void MoveYEnemyRect(EnemyRect e) {
        if (e.getY() > e.getRPosY() + 200) {
            i = -2;
        }
        if (e.getY() <= e.getRPosY()) {
            i = 2;
        }
        e.setY(e.getY()+i);
    }

    /**
     * parameter e er av typen EnemyCircle. Metoden gjør at e flyttes fram og tilbake langs Y aksen over et område på 200 piskler.
     * @param e
     */
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







