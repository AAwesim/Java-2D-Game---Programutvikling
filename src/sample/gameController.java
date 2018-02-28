package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.w3c.dom.events.Event;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gameController implements Initializable, EventHandler<KeyEvent> {

    @FXML Canvas can1;

    public double posX = 304;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = can1.getGraphicsContext2D();




        /*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*/
        final long startNanoTime = System.nanoTime();
        
        InputStream is;
        Image img;
        try {
            is = new BufferedInputStream(new FileInputStream("ressurser\\\\mate.png"));
            img = new Image(is);
            gc.drawImage(img,posX,224);

        } catch(FileNotFoundException fnfx){
            Logger.getLogger(gameController.class.getName()).log(Level.SEVERE, null, fnfx);
        }

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

            }
        };

        timer.start();
        /*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*//*ANIMASJON*/

    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.SPACE){
            posX+=10.0;
            System.out.println(keyEvent.toString());
        }
    }

}
