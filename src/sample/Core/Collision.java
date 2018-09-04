package sample.Core;

import javafx.scene.shape.Rectangle;
import sample.Entity.EnemyCircle;
import sample.Entity.EnemyRect;
import sample.Entity.Player;
import sample.Map.mapCreator;
import sample.Tools.StateManager;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class Collision extends gameController {

    /**
        Endres til true hvis instansen av player objektet har 0 liv
     */
    private boolean PlayerDead;

    //Formålet til metoden er for å sjekke om gravity()
    //skal kjøres, derfor er Width og Height en pixel større enn metoden under.
    public boolean gravityCheck(Player p, mapCreator mc) {
        for (Rectangle mPart : mc.getMap()) {
            if (mPart.intersects(p.getX(), p.getY(), p.getWidth() + 0.5, p.getHeight() + 0.5)) {
                return true;
            }
        }
        return false;
    }

    protected void PlayerEnemyColl(Player p) {
        for (EnemyRect ERnext : mapCreator.getERMap()) {
            if (p.intersects(ERnext.getBoundsInParent())) {
                p.setHealthAmount(p.getHealthAmount() - 1);
                p.setPlayerPositionStart();
                if (p.getHealthAmount() == 0)
                    PlayerDead = true;
            }
        }
        if(PlayerDead) { sceneGameover(); }
        for (EnemyCircle ECnext : mapCreator.getECMap()) {
            if (p.intersects(ECnext.getBoundsInParent())) {
                p.setHealthAmount(p.getHealthAmount() - 1);
                p.setPlayerPositionStart();
                if (p.getHealthAmount() == 0)
                    PlayerDead = true;
            }
        }
        if(PlayerDead) { sceneGameover(); }
    }

    /**
     * Setter setNull true og running false
     * Bytter til gameoverscenen
     */
    private void sceneGameover() {
        gameController.setRunning(false);
        gameController.setSetNull(true);
        StateManager.removeGameRoot();
        StateManager.changeScene(StateManager.GameState.BUFFER);
        StateManager.changeScene(StateManager.GameState.GAMEOVER);
    }

    /**
     * Behandler kollision mellom parameterne p og mc som er instanser av player og mapCreator
     * sjekker om instansen av player intersecter noen av rectanglene i arraylisten Map i instansen av mapcreator
     * dersom p instersecter rectanglene/mPart ovenifra settes p sin posisjon 0,5 piksler over mParten
     * dersom p intersecter rectanglene/mPart neden ifra settes p sin posisjon 0,5 piksler under mParten
     * @param p
     * @param mc
     */
    public void playerCollisionY(Player p, mapCreator mc) {
        for (Rectangle mPart : mc.getMap()) {
            if (mPart.intersects(p.getPosX(), p.getPosY(), p.getWidth(), p.getHeight())) {
                // Collision Ovenifra
                if ((p.getPosY() + p.getHeight()) < (mPart.getY() + p.getMaxySpeed()) && p.getySpeed() > 0) {
                    p.setySpeed(0);
                    p.setPosY(mPart.getY() - p.getHeight() - 0.5);
                    return;
                }
                // Collision Nedenifra
                if ((p.getPosY()) > (mPart.getY() + mPart.getHeight() / 2) && p.getySpeed() < 0) {
                    p.setySpeed(0);
                    p.setPosY(mPart.getY() + mPart.getHeight() + 0.5);
                    return;
                }
            }
        }
    }

    public void PlayerCollisionX(int x, Player p, mapCreator mc) {
        int speed = x;
        for (int i = 1; i <= x; i++) {
            for (Rectangle mPart : mc.getMap()) {
                if (mPart.intersects(p.getPosX() + speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning høyre
                    if (p.KeyD) {
                        speed--;
                        p.setPosX(mPart.getX() - p.getWidth() - 1);
                    }
                }

                if (mPart.intersects(p.getPosX() - speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning venstre
                    if (p.KeyA) {
                        speed--;
                        p.setPosX(mPart.getX() + mPart.getWidth() + 1);
                    }
                }
            }
        }
        if (p.KeyD) {
            p.MoveRight(speed);
        } else if (p.KeyA) {
            p.MoveLeft(speed);
        }
    }
}
