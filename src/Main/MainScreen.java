package Main;

import AdvanceListener.Advance;
import Populate.Planet;
import Populate.ShowVisibleVerify;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


/*
TO-DO NEXT:
    REMOVE CENTER STACK PANE WITH NO PLANETS POPULATED AND CREATE A PLANET'S TAB

Idea:
    -You're a space captain exploring the galaxy and populating planets.
    -Each click is one ____ (unit of distance (gets bigger every time))that
    your spaceship travels
    -You can upgrade your ship by stopping at planets and collecting
    resources there as well as refuel your ship
    -If you run out of fuel you have to call the United-Earth space rescue
    team to come save you, which costs you a certain amount of money
    -You can make money by creating settlements, which cost a certain amount
    of resources per turn to create as well as clicks to create the
    settlement based on how big the world is.
    -If you collect resources at a planet you cannot populate it because you
    dry it out
    -Each settlement generates a certain amount of something, based on what
    planet the settlement is on, such minerals, oils, science, metal

Implementation:
    -Classes:
        -Planet:
            -Size, int
            -Material, String
            -Populated, boolean
 */




/**
 * Main class, this is where the clicker is
 */
public class MainScreen extends Application
{
    // Variables *section*
    AtomicInteger distance = new AtomicInteger(0);
    String unitsFromEarth = "light years";
    String errorMessage = "-ERROR, YOU'VE GOT A DARN BUG IN YOUR CODE!";
    String shipEngine = "Gen II warp-drive";
    int engineSpeed = 1; // light years
    String shipHull = "Reinforced steel";
    String shipWeapons = "Basic ship rounds";
    double shipFuelStorage = 100.0;
    double shipFuel = 100.0;
    Planet currentPlanet = null;
    GridPane outOfFuelGridPane;
    AtomicBoolean occupiedSpace = new AtomicBoolean(false);
    int mineralOutput = 0;
    int oilOutput = 0;
    int metalOutput = 0;
    double scienceOutput = 0;
    int totMineral = 0;
    int totOil = 0;
    int totMetal = 0;
    Text metalOutputText = new Text();
    Text oilOutputText = new Text();
    Text mineralOutputText = new Text();
    Text scienceOutputText = new Text();
    ArrayList<Planet> populatedPlanetArrayList = new ArrayList<>();


/*    public void restart()
    {
        distance = new AtomicInteger(0);
        unitsFromEarth = "light years";
        shipEngine = "Gen II warp-drive";
        engineSpeed = 1; // light years
        shipHull = "Reinforced steel";
        shipWeapons = "Basic ship rounds";
        shipFuelStorage = 100.0;
        shipFuel = 100.0;
        currentPlanet = null;
        occupiedSpace = new AtomicBoolean(false);
        mineralOutput = 0;
        oilOutput = 0;
        metalOutput = 0;
        scienceOutput = 0;
        homeValue = false;
        metalOutputText = new Text();
        oilOutputText = new Text();;
        mineralOutputText = new Text();
    }*/




        // start method main section of code *section*

        /**
         * Main code for the Main.MainScreen class
         *
         * @param stage stage for the game
         */
        @Override
        public void start(Stage stage) throws Exception
        {
            BorderPane borderPane = new BorderPane();
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.show();

            // Main layout (BorderPane)
            borderPane.setPrefSize(800, 700);


            // Navigation buttons at top of page
            HBox navHBox = new HBox();
            navHBox.setSpacing(20);
            navHBox.setPadding(new Insets(20));
            borderPane.setTop(navHBox);
            navHBox.setAlignment(Pos.TOP_CENTER);

            Button mineralButton = new Button("Minerals");
            Button storeButton = new Button("Store");
            Button homeButton = new Button("Planets");
/*
        Button restartButton = new Button("Restart");
*/
 /*       restartButton.setOnAction(event ->
                restart());*/

            mineralButton.setMinSize(100, 50);
            storeButton.setMinSize(100, 50);
            homeButton.setMinSize(100, 50);
//        restartButton.setMinSize(100, 50);


            homeButton.setOnAction(event ->
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
                Button planetButton = new Button("Home");
                homeButtonPopulateScene.setMinSize(100, 50);
                storeButtonPopulateScene.setMinSize(100, 50);
                planetButton.setMinSize(100, 50);

                navHBoxPopulateScene.getChildren().addAll(homeButtonPopulateScene, storeButtonPopulateScene, planetButton);

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

                planetButton.setOnAction(actionEvent -> stage.setScene(scene));

            });


