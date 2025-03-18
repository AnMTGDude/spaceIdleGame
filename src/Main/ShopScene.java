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
    Starship starship;

    public ShopScene(Stage stage, Scene scene,
                     ArrayList<Planet> populatedPlanetArrayList,
                     Starship starship)
    {
        this.shipEngine = starship.getShipEngine();
        this.engineSpeed = starship.getEngineSpeed();
        this.shipHull = starship.getShipHull();
        this.shipHullPoints = starship.getShipHullPoints();
        this.shipWeapons = starship.getShipWeapons();
        this.shipWeaponPoints = starship.getShipWeaponPoints();
        this.stage = stage;
        this.scene = scene;
        this.populatedPlanetArrayList = populatedPlanetArrayList;
        this.shipEngineCurrentNum = starship.getShipEngineCurrentNum();
        this.shipHullCurrentNum = starship.getShipHullCurrentNum();
        this.shipWeaponsCurrentNum = starship.getShipWeaponsCurrentNum();
        this.shipFuelStorage = starship.getShipFuelStorage();
        this.starship = starship;
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
                    if(shipEngineCurrentNum < shipEngine.length - 1)
                    {
                        shipEngineCurrentNum++;
                        shipEngineText.setText("Ship engine: " + this.shipEngine[this.shipEngineCurrentNum]);
                        starship.setShipEngineCurrentNum(this.shipEngineCurrentNum);
                    }
                });

        Button upgradeHull = new Button("Upgrade");
        upgradeHull.setTranslateY(40);
        upgradeHull.setTranslateX(5);
        upgradeHull.setMinSize(150, 50);
        upgradeHull.setOnAction(engineEvent ->
        {
            if(shipHullCurrentNum < shipHull.length - 1)
            {
                shipHullCurrentNum++;
                shipHullText.setText("Ship hull: " + this.shipHull[this.shipHullCurrentNum]);
                starship.setShipHullCurrentNum(this.shipHullCurrentNum);
            }
        });

        Button upgradeWeapon = new Button("Upgrade");
        upgradeWeapon.setTranslateY(40);
        upgradeWeapon.setTranslateX(5);
        upgradeWeapon.setMinSize(150, 50);
        upgradeWeapon.setOnAction(engineEvent ->
        {
            if(shipWeaponsCurrentNum < shipWeapons.length - 1)
            {
                shipWeaponsCurrentNum++;
                shipWeaponText.setText("Ship weapons: " + this.shipWeapons[this.shipWeaponsCurrentNum]);
                starship.setShipWeaponsCurrentNum(this.shipWeaponsCurrentNum);
            }
        });


        Button upgradeStorageFuel = new Button("Upgrade");
        upgradeStorageFuel.setTranslateY(40);
        upgradeStorageFuel.setTranslateX(5);
        upgradeStorageFuel.setMinSize(150, 50);
        upgradeStorageFuel.setOnAction(engineEvent ->
        {
            shipFuelStorage += 20;
            shipStorageFuelText.setText("Storage fuel capacity: " + shipFuelStorage);
            starship.setShipFuelStorage(this.shipFuelStorage);
        });


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
