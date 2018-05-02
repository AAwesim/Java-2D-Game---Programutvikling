package sample.helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateManager {

    public enum GameState {
        MAINMENU,
        GAME,
        HELP,
        PAUSE
    }

    public static GameState gameState = GameState.MAINMENU;
    static Map<String, Scene> State = new HashMap<>();
    public Parent menuRoot, gameRoot, helpRoot, pauseRoot;

    public StateManager(){

        try {
            this.menuRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/meny.fxml"));
            this.helpRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/hjelpScene.fxml"));
            this.pauseRoot= FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/pauseScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        State.put("MENU",new Scene(menuRoot));
        State.put("HELP",new Scene(helpRoot));
        State.put("PAUSE",new Scene(pauseRoot));
    }

    public static Scene update(){
        switch(gameState){
            case MAINMENU:
                if(State.get("MENU") != null)
                    return State.get("MENU");

            case GAME:
                if(State.get("GAME") != null)
                    return State.get("GAME");

            case HELP:
                if(State.get("HELP") != null)
                    return State.get("HELP");
            case PAUSE:
                if(State.get("PAUSE") != null){
                    return State.get("PAUSE");
                }
        }
        return null;
    }

    public static void setState(GameState newState){
        gameState = newState;
    }

    public void initGame(){
        try{
            this.gameRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/gameScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        State.put("GAME",new Scene(gameRoot));
    }

}
