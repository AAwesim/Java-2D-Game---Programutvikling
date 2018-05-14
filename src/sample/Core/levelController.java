package sample.Core;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Map.Map;
import sample.Tools.StateManager;

import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class levelController implements Initializable{

    /*MIDDLERTIDIG: Hvis dere vil endre på mappet må dere endre her også trykke på generate map.*/
    public final static String[] tempMap = new String[] {
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
            "0600000000603333333333333333333333333333333333333333333333333333333333333333333333333333333333333",
            "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "00405040504000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "0040504050400005000000000000000000000111111111111111111111111111111111111111111111111111111111111",
            "000000000000011111111111001100111111133333333333333333333333333333333333333333333333333333333333",
            "111111111000333333333330000003333333333333333333333333333333333333333333333333333333333333333333",
            "333333333000333333333332222223333333333333333333333333333333333333333333333333333333333333333333",
            "333333333000333333333332222223333333333333333333333333333333333333333333333333333333333333333333",
            //bredde: 69 høyde:15
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getMap(ActionEvent event) throws IOException, ClassNotFoundException {
        switch(((Button) event.getSource()).getText()){
            
            case "1":
                    loadMap("1");

                    StateManager.changeScene(event, StateManager.GameState.GAME);
                break;

            case "2":
                loadMap("2");

                StateManager.changeScene(event, StateManager.GameState.GAME);
            break;

        }
    }

    public void generateMap(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ressurser/maps/2.map"));
        out.writeObject(tempMap);
        out.close();
    }

    public void generateMap() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ressurser/maps/2.map"));
        out.writeObject(tempMap);
        out.close();
    }

    public void loadMap(String s) throws IOException, ClassNotFoundException {
        InputStream is = levelController.class.getClassLoader().getResourceAsStream("maps/"+s+".map");
        System.out.println(is.toString());
        ObjectInputStream in = new ObjectInputStream(is);
        Map.setMapArray((String[]) in.readObject());
        is.close();
        in.close();
    }
}