            navHBox.getChildren().addAll(mineralButton, storeButton, homeButton/*,
                restartButton*/);


            // Info about ship on left hand side (under advance button)
            VBox mainVBox = new VBox();
            mainVBox.setSpacing(20);
            mainVBox.setPadding(new Insets(-50, 0, 0, 50));
            borderPane.setLeft(mainVBox);
            mainVBox.setAlignment(Pos.CENTER_LEFT);
            Line newLine = new Line();
            newLine.setStartX(260);
            newLine.setEndX(575);
            Text shipEngineText = new Text("Ship engine: " + shipEngine);
            Text shipHullText = new Text("Ship hull: " + shipHull);
            Text shipWeaponsText = new Text("Ship weapons: " + shipWeapons);
            Text shipFuelStorageText =
                    new Text("Ship fuel storage capacity: " + shipFuelStorage);
            Text shipFuelText =
                    new Text("Fuel: " + shipFuel);


            Label distanceText =
                    new Label(distance.get() + " " + unitsFromEarth + " from Earth");
            Button advanceButton = new Button("Advance");

            advanceButton.setMinSize(175, 100);

            distanceText.setTranslateX(10);
            distanceText.setBorder(Border.stroke(Paint.valueOf("GREY")));
            distanceText.setPadding(new Insets(0, 20, 0, 20));
            mainVBox.getChildren().addAll(advanceButton, distanceText, newLine,
                    shipEngineText, shipHullText, shipWeaponsText,
                    shipFuelStorageText, shipFuelText);


            // Right hand side info (planet info, populate, and mine out)
            VBox infoBox = new VBox();
            infoBox.setSpacing(30);
            infoBox.setPadding(new Insets(-100, 20, 0, 0));
            infoBox.setAlignment(Pos.CENTER_LEFT);

            Label infoText = new Label("Nothing new to see here");
            infoText.setBorder(Border.stroke(Paint.valueOf("GREY")));
            infoText.setPadding(new Insets(0, 20, 0, 20));
            Line lineSeparate = new Line();
            lineSeparate.setStartX(260);
            lineSeparate.setEndX(575);
            Label planetType = new Label(errorMessage);
            Label material = new Label(errorMessage);
            planetType.setVisible(false);
            material.setVisible(false);

            planetType.setBorder(Border.stroke(Paint.valueOf("GREY")));
            material.setBorder(Border.stroke(Paint.valueOf("GREY")));
            planetType.setPadding(new Insets(0, 20, 0, 20));
            material.setPadding(new Insets(0, 20, 0, 20));
            Button populate = new Button("Populate planet");
            Text populateCantText = new Text("You cannot populate this planet");
            Text alreadyPopulatedText = new Text("You have already populated this" +
                    " planet");

            Button mine = new Button("Mine out planet");
            populate.setVisible(false);
            populateCantText.setVisible(false);
            mine.setVisible(false);
            alreadyPopulatedText.setVisible(false);

            StackPane populateStackPane = new StackPane();
            populateStackPane.setAlignment(Pos.CENTER_LEFT);

            populateStackPane.getChildren().addAll(populate, populateCantText, alreadyPopulatedText);

            infoBox.getChildren().addAll(infoText, lineSeparate, planetType,
                    material, populateStackPane, mine);

            borderPane.setRight(infoBox);

            // Advance button handler
            Advance advance = new Advance(distance, engineSpeed,
                    this, shipFuel);


            // Pop-ups *section*

            // populate pop-up section
            StackPane centerStackPane = new StackPane();
            borderPane.setCenter(centerStackPane);

            GridPane doubleCheck = new GridPane();
            doubleCheck.setPadding(new Insets(20));
            doubleCheck.setMaxHeight(170);
            doubleCheck.setMaxWidth(100);
            doubleCheck.setVisible(false);


            HBox yesNoButtonBox = new HBox();
            doubleCheck.setBackground(Background.fill(Color.rgb(244, 244, 244)));
            yesNoButtonBox.setAlignment(Pos.CENTER);
            yesNoButtonBox.setSpacing(20);
            yesNoButtonBox.setPadding(new Insets(20));

            Text youSure = new Text("Are you sure you want to populate this " +
                    "planet?\n\t\tThis action is irreversible.");
            Button xButton = new Button("X");
            Button yesButton = new Button("Yes, I'm sure");
            Button noButton = new Button("No, don't populate");
            yesButton.setMinSize(90, 20);
            noButton.setMinSize(120, 20);

