package Main;

import Populate.Planet;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Changes scene when clicking shop nav button
 */
public class ShopScene implements EventHandler
{
    String[] shipEngine;
    int engineSpeed;
    String[] shipHull;
    int shipHullPoints;
    String[] shipWeapons;
    int shipWeaponPoints;
    Stage stage;
    Scene scene;
    ArrayList<Planet> populatedPlanetArrayList;

    public ShopScene(String[] shipEngine, int engineSpeed, String[] shipHull,
                     int shipHullPoints, String[] shipWeapons,
                     int shipWeaponPoints, Stage stage, Scene scene,
                     ArrayList<Planet> populatedPlanetArrayList)
    {
        this.shipEngine = shipEngine;
        this.engineSpeed = engineSpeed;
        this.shipHull = shipHull;
        this.shipHullPoints = shipHullPoints;
        this.shipWeapons = shipWeapons;
        this.shipWeaponPoints = shipWeaponPoints;
        this.stage = stage;
        this.scene = scene;
        this.populatedPlanetArrayList = populatedPlanetArrayList;
    }


    @Override
    public void handle(Event event)
    {
        BorderPane shopBorderPane = new BorderPane();
        shopBorderPane.setPrefSize(1100, 600);
        Scene shopScene = new Scene(shopBorderPane);
        stage.setScene(shopScene);
        PlanetsScene planetsScene = new PlanetsScene(stage, scene,
                this, populatedPlanetArrayList);

        // Navigation buttons (structured with HBox)
        HBox navHBoxPopulateScene = new HBox();
        navHBoxPopulateScene.setSpacing(20);
        navHBoxPopulateScene.setPadding(new Insets(20));
        navHBoxPopulateScene.setAlignment(Pos.TOP_CENTER);

        Button mineralButtonStoreScene = new Button("Minerals");
        Button homeButtonStoreScene = new Button("Home");
        homeButtonStoreScene.setOnAction(actionEvent->
        {
            stage.setScene(scene);
        });

        Button planetButtonStoreScene = new Button("Planets");
        planetButtonStoreScene.setOnAction(planetsScene);
        homeButtonStoreScene.setMinSize(100, 50);
        mineralButtonStoreScene.setMinSize(100, 50);
        planetButtonStoreScene.setMinSize(100, 50);

        navHBoxPopulateScene.getChildren().addAll(mineralButtonStoreScene,
                homeButtonStoreScene, planetButtonStoreScene);
        shopBorderPane.setTop(navHBoxPopulateScene);
    }
}
