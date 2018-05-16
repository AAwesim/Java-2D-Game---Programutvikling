package sample.Entity;

/**
 * Ved opprettelse
 * tilbyr funksjonalitet
 * for
 */

import javafx.scene.layout.Pane;

public interface Enemy {

    /**
     * Render Entity metode som blir override i decorators og EnemyCircle og EnemyRect
     */
    void RenderEntity();


}
