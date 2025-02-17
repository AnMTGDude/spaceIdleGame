package Main;

import Populate.Planet;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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
    int shipEngineCurrentNum;
    int shipHullCurrentNum;
    int shipWeaponsCurrentNum;
    double shipFuelStorage;

    public ShopScene(String[] shipEngine, int engineSpeed, String[] shipHull,
                     int shipHullPoints, String[] shipWeapons,
                     int shipWeaponPoints, Stage stage, Scene scene,
                     ArrayList<Planet> populatedPlanetArrayList,
                     int shipEngineCurrentNum, int shipHullCurrentNum,
                     int shipWeaponsCurrentNum, double shipFuelStorage)
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
        this.shipEngineCurrentNum = shipEngineCurrentNum;
        this.shipHullCurrentNum = shipHullCurrentNum;
        this.shipWeaponsCurrentNum = shipWeaponsCurrentNum;
        this.shipFuelStorage = shipFuelStorage;
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
        homeButtonStoreScene.setOnAction(actionEvent-> stage.setScene(scene));

        Button planetButtonStoreScene = new Button("Planets");
        planetButtonStoreScene.setOnAction(planetsScene);
        homeButtonStoreScene.setMinSize(100, 50);
        mineralButtonStoreScene.setMinSize(100, 50);
        planetButtonStoreScene.setMinSize(100, 50);


        navHBoxPopulateScene.getChildren().addAll(mineralButtonStoreScene,
                homeButtonStoreScene, planetButtonStoreScene);
        shopBorderPane.setTop(navHBoxPopulateScene);

        GridPane itemsGridPane = new GridPane();
        itemsGridPane.setAlignment(Pos.CENTER);
        itemsGridPane.setVgap(60);
        itemsGridPane.setHgap(30);


        Text shipEngineText =
                new Text("Ship engine: " + this.shipEngine[this.shipEngineCurrentNum]);
        Text shipHullText =
                new Text("Ship hull: " + this.shipHull[this.shipHullCurrentNum]);
        Text shipWeaponText =
                new Text("Ship weapons: " + this.shipWeapons[this.shipWeaponsCurrentNum]);
        Text  shipStorageFuelText=
                new Text("Storage fuel capacity: " + shipFuelStorage);

        Button upgradeEngine = new Button("Upgrade");
        upgradeEngine.setTranslateY(40);
        upgradeEngine.setTranslateX(5);
        upgradeEngine.setMinSize(150, 50);
        upgradeEngine.setOnAction(engineEvent ->
        {

            shipEngineText.setText("Ship engine: " + shipEngine[shipEngineCurrentNum]);
        });

        Button upgradeHull = new Button("Upgrade");
        upgradeHull.setTranslateY(40);
        upgradeHull.setTranslateX(5);
        upgradeHull.setMinSize(150, 50);
        upgradeHull.setOnAction(engineEvent ->
        {
            shipHullCurrentNum++;
            shipHullText.setText("Ship engine: " + shipHull[shipHullCurrentNum]);

        });


        Button upgradeWeapon = new Button("Upgrade");
        upgradeWeapon.setTranslateY(40);
        upgradeWeapon.setTranslateX(5);
        upgradeWeapon.setMinSize(150, 50);
        upgradeWeapon.setOnAction(engineEvent -> shipEngineCurrentNum++);


        Button upgradeStorageFuel = new Button("Upgrade");
        upgradeStorageFuel.setTranslateY(40);
        upgradeStorageFuel.setTranslateX(5);
        upgradeStorageFuel.setMinSize(150, 50);
        upgradeStorageFuel.setOnAction(engineEvent -> shipEngineCurrentNum++);


        itemsGridPane.add(upgradeEngine, 0, 0);
        itemsGridPane.add(upgradeHull, 0, 1);
        itemsGridPane.add(upgradeWeapon, 1, 0);
        itemsGridPane.add(upgradeStorageFuel, 1, 1);

        itemsGridPane.add(shipEngineText, 0, 0);
        itemsGridPane.add(shipHullText, 0, 1);
        itemsGridPane.add(shipWeaponText, 1, 0);
        itemsGridPane.add(shipStorageFuelText, 1, 1);




        shopBorderPane.setCenter(itemsGridPane);

    }
}
