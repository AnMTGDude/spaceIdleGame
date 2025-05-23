package AdvanceListener;

import Main.MainScreen;
import Main.Starship;
import Populate.Planet;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Does a bunch of things when you click the advance button
 */
public class Advance implements EventHandler
{
    // Variables
    private final AtomicInteger unit; // current light-years away from earth
    private final int engineSpeed; // engineSpeed
    private final MainScreen mainScreen;
    Starship starship;

    /**
     * Constructor for the advance class
     * @param unit how many light years from earth you are
     * @param engineSpeed how many light-years you move every time you click
     *                    advance
     */
    public Advance(AtomicInteger unit, int engineSpeed,
                   MainScreen mainScreen, Starship starship)
    {
        this.unit = unit;
        this.engineSpeed = engineSpeed;
        this.mainScreen = mainScreen;
        this.starship = starship;
    }

    /**
     * Event handler
     */
    @Override
    public void handle(Event event)
    {
        if(starship.getShipFuel() > 0)
        {
            unit.getAndAdd(engineSpeed);
            double currentFuel = starship.getShipFuel();
            double newFuel = currentFuel - 5;
            starship.setShipFuel(newFuel);

            // Creates a random int to decide whether you come across a planet
            int randomPlanetInt = (int) (Math.random() * 100);
            if(randomPlanetInt < 50) // If number is less than thirty create
                // planet//remove before flight
            {
                Planet newPlanet = new Planet();
                mainScreen.setCurrentPlanet(newPlanet);
            }

            System.out.println(randomPlanetInt); // Remove before flight
        }
        else
        {
            mainScreen.getOutOfFuelGridPane().setVisible(true);
        }
    }
}