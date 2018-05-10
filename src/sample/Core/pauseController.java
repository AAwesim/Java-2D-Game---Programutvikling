package sample.Core;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import sample.Tools.StateManager;

public class pauseController {

    public void changeScene(ActionEvent actionEvent) {
        switch (( (Button)actionEvent.getSource()).getText() ) {
            case "Resume":
            StateManager.changeScene(actionEvent, StateManager.GameState.GAME);
            gameController.setRunning(true);
            break;
            case "Meny":
                Main.getStateManager().setGameRoot(null);
                StateManager.changeScene(actionEvent, StateManager.GameState.MAINMENU);
        }
    }
}