            ShowVisibleVerify yesShowWarning =
                    new ShowVisibleVerify(doubleCheck, true, occupiedSpace);
            ShowVisibleVerify noRemoveWarning =
                    new ShowVisibleVerify(doubleCheck, false, occupiedSpace);


            populate.setOnAction(yesShowWarning);

            xButton.setOnAction(noRemoveWarning);

            noButton.setOnAction(noRemoveWarning);

            yesNoButtonBox.getChildren().addAll(yesButton, noButton);

            doubleCheck.setBorder(Border.stroke(Paint.valueOf("GREY")));

            doubleCheck.add(xButton, 2, 0);
            doubleCheck.add(youSure, 1, 1);
            doubleCheck.add(yesNoButtonBox, 1, 2);

            // mine planet popup
            GridPane mineOutGridPane = new GridPane();
            mineOutGridPane.setPadding(new Insets(20));
            mineOutGridPane.setMaxHeight(130);
            mineOutGridPane.setVisible(false);
            mineOutGridPane.setBorder(Border.stroke(Paint.valueOf("GREY")));
            mineOutGridPane.setBackground(Background.fill(Color.rgb(244,
                    244, 244)));

            Text mineOutSureText = new Text("Are you sure you want to mine out " +
                    "this planet?\nYou cannot revert this action! You will no " +
                    "longer be able to populate this planet!");
            Button mineYesButton = new Button("Yes, mine planet");
            Button mineNoButton = new Button("Cancel");

            ShowVisibleVerify YesShowWarningMine =
                    new ShowVisibleVerify(mineOutGridPane, true, occupiedSpace);
            ShowVisibleVerify NoRemoveWarningMine =
                    new ShowVisibleVerify(mineOutGridPane, false, occupiedSpace);
            mine.setOnAction(YesShowWarningMine);
            mineNoButton.setOnAction(NoRemoveWarningMine);


            HBox mineHBox = new HBox();
            mineHBox.setAlignment(Pos.CENTER);
            mineHBox.setSpacing(20);
            mineHBox.setPadding(new Insets(20));

            mineHBox.getChildren().addAll(mineYesButton, mineNoButton);
            mineOutGridPane.add(mineOutSureText, 0, 1);
            mineOutGridPane.add(mineHBox, 0, 2);

            // Out of fuel popup
            outOfFuelGridPane = new GridPane();
            outOfFuelGridPane.setVisible(false);
            outOfFuelGridPane.setPadding(new Insets(20));
            outOfFuelGridPane.setMaxHeight(90);
            outOfFuelGridPane.setMaxWidth(100);
            outOfFuelGridPane.setBorder(Border.stroke(Paint.valueOf("GREY")));
            outOfFuelGridPane.setBackground(Background.fill(Color.rgb(244,
                    244, 244)));


            HBox outOfFuelHbox = new HBox();
            outOfFuelHbox.setAlignment(Pos.CENTER);
            outOfFuelHbox.setSpacing(20);
            outOfFuelHbox.setPadding(new Insets(20));


            Text outOfFuelText = new Text("You are out of fuel! You need to " +
                    "call a rescue team from earth! \n\t\t\t\tThis costs 30 " +
                    "minerals.");
            Button callThem = new Button("Call a rescue team");
            Button outOfFuelClose = new Button("Close");

            outOfFuelGridPane.add(outOfFuelText, 0, 1);
            outOfFuelGridPane.add(outOfFuelHbox, 0, 2);
            outOfFuelHbox.getChildren().addAll(callThem, outOfFuelClose);


            ShowVisibleVerify removeFuelWarning =
                    new ShowVisibleVerify(outOfFuelGridPane, false, occupiedSpace);
            outOfFuelClose.setOnAction(removeFuelWarning);


            //Successfully populated planet popup
            GridPane successPopulated = new GridPane();
            successPopulated.setMaxHeight(90);
            successPopulated.setMaxWidth(100);
            successPopulated.setPadding(new Insets(20));
            successPopulated.setVisible(false);
            successPopulated.setVgap(20);

            successPopulated.setBorder(Border.stroke(Paint.valueOf("GREY")));
            successPopulated.setBackground(Background.fill(Color.rgb(244,
                    244, 244)));

            Text successPopulateText = new Text("Planet successfully populated");
            Button okSuccessPopulatedButton = new Button("Ok");
            okSuccessPopulatedButton.setTranslateX(30);
            okSuccessPopulatedButton.setOnAction(event ->
            {
                successPopulated.setVisible(false);
                occupiedSpace.set(false);
            });

            okSuccessPopulatedButton.setMinSize(90, 20);

