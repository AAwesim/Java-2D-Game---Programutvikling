package sample.Core;

import javafx.scene.shape.Rectangle;
import sample.Entity.Player;
import sample.Map.mapCreator;

import java.util.ArrayList;

public class Collision {

    //Vet ikke lenger, men tror det eneste formålet til metoden er for å sjekke om gravity()
    //skal kjøres, derfor er Width og Height en pixel større enn metoden under.
    public boolean gravityCheck(Player p, mapCreator mc) {
      //  System.out.println("Map "+mc.getMap());
        for (Rectangle mapPart : mc.getMap()) {
            if (mapPart.intersects(p.getX(), p.getY(), p.getWidth() + 0.5, p.getHeight() + 0.5)) {
                return true;
            }
        }
        return false;
    }

    //kan forbedres ved å adde en for loop her, metoden må da ta inn en parameter som tilsvarer
    //xspeed. Antall iterasjoner i for løkken avhenger av denne parameteren med mer
    //dette kan gjøre at vi kan skjekke collision for hver piksel
    //TODO
    public void playerCollisionY(Player p, mapCreator mc) {
        for (Rectangle mapPart : mc.getMap()) {
            if (mapPart.intersects(p.getPosX(), p.getPosY(), p.getWidth(), p.getHeight())) {
                // Collision Ovenifra
                if ((p.getPosY() + p.getHeight()) < (mapPart.getY() + p.getMaxySpeed()) && p.getySpeed() > 0) {
                    p.setySpeed(0);
                    p.setPosY(mapPart.getY() - p.getHeight() - 0.5);
                    return;
                }
                // Collision Nedenifra
                if ((p.getPosY()) > (mapPart.getY() + mapPart.getHeight() / 2) && p.getySpeed() < 0) {
                    p.setySpeed(0);
                    p.setPosY(mapPart.getY() + mapPart.getHeight() + 0.5);
                    return;
                }
            }
        }
    }

    public void PlayerCollisionX(int x, Player p, mapCreator mc) {
        int speed = 4;
        for (int i = 1; i <= x; i++) {
            for (Rectangle mapPart : mc.getMap()) {
                if (mapPart.intersects(p.getPosX() + speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning høyre
                    if (p.KeyD) {
                        speed--;
                        p.setPosX(mapPart.getX() - p.getWidth() - 1);
                    }
                }

                if (mapPart.intersects(p.getPosX() - speed, p.getPosY(), p.getWidth(), p.getHeight())) {
                    // Bevegelseretning venstre
                    if (p.KeyA) {
                        speed--;
                        p.setPosX(mapPart.getX() + mapPart.getWidth() + 1);
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
