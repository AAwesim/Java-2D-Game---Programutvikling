package sample.Map;

import java.io.Serializable;

/**
 * Klassen funker som en slags blåkopi for å generere Map.
 *
 * Formål: gjøre det mulig å tolke persistente filer som blir brukt i generering av spillverden.
 */

public class Map implements Serializable{

    /**
     * Blir brukt for å sjekke om filen har blitt korrupt. I MapIO: hvis check%5555 == 0 så er ikke .map fila korrupt.
     *
     * Forbedringer: check-en funker, men det er sikkert en mer robust måte å gjøre det på, egentlig stygt å hardcode
     * slikt, men det lar seg gjøre.
     */
    private final int check = 5555;

    /**
     * Brukt i generering av spillverden i mapCreator
     */
    private String[] mapArray;

    /**
     * Konstruktøren til Map tar inn en String array.
     * @param mapArray
     */
    public Map(String [] mapArray){
        this.mapArray = mapArray;
    }

    /**
     * getters og setters
     * @return
     */

    public String[] getMapArray() {
        return mapArray;
    }

    public int getCheck() {
        return check;
    }
}
