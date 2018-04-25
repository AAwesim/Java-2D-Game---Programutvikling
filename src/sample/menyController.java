package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class menyController implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void setGameScene(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("gameScene.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        /* System.out.println("stage: " + stage.getWidth());
        System.out.println("scene: " + scene.getWidth());

        if(stage.getWidth()<1920) { stage.setX(1920/2 - (stage.getWidth()/2)); }
         else {  stage.setX(0);  }
        if(stage.getHeight()<1080) { stage.setY(1080/2 - (stage.getHeight()/2)); }
        else { stage.setY(0); }*/

    }

    @FXML
    private void setHjelpScene(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("hjelpScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void exit(ActionEvent e) {
        System.exit(0);
    }
}
