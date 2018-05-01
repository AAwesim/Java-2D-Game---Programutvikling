package sample.helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateManager {

    public enum GameState {
        MAINMENU,
        GAME,
        HELP
    }

    public static GameState gameState = GameState.MAINMENU;
    static List<Scene> State = new ArrayList<>();
    public Parent menuRoot, gameRoot, helpRoot;

    public StateManager(){

        try {
            this.menuRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/meny.fxml"));
            this.gameRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/gameScene.fxml"));
            this.helpRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/hjelpScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Scene menuScene = new Scene(menuRoot);
        Scene gameScene = new Scene(gameRoot);
        Scene helpScene = new Scene(helpRoot);
        State.add(menuScene);
        State.add(gameScene);
        State.add(helpScene);
    }

    public static Scene update(){
        switch(gameState){
            case MAINMENU:
                if(State.get(0) != null)
                    return State.get(0);

            case GAME:
                if(State.get(1) != null)
                    return State.get(1);

            case HELP:
                if(State.get(2) != null)
                    return State.get(2);
        }
        return null;
    }

    public static void setState(GameState newState){
        gameState = newState;
    }

}
