package sample.Core;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Tools.StateManager;
import java.net.URL;
import java.util.ResourceBundle;

public class hjelpController implements Initializable{
    @FXML
    Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Rectangle rect = new Rectangle(50,50);
        pane.getChildren().add(rect);

        pane.setFocusTraversable(true);
        pane.requestFocus();

        pane.setOnKeyPressed(e -> {
            System.out.println("HHHHHHH");
        });

    }


    public void changeScene(ActionEvent e) {
        StateManager.changeScene(e, StateManager.GameState.MAINMENU);
    }
}
