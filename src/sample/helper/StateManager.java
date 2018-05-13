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
        HELP,
        BUTIKK
    }

    public static GameState gameState = GameState.MAINMENU;
    static List<Scene> State = new ArrayList<>();
    public Parent menuRoot, gameRoot, helpRoot, butikkRoot;

    public StateManager(){

        try {
            this.menuRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/meny.fxml"));
            this.gameRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/gameScene.fxml"));
            this.helpRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/hjelpScene.fxml"));
            this.butikkRoot=FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/butikkScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Scene menuScene = new Scene(menuRoot);
        Scene gameScene = new Scene(gameRoot);
        Scene helpScene = new Scene(helpRoot);
        Scene butikkScene= new Scene(butikkRoot);
        State.add(menuScene);
        State.add(gameScene);
        State.add(helpScene);
        State.add(butikkScene);
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

            case BUTIKK:
                if(State.get(3) !=null)
                    return State.get(3);
        }
        return null;
    }

    public static void setState(GameState newState){
        gameState = newState;
    }

}
