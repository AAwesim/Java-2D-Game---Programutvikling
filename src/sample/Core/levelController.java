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
            "0000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "0000000000000000000000000000000000000000000000000000000000000000000000000000000",
            "0000000000000000000000000000000000000000000000000000000000000000000000000000002",
            "0000000000000000000000000000000000000000000000000000000000000000000000000000111",
            "0000000000000000000000000000000000000000000000000000000000000011100001110000000",
            "0000000000000000000000000000000000000000000000000000000011100000000000000000000",
            "0000000000000000001111111100011111111100000000000001110000000000000000000000000",
            "0000000000000000013333333300033333333310000000000010000000000000000000000000000",
            "1111111100111111133333333300033333333331110111111000000000000000000000000000000",
            "3333333300333333333333333300033333333333330333333000000000000000000000000000000",
            "3333333300333333333333333300033333333333330333333000000000000000000000000000000",
            //bredde: 69 høyde:15
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getMap(ActionEvent event) {
        String s = ((Button) event.getSource()).getText();
        StateManager.LEVEL = s;
        System.out.println(StateManager.LEVEL);
        StateManager.changeScene(event, StateManager.GameState.GAME);
    }

    public void generateMap(ActionEvent actionEvent) throws IOException {
        actionEvent.toString();
        try (FileOutputStream fos = new FileOutputStream("ressurser/maps/"+StateManager.LEVEL+".map")) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            Map m = new Map(tempMap);
            out.writeObject(m);
            out.flush();
        }
    }

    public void generateMap() {
        try (FileOutputStream fos = new FileOutputStream("ressurser/maps/"+StateManager.LEVEL+".map")) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            Map m = new Map(tempMap);
            out.writeObject(m);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    public void loadMap(String s) {
        InputStream is = levelController.class.getClassLoader().getResourceAsStream("maps/"+s+".map");
        System.out.println(is.toString());
        ObjectInputStream in = new ObjectInputStream(is);
        Map.setMapArray((String[]) in.readObject());
        is.close();
        in.close();
    }*/
}
