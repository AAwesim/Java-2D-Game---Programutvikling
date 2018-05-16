package sample.Core;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Tools.ResourceManager;
import sample.Tools.StateManager;


/**
 * Controller for meny.fxml
 * @author Asim
 */
public class menyController implements Initializable {

    /**
     * Metoden kjører når menyController kjører. (På en måte som main()).
     * Den laster inn ressurser hvis arraylistene i ResourceManager er tomme.
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

    /**
     * Bytter scene basert på teksten til Button objektet som blir trykket på. Kaller på StateManager.changeScene.
     * @param e
     */

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
