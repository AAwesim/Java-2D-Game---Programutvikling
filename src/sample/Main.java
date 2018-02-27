package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public final static  double SCREEN_WIDTH = 640.0;
    public final static  double SCREEN_HEIGHT = 480.0;
    public final static String GAME_NAME = "Tiyareed";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("meny.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle(GAME_NAME);
        primaryStage.setScene(new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
