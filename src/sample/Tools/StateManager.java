package sample.Tools;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public static Map<String, Scene> State = new HashMap<>();

    public static Scene update(){
        switch(gameState){
            case MAINMENU:
                if(State.get("MENU") != null)
                    System.out.println("MAINMENU");
                    return State.get("MENU");

            case GAME:
                if(State.get("GAME") == null) {
                    System.out.println("NO GAME");
                    initGame();
                    return State.get("GAME");
                }
                else if(State.get("GAME") != null)
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

    public static void initStates(){
        try {
            State.put("MENU", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/meny.fxml"))));
            State.put("LEVEL", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/levelScene.fxml"))));
            State.put("HELP", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/hjelpScene.fxml"))));
            State.put("PAUSE", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/pauseScene.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void initGame(){
            try {
                final Parent gameRoot = FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/gameScene.fxml"));

                State.put("GAME", new Scene(gameRoot));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
    }

    private static void setState(GameState newState){
        gameState = newState;
    }

    public static void changeScene(Event e, GameState gameStateEnum){
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();

        StateManager.setState(gameStateEnum);
        stage.setScene(StateManager.update());

        stage.setResizable(false);
        stage.show();
    }

    public static void setGameRoot() {
        State.remove("GAME");
    }
}
