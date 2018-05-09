package sample.Tools;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StateManager {

    public enum GameState {
        MAINMENU,
        GAME,
        LEVEL,
        HELP,
        PAUSE
    }

    private static GameState gameState = GameState.MAINMENU;
    static Map<String, Scene> State = new HashMap<>();
    private Parent menuRoot, gameRoot, levelRoot, helpRoot, pauseRoot;

    public StateManager(){

        try {
            this.menuRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/meny.fxml"));
            this.levelRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/levelScene.fxml"));
            this.helpRoot = FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/hjelpScene.fxml"));
            this.pauseRoot= FXMLLoader.load(getClass().getClassLoader().getResource("sample/FXML/pauseScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        State.put("MENU", new Scene(menuRoot));
        State.put("LEVEL", new Scene(levelRoot));
        State.put("HELP", new Scene(helpRoot));
        State.put("PAUSE", new Scene(pauseRoot));
    }

    public static Scene update(){
        switch(gameState){
            case MAINMENU:
                if(State.get("MENU") != null)
                    System.out.println("MAINMENU");
                    return State.get("MENU");

            case GAME:
                if(State.get("GAME") != null)
                    System.out.println("GAME");
                    return State.get("GAME");
            case LEVEL:
                if(State.get("LEVEL") != null){
                    System.out.println("LEVEL");
                    return State.get("LEVEL");
                }

            case HELP:
                if(State.get("HELP") != null)
                    System.out.println("HELP");
                    return State.get("HELP");
            case PAUSE:
                if(State.get("PAUSE") != null){
                    System.out.println("PAUSE");
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

    public static void changeScene(Event e, GameState gameStateEnum){
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();

        StateManager.setState(gameStateEnum);
        stage.setScene(StateManager.update());

        stage.setResizable(false);
        stage.show();
    }

}
