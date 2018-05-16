package sample.Tools;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Denne klassen tar seg hånd om å laste inn ressurser ved programstart. Alle filene blir lest og lagret ved
 * programstart.
 *
 * Begrunnelse: Spillet bruker veldig små ressurser på bare noen få kilobytes, dette gjør forhåndslagring av ressurser i
 * minne veldig nyttig fordi da trenger man ikke å gjøre unødvendig mange filhåndteringer.
 *
 * Ulemper: Hvis størrelsen på ressursene er store eller hvis det er veldig mange så er det ugunstig å lagre det i minne
 * i tillegg kan det føre til at Application-Thread freezer. Det vil si at dette ikke er en skalerbar metode, men igjen
 * det funker veldig bra på et lite prosjekt som spillet vårt.
 *
 * Tilleggsinfo: ved å delegere ressurshåndtering til programstart så minskes mengden med operasjoner som blir gjort ved
 * spillstart. Dette gjør at vi ikke trenger å implementere threads for å splitte arbeidsmengden som i retur gjør at
 * programmet ikke fryser.
 *
 * @author Asim (s325912)
 */

public final class ResourceManager {
    /**
     * Arrayliste av ImagePattern, blir brukt for å style Shape-objektene vi bruker.
     */
    public static ArrayList<ImagePattern> playerSprites = new ArrayList<>();
    public static ArrayList<ImagePattern> mapTextures = new ArrayList<>();

    /**
     * Et simpel Image objekt som blir brukt som background
     *
     * Forbedrelser: Hadde vi hatt flere bakgrunner, som vi egentlig skal ha ville jeg ha implementert ArrayList<Image>.
     */
    public static Image background = new Image(ResourceManager.class
            .getClassLoader()
            .getResource("backgrounds/Hills.png")
            .toString()
            , 805
            , 525
            , false
            , true);

    /**
     * En prosedyre som fyller opp playerSprites arraylisten.
     *
     * Forbedrelser: Hadde egentlig lyst på en for-loop fra 0 til antall .png/.gif/.jpg/.jpeg, men fikk ikke tid til å
     * implementere dette.
     */
    public static void loadCharacterResources() {
            int i = 0;
            ClassLoader cldr = ResourceManager.class.getClassLoader();

            while (i <= 3) {
                URL url = cldr.getResource("character/" + i + ".png");
                System.out.println(url.toString());
                playerSprites.add(new ImagePattern(new Image(url.toString())));
                i++;
            }

            while (i <= 5) {
                URL url = cldr.getResource("character/" + i + ".gif");
                System.out.println(url.toString());
                playerSprites.add(new ImagePattern(new Image(url.toString())));
                i++;
            }
    }

    /**
     * Prosedyren gjør akkurat samme som loadCharacterResources men i en annen folder.
     *
     * Forbedrelser:
     */

    public static void loadTextureResources() {
        int i = 0;
        ClassLoader cldr = ResourceManager.class.getClassLoader();

        while (i <= 5) {
            URL url = cldr.getResource("textures/" + i + ".png");
            mapTextures.add(new ImagePattern(new Image(url.toString())));
            i++;
        }
    }

    /**
     * Prosedyren kaller bare på de to andre prosedyrene som leser ressuser og lagrer de i minne som
     * ArrayLists<ImagePattern>.
     *
     * Formål: det gjør det litt renere og lettere å lese.
     */

    public static void loadResources() {
        loadCharacterResources();
        loadTextureResources();
    }
}

