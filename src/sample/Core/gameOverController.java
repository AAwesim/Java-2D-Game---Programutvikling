package sample.Core;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import sample.Tools.StateManager;

public class gameOverController {

    public void changeScene(ActionEvent actionEvent) {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Restart":
                gameController.setSetNull(true);
                StateManager.removeGameRoot();
                StateManager.changeScene(actionEvent, StateManager.GameState.BUFFER);
                StateManager.changeScene(actionEvent, StateManager.GameState.GAME);
                break;
            case "Meny":
                gameController.setSetNull(true);
                StateManager.removeGameRoot();
                StateManager.changeScene(actionEvent, StateManager.GameState.MAINMENU);
                break;
        }
    }

}

