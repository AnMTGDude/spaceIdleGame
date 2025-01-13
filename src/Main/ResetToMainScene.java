package Main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.midi.SysexMessage;

public class ResetToMainScene implements EventHandler
{
    Stage stage;
    Scene scene;

    public ResetToMainScene(Stage stage, Scene scene)
    {
        this.stage = stage;
        this.scene = scene;
    }

    @Override
    public void handle(Event event)
    {
//        System.out.println("RESET SCENE"); // Test
        stage.setScene(scene);
    }
}
