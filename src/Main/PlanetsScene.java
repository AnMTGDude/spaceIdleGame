package Main;

import Populate.Planet;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Changes scene when clicking planets nav button
 */
public class PlanetsScene implements EventHandler
{
    Stage stage;
    Scene scene;
    ShopScene shopScene;
    ArrayList<Planet> populatedPlanetArrayList;

    public PlanetsScene(Stage stage,Scene scene, ShopScene shopScene,
                        ArrayList<Planet> populatedPlanetArrayList)
    {
        this.stage = stage;
        this.scene = scene;
        this.shopScene = shopScene;
        this.populatedPlanetArrayList = populatedPlanetArrayList;
    }

    @Override
    public void handle(Event event)
    {
        BorderPane borderPanePopulateScene = new BorderPane();
        Scene newScene = new Scene(borderPanePopulateScene);
        borderPanePopulateScene.setPrefSize(1100, 600);
        stage.setScene(newScene);

        // Navigation buttons (structured with HBox)
        HBox navHBoxPopulateScene = new HBox();
        navHBoxPopulateScene.setSpacing(20);
        navHBoxPopulateScene.setPadding(new Insets(20));
        navHBoxPopulateScene.setAlignment(Pos.TOP_CENTER);

        Button homeButtonPopulateScene = new Button("Minerals");
        Button storeButtonPopulateScene = new Button("Store");
        storeButtonPopulateScene.setOnAction(shopScene);
        Button homeButton = new Button("Home");
        homeButtonPopulateScene.setMinSize(100, 50);
        storeButtonPopulateScene.setMinSize(100, 50);
        homeButton.setMinSize(100, 50);


        navHBoxPopulateScene.getChildren().addAll(homeButtonPopulateScene,
                storeButtonPopulateScene, homeButton);

        TableView<Planet> table = new TableView<>();
        table.setPlaceholder(new Label("You have not populated any " +
                "planets"));
        // Planet name column (String)
        TableColumn<Planet, String> planetNameCol = new TableColumn<>("Planet name");
        planetNameCol.setCellValueFactory(new PropertyValueFactory<>("name")); // getter: getName()

        // Habitable column (Boolean)
        TableColumn<Planet, Boolean> planetHabitateCol = new TableColumn<>("Habitable");
        planetHabitateCol.setCellValueFactory(new PropertyValueFactory<>("habitable")); // getter: isHabitable()

        // Air column (Boolean)
        TableColumn<Planet, Boolean> planetAirCol = new TableColumn<>("Air");
        planetAirCol.setCellValueFactory(new PropertyValueFactory<>("air")); // getter: isAir()

        // Temperature column (Integer)
        TableColumn<Planet, Integer> planetTempCol = new TableColumn<>("Temperature");
        planetTempCol.setCellValueFactory(new PropertyValueFactory<>("temperature")); // getter: getTemperature()

        // Planet size column (String)
        TableColumn<Planet, String> planetSizeCol = new TableColumn<>("Planet size");
        planetSizeCol.setCellValueFactory(new PropertyValueFactory<>("size")); // getter: getSize()

        // Size classification column (String)
        TableColumn<Planet, String> planetSizeClassCol = new TableColumn<>("Size classification");
        planetSizeClassCol.setCellValueFactory(new PropertyValueFactory<>("descriptiveTextSize")); // getter: getDescriptiveTextSize()

        // Planet type column (String)
        TableColumn<Planet, String> planetTypeCol =
                new TableColumn<>("Type");
        planetTypeCol.setCellValueFactory(new PropertyValueFactory<>(
                "planetType"));

        // Material column (String) - Convert String[] to String
        TableColumn<Planet, String> planetMaterialCol = new TableColumn<>("Material");
        planetMaterialCol.setCellValueFactory(cellData -> {
            Planet planet = cellData.getValue();
            return new SimpleStringProperty(String.join(", ", planet.getMaterials())); // Convert array to comma-separated string
        });

        table.getColumns().addAll(planetNameCol, planetHabitateCol,
                planetAirCol, planetTempCol, planetSizeCol,
                planetSizeClassCol, planetMaterialCol, planetTypeCol);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        for(int i = 0; i < populatedPlanetArrayList.size(); i++)
        {
            Planet planetForForLoop = populatedPlanetArrayList.get(i);
            table.getItems().add(planetForForLoop);
        }

        borderPanePopulateScene.setCenter(table);
        borderPanePopulateScene.setTop(navHBoxPopulateScene);

        homeButton.setOnAction(actionEvent -> stage.setScene(scene));
    }
}
