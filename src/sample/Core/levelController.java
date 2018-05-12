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
            "0000000000000000000000000000000000000033300000000000000",
            "0000000000000000000000000000000000000033300000000000000",
            "0000000000000000000000000000000000000000001111111001111",
            "0500000000000000000001111110001110000000003333333300003",
            "0000000000000000011113333333003333000000003333333003333",
            "0000000000000000033333333333300000000000000000000033333",
            "0000000000000000033333333333222222100111113333233333333",
            "0000000000000000000000000000000000000033300000000000000",
            "00000000000000000000000000000000000100033300000000000000",
            "00000000000000000000000000000000000010000001111111001111",
            "00000000000000000000040000000004000000003333333300003",
            "000000000000000000111111111100110011111133",
            "111111111111110000333333333300000033333333",
            "333333333333330000333333333322220033333333",
            "333333333333330000333222333322222233333333",
            //bredde: 69 høyde:15
    };





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getMap(ActionEvent event) throws IOException, ClassNotFoundException {
        switch(((Button) event.getSource()).getText()){
            case "1":

                if(new File("1.map").exists()) {
                    loadMap("1");

                    Main.getStateManager().initGame();
                    StateManager.changeScene(event, StateManager.GameState.GAME);
                } else generateMap();
                break;

            case "2":
                loadMap("2");

                Main.getStateManager().initGame();
                StateManager.changeScene(event, StateManager.GameState.GAME);
            break;

        }
    }

    public void generateMap(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("1.map"));
        out.writeObject(tempMap);
    }

    public void generateMap() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("1.map"));
        out.writeObject(tempMap);
    }

    public void loadMap(String s) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream((s+".map")));
        Map.setMapArray((String[]) in.readObject());
        in.close();
    }
}
