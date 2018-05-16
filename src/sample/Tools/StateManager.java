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
 * Det er veldig enkelt å legge til flere scenes, man legger til en enum, legger til .fxml til State hashmappet, legger
 * til en case i update og vipps så har man enda en scene.
 *
 * Begrunnelse: Det ga god mening å holde styr på alle scenes som blir tatt bruk av i javafx-applikasjonen. Fordi man
 * kan raskt og enkelt navigere til andre scenes uten å måtte hele tiden lese .fxml og lage nye Scene objekter.
 *
 * Ulemper: Dette er ikke en skalerbar metode fordi alle scenes blir lagret til minnet.
 *
 * @author Asim (s325912)
 */
public final class StateManager {

    /**
     * Den statiske variablen blir brukt for å holde styr på hvilket level brukeren vil spille. Det gir mening å ha noe
     * som holder
     */
    public static String LEVEL;

    /**
     * Lagrer Stage objektet fra Main.main().
     *
     * Begrunnelse: Det er greit å gjennbruke Stage objektet fordi det sparer ressurser (cpu/minne).
     */
    private static Stage stage;

    /**
     * Forhåndssatte faste variabler som blir brukt for å holde styr på hvilken state programmet er i.
     */
    public enum GameState {
        BUFFER,
        MENU,
        LEVEL,
        HELP,
        PAUSE,
        GAMEOVER,
        GAME
    }

    /**
     * gameState er en GameState variabel den kan bli mutert av setState og den kan være bare en av enum variablene.
     * Formålet med variabelen er å holde styr på hvilken state du ønsker. Som default er den satt til GameState.MENU
     * så når programmet starter vil første scene være menu.fxml
     */
    private static GameState gameState = GameState.MENU;

    /**
     * Hashmap som har en String som key og mapper en Scene til den key-en.
     *
     * Begrunnelse: var mye mer praktisk og mer fleksibelt å lagre det i et Map framfor en annen collection som f.eks
     * LinkedList, ArrayList eller HashSet.
     */
    private static Map<String, Scene> State = new HashMap<>();

    /**
     * Prosedyre som kjøres hvis gameState blir mutert, altså at setState() blir brukt.
     * Formålet med prosedyren er å returnere riktig Scene objekt basert på hva gameState er.
     *
     * @return
     */
    public static Scene update(){
        switch(gameState){
            case BUFFER:
                if(State.get("HELP") != null)
                    return State.get("BUFFER");

                    case HELP:
                if(State.get("HELP") != null)
                    System.out.println("HELP");
                return State.get("HELP");

            case MENU:
                if(State.get("MENU") != null)
                    System.out.println("MENU");
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
     * Formålet med prosedyren er å hente lagre Scenes inn i en hashmap.
     * Den blir kalt en gang i Main.main().
     *
     * Begrunnelse: Disse scenesa endres ikke ved runtime så det er egentlig aldri vits å reloade scene objektene fra
     * fxml. Derfor gir det mening å bare lagre dem i minne.
     *
     * Grunn til bekymring: Hvis du har backgrounds med store gif-er så vil minne øke betraktelig, derfor er det viktig
     * å ha optimaliserte bakgrunner eller ideelt, ingen.
     *
     */
    public static void initStates(){
        try {
            State.put("BUFFER", new Scene(
                    FXMLLoader.load(
                            StateManager.class.getClassLoader().getResource("sample/FXML/buffer.fxml"))));

            State.put("MENU", new Scene(
                    FXMLLoader.load(
                            StateManager.class.getClassLoader().getResource("sample/FXML/menu.fxml"))));

            State.put("LEVEL", new Scene(
                    FXMLLoader.load(
                            StateManager.class.getClassLoader().getResource("sample/FXML/levelScene.fxml"))));

            State.put("HELP", new Scene(
                    FXMLLoader.load(
                            StateManager.class.getClassLoader().getResource("sample/FXML/hjelpScene.fxml"))));

            State.put("PAUSE", new Scene(
                    FXMLLoader.load(
                            StateManager.class.getClassLoader().getResource("sample/FXML/pauseScene.fxml"))));

            State.put("GAMEOVER", new Scene(
                    FXMLLoader.load(
                            StateManager.class.getClassLoader().getResource("sample/FXML/gameOver.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Denne prosedyren er nærmest lik initStates() (den over), forskjellen ligger i at det er gameScene, altså scene
     * der spillet faktisk blir gjort på kan trenge å endres på. Formålet er å laste inn gameScene. Prosedyren blir bare
     * brukt hvis hashmappet med nøkkel "GAME" er tom.
     */
    private static void initGame(){
            try {
                State.put("GAME", new Scene(
                        FXMLLoader.load(
                                StateManager.class.getClassLoader().getResource("sample/FXML/gameScene.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
    }

    /**
     * Denne prosedyren blir brukt når man ønsker å bytte Scene ved å en javafx node event, som f.eks. ved å trykke på
     * en knapp.
     *
     * @param e
     * @param gameStateEnum
     */
    public static void changeScene(Event e, GameState gameStateEnum){
        if(stage == null){
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        }
        StateManager.setState(gameStateEnum);
        stage.setScene(StateManager.update());
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Prosedyren er lik den over (changeScene(Event e, GameState gameStateEnum) bare at denne tar ikke imot en Event
     * parameter, så denne kan bli kalt når man bare ønsker å bytte Scene.
     * @param gameStateEnum
     */
    public static void changeScene(GameState gameStateEnum){
        StateManager.setState(gameStateEnum);
        stage.setScene(StateManager.update());
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Prosedyren fjerner gameScene Scene objektet fra State hashmap. Dette er viktig for å at initGame() kjører, fordi
     * da restarter spillet.
     */
    public static void removeGameRoot() {
        State.remove("GAME");
    }

    /**
     * Setter (mutator) som endrer GameState. Den blir brukt i changeScene prosedyren for å ta seg hånd om å bytte
     * GameState.
     * @param newState
     */
    private static void setState(GameState newState){
        gameState = newState;
    }

}
