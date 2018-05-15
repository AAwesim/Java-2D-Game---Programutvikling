package sample.Map;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MapIO {
    private String levelID;
    private String[] mapArray;

    public MapIO(String levelID) {
        this.levelID = levelID;
        mapLoader();
    }

    public void mapLoader() {
        try (InputStream is = MapIO.class.getClassLoader().getResourceAsStream("maps/" + this.levelID + ".map")) {
            ObjectInputStream in = new ObjectInputStream(is);
            if (in != null) {
                Map m = (Map) in.readObject();
                this.mapArray = m.getMapArray();
                System.out.println(m.getCheck());
                if (m != null) System.out.println("MAP IS NOT NULL");
                if (m == null) System.out.println("MAP IS NULL");
            } else {
                System.out.println("WRONG MAP, THIS IS DEFAULT");
                this.mapArray = new String[]{
                        "000000000000333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
                        "000000000000333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
                        "0000000000003333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
                        "00000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000",
                        "060044400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                        "0600000000000000000000000000000000000050000000000005000000000000500000000000050000000000005000000",
                        "060000000000000050000000000000000000111111111111111111111111111111111111111111111111111111111111",
                        "00000000000011111111111001100111111133333333333333333333333333333333333333333333333333333333333",
                        "111111111000333333333330000003333333333333333333333333333333333333333333333333333333333333333333",
                        "333333333000333333333332222223333333333333333333333333333333333333333333333333333333333333333333",
                        "333333333000333333333332222223333333333333333333333333333333333333333333333333333333333333333333",
                        //bredde: 69 høyde:15
                };
            }

            is.close();
            in.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("File not found");
            System.exit(2);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(2);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.exit(3);
        } catch (ClassCastException cce) {
            cce.printStackTrace();
            System.out.println("Could not cast to class");
            System.exit(4);
        }
    }

    public String[] getMapArray() {
        return mapArray;
    }
}