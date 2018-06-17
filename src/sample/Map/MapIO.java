package sample.Map;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Denne klassen leser en .map fil fra det persistente minnet og lager et objekt av typen Map ut ifra bytedata-en som er
 * i .map filene. Map objektet som blir deserialized inneholder en String array som blir brukt i mapCreator sin initMap.
 *
 * Formålet: deserializer Map objekt fra .map filer som er persistente. Dette gjør verdengenerering mer fleksibelt, og
 * det eventuelt gjør det mulig å lage leveleditor, men så langt kom vi ikke.
 *
 * @author Asim
 */
public class MapIO {
    /**
     * levelID blir brukt for å hente riktig .map fil
     */
    private String levelID;

    /**
     * mapArray blir brukt for å initiere riktig map i mapCreator.
     */
    private String[] mapArray;

    /**
     * defaultMapArray blir brukt istedet .map filen sin array hvis klassen Map ikke finnes i .jar fila, eller hvis
     * .map filen sin checksum ikke stemmer (korrupt), hvis
     * 4 = large vertically moving rectangle shaped enemy
     * 5 = large horizontally moving rectangle shaped enemy
     *
     */
    private String[] defaultMapArray = this.mapArray = new String[]{
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
            "0000000000003333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
            "00000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "000044400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "0000000000000000000000000000000000000050000000000005000000000000500000000000050000000000005000000",
            "000000000000000050000000000000000000111111111111111111111111111111111111111111111111111111111111",
            "00000000000011111111111001100111111133333333333333333333333333333333333333333333333333333333333",
            "111111111000333333333330000003333333333333333333333333333333333333333333333333333333333333333333",
            "333333333000333333333332222223333333333333333333333333333333333333333333333333333333333333333333",
            "333333333000333333333332222223333333333333333333333333333333333333333333333333333333333333333333",
            //bredde: 69 høyde:15
    };

    /**
     * Konstruktøren tar inn en String variabel som blir brukt for å finne riktig .map fil. Tilleggsvis blir mapLoader
     * kalt.
     * @param levelID
     */
    public MapIO(String levelID) {
        this.levelID = levelID;
        mapLoader();
    }

    /**
     * Metoden mapLoader blir brukt for å lese, deserialize og/eller hvis alt IO failer eller Map ikke blir laget så
     * blir mapArray til satt til en default array. (En slags failsafe).
     */
    public void mapLoader() {
        try (InputStream is = MapIO.class.getClassLoader().getResourceAsStream("maps/" + this.levelID + ".map")) {
            ObjectInputStream in = new ObjectInputStream(is);
            if (in != null) {
                Map m = (Map) in.readObject();
                if(m.getCheck()%5 == 0) this.mapArray = m.getMapArray();
                    else this.mapArray = defaultMapArray;
            } else {
                System.out.println("WRONG MAP, THIS IS DEFAULT");
                this.mapArray = defaultMapArray;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            this.mapArray = defaultMapArray;
            System.out.println("File not found");
            System.exit(2);
        } catch (IOException ioe) {
            this.mapArray = defaultMapArray;
            ioe.printStackTrace();
            System.exit(2);
        } catch (ClassNotFoundException cnfe) {
            this.mapArray = defaultMapArray;
            cnfe.printStackTrace();
            System.exit(3);
        } catch (ClassCastException cce) {
            this.mapArray = defaultMapArray;
            cce.printStackTrace();
            System.out.println("Could not cast to class");
            System.exit(4);
        }
    }

    /**
     * getter for å trekke ut String array fra det deserialize Map-objektet.
     * @return
     */
    public String[] getMapArray() {
        return mapArray;
    }
}