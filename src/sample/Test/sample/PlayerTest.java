package sample;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import sample.Entity.Player;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private int posX;
    private int posY;
    private Image img = null;
    private InputStream is = null;

    private Player player = new Player();

    @Test
    public void createAvatar() {

    }

    @Test
    void render() {
    }

    /*@Test
    void getImg() {
        assertEquals(img, getImg());
    }*/

    @Test
    public void getPosX() {
        assertEquals(0, player.getPosX());
    }

    @Test
    void setPosX() {
        player.setPosX(5);
        assertEquals(5,player.getPosX());
    }

    @Test
    void getPosY() {
        assertEquals(posY,player.getPosY());
    }

    @Test
    void setPosY() {
        player.setPosY(5);
        assertEquals(5,player.getPosY());
    }
}