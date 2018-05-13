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
                System.out.println(StateManager.State.size());
                StateManager.setGameRoot();
                System.out.println(StateManager.State.size());
                gameController.setSetNull(true);
                System.out.println(StateManager.State);
                StateManager.changeScene(actionEvent, StateManager.GameState.MAINMENU);
        }
    }
}
