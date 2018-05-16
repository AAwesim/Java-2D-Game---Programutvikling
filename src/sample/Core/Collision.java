package sample.Core;

import javafx.scene.shape.Rectangle;
import sample.Entity.EnemyCircle;
import sample.Entity.EnemyRect;
import sample.Entity.Player;
import sample.Map.mapCreator;
import sample.Tools.StateManager;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class Collision {

    //Vet ikke lenger, men tror det eneste formålet til metoden er for å sjekke om gravity()
    //skal kjøres, derfor er Width og Height en pixel større enn metoden under.
    public boolean gravityCheck(Player p, mapCreator mc) {
        for (Rectangle mPart : mc.getMap()) {
            if (mPart.intersects(p.getX(), p.getY(), p.getWidth() + 0.5, p.getHeight() + 0.5)) {
                return true;
            }
        }
        return false;
    }

    public void PlayerEnemyColl(Player p) {
        for(Iterator<EnemyRect> itER = mapCreator.getERMap().iterator(); itER.hasNext();) {
            try {
                EnemyRect ER = itER.next();
                if (p.intersects(ER.getBoundsInParent())) {
                    p.setPosX(90);
                    p.setPosY(260);
                    gameController.setRunning(false);
                    gameController.setSetNull(true);
                    StateManager.removeGameRoot();
                    StateManager.changeScene(StateManager.GameState.BUFFER);
                    StateManager.changeScene(StateManager.GameState.GAMEOVER);
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("ConcurrentModificationException e at Collision PlayerEnemyColl");
                return;
            }
        }

        for (Iterator<EnemyCircle> itEC = mapCreator.getECMap().iterator(); itEC.hasNext();) {
            try {
                EnemyCircle EC = itEC.next();
                if (p.intersects(EC.getBoundsInParent())) {
                    gameController.setRunning(false);
                    gameController.setSetNull(true);
                    StateManager.removeGameRoot();
                    StateManager.changeScene(StateManager.GameState.BUFFER);
                    StateManager.changeScene(StateManager.GameState.GAMEOVER);
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("ConcurrentModificationException e at Collision PlayerEnemyColl");
                return;
            }
              /* p.setHealthAmount(p.getHealthAmount() - 1);
                ().setText(Integer.toString(p.getHealthAmount()));*/
        }
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
        int speed = 4;
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
