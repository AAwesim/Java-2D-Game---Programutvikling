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
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333",
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333",
            "000000000000333333333333333333333333333333333333333333333333333333333333333333333",
            "000000000000004440000000000000600600040000040000400000400500000000000000000000000",
            "000000000000000000000000000000000000000000000000000000000000500000000000000000000",
            "000000000000000000000000000000000005000000000050000000000000000500005000000000000",
            "000000000000000000000008800000000001111111111111111111111111111111111111111111111",
            "000000000000111111111110011001111111333333333333333333333333333333333333333333333",
            "111111111000333333333330000003333333333333333333333333333333333333333333333333333",
            "333333333000333333333332222223333333333333333333333333333333333333333333333333333",
            "333333333000333333333332222223333333333333333333333333333333333333333333333333333",
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
        try (FileOutputStream fos = new FileOutputStream("ressurser/maps/2.map")) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            Map m = new Map(tempMap);
            out.writeObject(m);
            out.flush();
        }
    }

    public void generateMap() {
        try (FileOutputStream fos = new FileOutputStream("ressurser/maps/2.map")) {
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
