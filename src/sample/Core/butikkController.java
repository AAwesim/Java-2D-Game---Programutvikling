package sample.Core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import sample.helper.StateManager;

import java.net.URL;
import java.util.ResourceBundle;

public class butikkController implements Initializable {

    @FXML Button gun;
    @FXML Button tilbake;
    gameController gc=new gameController();
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void kjøpGun(ActionEvent e){
      
    }
    public void setTilbake(ActionEvent e){
        {
            Stage stage=(Stage) ((Node)e.getSource()).getScene().getWindow();
            StateManager.setState(StateManager.gameState.MAINMENU);
            stage.setScene(StateManager.update());
            stage.setResizable(false);
            stage.show();
        }

    }
}
