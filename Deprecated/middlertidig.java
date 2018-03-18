package Deprecated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Verktøy.Utilities;
import sample.Verktøy.Utilities.*;

import java.io.IOException;

import static sample.Main.*;

public class middlertidig implements Runnable{
    private Thread thread;
    String gameScreen = "gameScene.fxml";
    String hjelpScreen = "hjelpScene.fxml";
    String screenCompare = "";
    private boolean running;
    private int FPS = 60;
    private double averageFPS;

    public void setStartScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(gameScreen));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene startScene = new Scene(root,SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setResizable(false);
        stage.setTitle(GAME_NAME);
        stage.setScene(startScene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            exitScreen();
        });

        threadStart();

    }

    public String checkString(String s){
        if(s == "startButton"){
            return "gameScene.fxml";
        }

        else if (s == "hjelpButton"){
            return "hjelpScene.fxml";
        }

        else {
            return "";
        }
    }


    public void exitScreen(){
        System.exit(0);
    }

    public void threadStart(){
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }

        else{
            return;
        }
    }

    @Override
    public void run() {
        System.out.println("thread er laget");
        running = true;

        //initialize();

        //Variabler for å måle tid før og etter update() og render() har kjørt
        long startTid;
        long prosessTid;
        long venteTid;
        long totalTid = 0;

        int frameCount = 0;
        int maksFrameCount = FPS;

        //tiden i millisekunder som man må for å få riktig FPS
        long prefTid = 1000/FPS;

        // GAME LOOP
        while(running){

            startTid = System.nanoTime();


            update();
            render();

            prosessTid = (System.nanoTime()-startTid)/(1000000); //Tiden det tok å kjøre update og render
            venteTid = prefTid - prosessTid; //hvor mye du er nødt til å vente for å få ca. 60 fps

            try{
                Thread.sleep(venteTid);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            totalTid += System.nanoTime() - startTid;
            frameCount++;
            if(frameCount == maksFrameCount){
                averageFPS = 1000.0 /  ((totalTid/frameCount)/1000000.0);
                frameCount = 0;
                totalTid = 0;
            }

        }
    }

    private void initialize(){
    }

    private void update(){
        System.out.println("FPS: " + (int)averageFPS);
    }

    private void render(){

    }

}
