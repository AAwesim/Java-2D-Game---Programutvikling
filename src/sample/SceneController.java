package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    @FXML public Button startButton;
    @FXML public Button hjelpButton;
    @FXML public Button exitButton;

    String gameScreen = "gameScene.fxml";
    String hjelpScreen = "hjelpScene.fxml";
    String screenCompare = "";

    public void setStartScene(ActionEvent e) throws IOException {
        String source1 = e.getSource().toString();
        String source2 = getId(source1);
        System.out.println(source2);

        if(source2 == "startButton"){
            screenCompare = "gameScene.fxml";
            System.out.println("123");
            System.out.println(screenCompare);
        }

        else if (source2 == "hjelpButton"){
            screenCompare = "hjelpScene.fxml";
            System.out.println("123");
        }

        Parent root = FXMLLoader.load(getClass().getResource(gameScreen));
        Scene startScene = new Scene(root);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(startScene);
        stage.show();
    }

    public static String getId(String a){
        char[] result = new char[11];
        char[] chars = a.toCharArray();
        int counter = 0;
        int x = 0;

        for(int i = 0 ; i < 21 ; i++){

            if(chars[i] == ','){
                x = 0;
                break;
            }

            if(x == 1){
                result[counter] = chars[i];
                counter++;
            }

            if(chars[i] == '='){
                x = 1;
            }


        }
        String b = new String(result);
        return b;
    }

    public void exitScreen(){
        System.exit(0);
    }


    /*
    public void setHelpScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gameScene.fxml"));
        Scene startScene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(startScene);
        stage.show();
    }*/
    }
