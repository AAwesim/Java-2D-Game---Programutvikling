package sample.Core;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import sample.Tools.StateManager;

public class menyController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void setGameScene(ActionEvent e){
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();

        /*Main.getStateManager().initGame();*/
        StateManager.setState(StateManager.GameState.LEVEL);
        stage.setScene(StateManager.update());

        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void setHjelpScene(ActionEvent e) {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();

        StateManager.setState(StateManager.GameState.HELP);
        stage.setScene(StateManager.update());

        stage.setResizable(false);
        stage.show();
    }

    public void exit(ActionEvent e) {
        System.exit(0);
    }
}
