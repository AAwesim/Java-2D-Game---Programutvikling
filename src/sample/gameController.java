package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gameController implements Initializable {

    @FXML Canvas can1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = can1.getGraphicsContext2D();

        InputStream is;
        try {
            is = new BufferedInputStream(new FileInputStream("ressurser\\mate.png"));
            Image img = new Image(is);
            gc.drawImage(img,304,224);
        } catch(FileNotFoundException fnfx){
            Logger.getLogger(gameController.class.getName()).log(Level.SEVERE, null, fnfx);
        }

        /*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*/
        final long startNanoTime = System.nanoTime();
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
            }
        };


    timer.start();

        /*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*/
    }

}