            successPopulated.add(successPopulateText, 0, 0);
            successPopulated.add(okSuccessPopulatedButton, 0, 1);


            // Center populated planets grid
            VBox materailsCenterVBox = new VBox();
            materailsCenterVBox.setPadding(new Insets(10));
            materailsCenterVBox.setAlignment(Pos.CENTER);
            materailsCenterVBox.setBackground(Background.fill(Color.rgb(244,
                    244, 244)));


            mineralOutputText =
                    new Text("Minerals: " + totMineral + " (" + mineralOutput +
                    ")\n");
            oilOutputText = new Text("Oil: " + totOil + " (" + oilOutput + ")" +
                    "\n");
            metalOutputText =
                    new Text("Metal: " + totMetal + " (" + metalOutput +
                    ")\n");
            scienceOutputText = new Text("Science output " + scienceOutput);


            materailsCenterVBox.getChildren().addAll(mineralOutputText,
                    oilOutputText, metalOutputText, scienceOutputText);


            // Continue advance popup (for when you are at a planet, and you try
            // to leave
            GridPane continueAdvance = new GridPane();
            continueAdvance.setVisible(false);
            continueAdvance.setPadding(new Insets(20));
            continueAdvance.setMaxHeight(90);
            continueAdvance.setMaxWidth(100);
            continueAdvance.setBorder(Border.stroke(Paint.valueOf("GREY")));
            continueAdvance.setBackground(Background.fill(Color.rgb(244,
                    244, 244)));


            HBox continueAdvanceHbox = new HBox();
            continueAdvanceHbox.setAlignment(Pos.CENTER);
            continueAdvanceHbox.setSpacing(20);
            continueAdvanceHbox.setPadding(new Insets(20));


            Text continueAdvanceText = new Text("You are currently at a planet. " +
                    "Would you like to leave?");
            Button continueAdvanceYes = new Button("Yes, leave planet");
            continueAdvanceYes.setOnAction(event ->
            {
                continueAdvance.setVisible(false);
                currentPlanet = null;
                infoText.setText("Nothing new to see here");
                mine.setVisible(false);
                advanceButton.fire();
                occupiedSpace.set(false);
                alreadyPopulatedText.setVisible(false);
            });

            Button continueAdvanceNo = new Button("Close");
            continueAdvanceNo.setOnAction(event ->
            {
                continueAdvance.setVisible(false);
                occupiedSpace.set(false);

            });

            continueAdvanceHbox.getChildren().addAll(continueAdvanceYes, continueAdvanceNo);

            continueAdvance.add(continueAdvanceText, 0, 1);
            continueAdvance.add(continueAdvanceHbox, 0, 2);

            centerStackPane.getChildren().addAll(materailsCenterVBox,
                    doubleCheck, outOfFuelGridPane,
                    mineOutGridPane, continueAdvance, successPopulated);

            // Event listeners *section*

            // Advnace button listener
            advanceButton.setOnAction(event ->
            {
                totMineral += mineralOutput;
                totOil += oilOutput;
                totMetal += metalOutput;

                mineralOutputText.setText("Minerals: " + totMineral + " " +
                        "(" + mineralOutput +
                        ")\n");
                oilOutputText.setText("Oil: " + totOil + " (" + oilOutput + ")" +
                        "\n");
                metalOutputText.setText("Metal: " + totMetal + " (" + metalOutput +
                        ")\n");
                scienceOutputText.setText("Science output " + scienceOutput);

                // Creating the planet
                if (!continueAdvance.isVisible())
                {
                    if (currentPlanet != null)
                    {
                        continueAdvance.setVisible(true); /*continueAdvnace is
                    the gridPane that will show the popup if you are at a
                    planet and try to leave*/
                        occupiedSpace.set(true);
                    }

                    if (currentPlanet == null)
                    {
                        advance.handle(event);
                        alreadyPopulatedText.setVisible(false);
                        // Update the distance label
                        distanceText.setText(distance.get() + " " + unitsFromEarth + " from Earth");
                        shipFuelText.setText("Fuel: " + shipFuel);


                        // Update the infoText label
                        if (currentPlanet != null)
                        {
                            infoText.setText("Arrived at planet: " + currentPlanet.getName() + "\nTemperature: " +
                                    currentPlanet.getTemperature() + "°F" +
                                    "\nBreathable air: " +
                                    currentPlanet.isAir() + "\nSize: " + currentPlanet.getSize() +
                                    " (" + currentPlanet.getDescriptiveTextSize() + " planet)" +
                                    "\nHabitable:" +
                                    " " + currentPlanet.isHabitable());
                            material.setText("Material on planet: " + currentPlanet.getMaterials());
                            planetType.setText("Planet type: " + currentPlanet.getPlanetType());
                        }
                        if (shipFuel <= 0 && currentPlanet == null)
                        {
                            outOfFuelGridPane.setVisible(true);
                            occupiedSpace.set(true);
                        }
                    }
                }

                // populate and mine buttons visibility
                if (currentPlanet == null)
                {
                    populate.setVisible(false);
                    populateCantText.setVisible(false);
                    mine.setVisible(false);
                    planetType.setVisible(false);
                    material.setVisible(false);

                }
                if (currentPlanet != null)
                {
                /*Further code on populate button whether the planet can
                actually be populated*/
                    if (currentPlanet.isHabitable() && !currentPlanet.getPopulated())
                    {
                        populate.setVisible(true);
                        populateCantText.setVisible(false);
                    }
                    if (!currentPlanet.isHabitable())
                    {
                        populateCantText.setVisible(true);
                    }
                    mine.setVisible(true);
                    planetType.setVisible(true);
                    material.setVisible(true);
                }
            });

