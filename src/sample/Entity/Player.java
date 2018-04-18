package sample.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.gameController;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player implements Entity {
    private int posX;
    private int posY;
    private Image img = null;
    private InputStream is = null;


    //createAvatar leser en bildefil og lagerer den i img som et Image objekt.
    @Override
    public void createAvatar() {
        try {
            is = new BufferedInputStream(new FileInputStream("ressurser\\\\testplayer.gif"));
            img = new Image(is);
        } catch (FileNotFoundException fnfx) {
            Logger.getLogger(gameController.class.getName()).log(Level.SEVERE, null, fnfx);
        }
    }

    //bruker Image objektet img som inneholder bildefilen til å tegne det til skjermen basert på objektet sine cords.
    public void render(GraphicsContext gc) {
        gc.drawImage(this.img, this.posX, this.posY);
    }

    //Getters og setters
    public Image getImg() {
        return img;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {

        this.posX += posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY += posY;
    }
}
