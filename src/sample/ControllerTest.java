package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTest {
    @FXML public Button startButton;
    @FXML public Button helpButton;
    @FXML public Button exitButton;

    public void setStartScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gameScene.fxml"));
        Scene startScene = new Scene(root);

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(startScene);
        stage.show();
    }
}