            yesButton.setOnAction(event ->
            {
                doubleCheck.setVisible(false);
                System.out.println("Entered handler");

                if (this.currentPlanet.isHabitable() && !this.currentPlanet.getPopulated())
                {
                    this.currentPlanet.setPopulated(true);  /*Turns the planets populated status
             to true*/
                    populatedPlanetArrayList.addLast(this.currentPlanet);

                    String planetMaterial = this.currentPlanet.getMaterials();

                    System.out.println(this.currentPlanet.getDescriptiveTextSize()); //
                    // remove before flight (testing size)

                    switch (planetMaterial)
                    {
                        case "Metal":
                            switch (this.currentPlanet.getDescriptiveTextSize())
                            {
                                case "dwarf":
                                    metalOutput += 1;
                                    System.out.println("Metal 1");
                                    break;
                                case "small":
                                    metalOutput += 2;
                                    System.out.println("Metal 2");
                                    break;
                                case "large":
                                    metalOutput += 4;
                                    System.out.println("Metal 4");
                                    break;
                                case "super-giant":
                                    metalOutput += 6;
                                    System.out.println("Metal 6");
                                    break;
                            }
                            break;
                        case "Oil":
                            switch (this.currentPlanet.getDescriptiveTextSize())
                            {
                                case "dwarf":
                                    oilOutput += 1;
                                    System.out.println("Oil 1");
                                    break;
                                case "small":
                                    oilOutput += 2;
                                    System.out.println("Oil 2");
                                    break;
                                case "large":
                                    oilOutput += 4;
                                    System.out.println("Oil 4");
                                    break;
                                case "super-giant":
                                    oilOutput += 6;
                                    System.out.println("Oil 6");
                                    break;
                            }
                            break;
                        case "Mineral":
                            switch (this.currentPlanet.getDescriptiveTextSize())
                            {
                                case "dwarf":
                                    mineralOutput += 1;
                                    System.out.println("Mineral 1");
                                    break;
                                case "small":
                                    mineralOutput += 2;
                                    System.out.println("Mineral 2");
                                    break;
                                case "large":
                                    mineralOutput += 4;
                                    System.out.println("Mineral 4");
                                    break;
                                case "super-giant":
                                    mineralOutput += 6;
                                    System.out.println("Mineral 6");
                                    break;
                            }
                            break;
                    }
                    mineralOutputText.setText("Minerals: " + totMineral + " " +
                            "(" + mineralOutput +
                                    ")\n");
                    oilOutputText.setText("Oil: " + totOil + " (" + oilOutput + ")" +
                            "\n");
                    metalOutputText.setText("Metal: " + totMetal + " (" + metalOutput +
                                    ")\n");
                    scienceOutputText.setText("Science output " + scienceOutput);

                    successPopulated.setVisible(true);
                    populate.setVisible(false);
                    alreadyPopulatedText.setVisible(true);
                }
            });

        }


        // Getters and setters *section*
        public void setCurrentPlanet(Planet newPlanet)
        {
            this.currentPlanet = newPlanet;  // Update the current planet
        }

        public double getShipFuel()
        {
            return shipFuel;
        }

        public void setShipFuel(double newFuel)
        {
            shipFuel = newFuel;
        }

        public GridPane getOutOfFuelGridPane()
        {
            return outOfFuelGridPane;
        }
    }