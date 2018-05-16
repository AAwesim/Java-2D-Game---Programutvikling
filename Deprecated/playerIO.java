package sample.Entity;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import java.io.*;

public class playerIO {

    private Pane pane;
    private Player player;

    public playerIO(Pane pane, Player player){
        this.pane = pane;
        this.player = player;
    }

    /*public void playerSave() {
        try(ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("player.sav"))) {
            out.writeObject(this.player);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save Complete");
    }

    public void loadSave(){
        this.pane.getChildren().remove(player);
        try(InputStream is = playerIO.class.getClassLoader().getResourceAsStream("player.sav")){
            ObjectInputStream in = new ObjectInputStream(is);
            this.player = (Player) in.readObject();
        }   catch (IOException ioe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("LOAD SAVE ERROR");
            alert.setHeaderText("FINNER IKKE PLAYER SAVE.");
            alert.setContentText("Filen for player sine tilstander finnes ikke eller eksisterer ikke. Det kan hende " +
                                 "at filen er slettet.");
            alert.showAndWait();
            ioe.printStackTrace();
            return;

        }   catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.player.initPlayer(this.pane);
        System.out.println("Load Complete");
    }*/

}
