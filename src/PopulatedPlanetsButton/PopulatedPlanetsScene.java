package PopulatedPlanetsButton;

import Main.MainScreen;
import Main.ResetToMainScene;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class PopulatedPlanetsScene implements EventHandler
{
    MainScreen mainScreen;
    Stage stage;
    boolean homeValue;
    Scene scene;

    public PopulatedPlanetsScene(MainScreen mainScreen, Button button,
                                 Stage stage, Scene scene, boolean homeValue)
    {
        this.mainScreen = mainScreen;this.stage = stage;
        this.homeValue = homeValue;
        this.scene = scene;
    }

    @Override
    public void handle(Event event)
    {
        BorderPane borderPane = new BorderPane();
        Scene newScene = new Scene(borderPane);
        borderPane.setPrefSize(1100, 600);
        stage.setScene(newScene);

        // Navigation buttons (structured with HBox)
        HBox navHBox = new HBox();
        navHBox.setSpacing(20);
        navHBox.setPadding(new Insets(20));
        navHBox.setAlignment(Pos.TOP_CENTER);

        Button homeButton = new Button("Minerals");
        Button storeButton = new Button("Store");
        Button planetButton = new Button("Home");
        homeButton.setMinSize(100, 50);
        storeButton.setMinSize(100, 50);
        planetButton.setMinSize(100, 50);

        navHBox.getChildren().addAll(homeButton, storeButton, planetButton);
        borderPane.setTop(navHBox);


        ResetToMainScene resetScene = new ResetToMainScene(stage, scene);
        planetButton.setOnAction(resetScene);

    }
}
