package sample.Core;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Tools.ResourceManager;
import sample.Tools.StateManager;


public class menyController implements Initializable {

    /**
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (ResourceManager.playerSprites.size() == 0 ||
            ResourceManager.mapTextures.size() == 0 ||
            ResourceManager.background == null) {
            System.out.println("SPRITES");
            ResourceManager.loadResources();
        } else return;
    }

    @FXML
    private void changeScene(ActionEvent e) {
        switch (((Button) e.getSource()).getText()) {
            case "Start":
                StateManager.changeScene(e, StateManager.GameState.LEVEL);
                break;

            case "Hjelp":
                StateManager.changeScene(e, StateManager.GameState.HELP);
                break;
        }
    }

    public void exit() {
        System.exit(0);
    }
}
