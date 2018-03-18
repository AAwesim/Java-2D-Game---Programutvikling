package sample.Entity;


import javafx.scene.canvas.GraphicsContext;

public interface Entity {

    //Gjør at alle entiteter må opprette en avatar
    void createAvatar();

    void render(GraphicsContext gc);
}
