package sample.Tools;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Denne klassen eksisterer for å endre scenegrafen til applikasjonen. Den behandler .fxml filene og laster dem inn i en
 * hashmap som Scene objekt. Formålet med dette er å lagre scenes i minne og ganske enkelt bytte til en vilkårlig scene.
 *
 * Begrunnelse: Det ga god mening å holde styr på alle scenes som blir tatt bruk av i javafx-applikasjonen. Fordi man
 * kan
 */
public final class StateManager {

    /**
     * Den statiske variablen blir brukt for å holde styr på hvilket level brukeren vil spille. Det gir mening å ha noe
     * som holder
     */
    public static String LEVEL;

    static Stage stage;

    public enum GameState {
        BUFFER,
        MAINMENU,
        LEVEL,
        HELP,
        PAUSE,
        GAMEOVER,
        GAME
    }

    private static GameState gameState = GameState.MAINMENU;

    public static Map<String, Scene> State = new HashMap<>();

    public static Scene update(){
        switch(gameState){
            case BUFFER:
                if(State.get("HELP") != null)
                    return State.get("BUFFER");

                    case HELP:
                if(State.get("HELP") != null)
                    System.out.println("HELP");
                return State.get("HELP");

            case MAINMENU:
                if(State.get("MENU") != null)
                    System.out.println("MAINMENU");
                    return State.get("MENU");

            case LEVEL:
                if(State.get("LEVEL") != null){
                    System.out.println("LEVEL");
                    return State.get("LEVEL");
                }

            case PAUSE:
                if(State.get("PAUSE") != null){
                    System.out.println("PAUSE");
                    return State.get("PAUSE");
                }

            case GAMEOVER:
                if(State.get("GAMEOVER") != null){
                    System.out.println("GAMEOVER");
                    return State.get("GAMEOVER");
                }

            case GAME:
                if(State.get("GAME") == null) {
                    System.out.println("NO GAME");
                    initGame();
                    return State.get("GAME");
                }
                else if(State.get("GAME") != null)
                    System.out.println("GAME");
                    return State.get("GAME");
        }
        return null;
    }

    /**
     * Denne prosedyren er en av kjernedelene til denne klassen.
     * Formålet med prosedyren er å hente lagre Scenes inn i
     * Den blir kalt en gang i Main.main().
     */
    public static void initStates(){
        try {
            State.put("BUFFER", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/buffer.fxml"))));
            State.put("MENU", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/meny.fxml"))));
            State.put("LEVEL", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/levelScene.fxml"))));
            State.put("HELP", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/hjelpScene.fxml"))));
            State.put("PAUSE", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/pauseScene.fxml"))));
            State.put("GAMEOVER", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/gameOVer.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void initGame(){
            try {
                State.put("GAME", new Scene(FXMLLoader.load(StateManager.class.getClassLoader().getResource("sample/FXML/gameScene.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
    }

    private static void setState(GameState newState){
        gameState = newState;
    }

    public static void changeScene(Event e, GameState gameStateEnum){
        if(stage == null){
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        }
        StateManager.setState(gameStateEnum);
        stage.setScene(StateManager.update());
        stage.setResizable(false);
        stage.show();
    }

    public static void changeScene(GameState gameStateEnum){
        StateManager.setState(gameStateEnum);
        stage.setScene(StateManager.update());
        stage.setResizable(false);
        stage.show();
    }

    public static void removeGameRoot() {
        State.remove("GAME");
    }
}
