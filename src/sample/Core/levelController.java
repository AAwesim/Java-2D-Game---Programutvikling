package sample.Core;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Map.Map;
import sample.Tools.StateManager;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class levelController implements Initializable{

    /*MIDDLERTIDIG: Hvis dere vil endre på mappet må dere endre her også trykke på generate map.*/
    public final static String[] tempMap = new String[] {
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000000000000000000000000001110000000000000000000000000000",
            "000000000000000111000000000000000000011110000000000000000000000000111",
            "000111000000001000100000001100011100001110000000000000010000001111100",
            "000000000000000000000011111100011100000000000000000001110011000000000",
            "000000000000110000011111111100011100000000000001101101110000000000000",
            "111111100111110000011111111100011100000000001101101101110000000000000",
            "111111100111112222211111111122211101101101100001101101111111111111111"
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
                    initLevelState(event);
                } else generateMap();
                break;
            case "2":
                loadMap("2");
                initLevelState(event);
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

    public void initLevelState(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Main.getStateManager().initGame();
        StateManager.setState(StateManager.GameState.GAME);
        stage.setScene(StateManager.update());

        stage.setResizable(false);
        stage.show();
    }
}
