package sample.Core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Tools.ResourceManager;
import java.net.URL;

import java.util.ResourceBundle;

public class hjelpController implements Initializable{
    @FXML
    Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Rectangle rect = new Rectangle(50,50);
        System.out.println(ResourceManager.playerSprites.size());
        pane.getChildren().add(rect);

    }


}
