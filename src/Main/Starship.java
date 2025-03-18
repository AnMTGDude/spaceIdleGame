package Main;

public class Starship
{
    // Variables and values
    String[] shipEngine = {"Gen II warp-drive", "Gen III warp-drive", "Gen IV" +
            " warp-drive", "Gen V warp-drive", "Dark matter propulsion drive"
            , "Wormhole drive", "Blackhole warmhole engine"};
    int shipEngineCurrentNum = 0;
    int engineSpeed = 1; // light years
    String[] shipHull = {"Reinforced steel", "Double-reinforced steel",
            "Reinforced titanium", "Double-reinforced titanium"};
    int shipHullCurrentNum = 0;
    int shipHullPoints = 1;
    String[] shipWeapons = {"Basic ship rounds", "High-caliber ship rounds",
            "Modern ship rounds", "Advanced ship rounds", "Crude phasers",
            "Low-powered phasers", "High-powered phasers", "Dark-matter " +
            "phasers"};
    int shipWeaponsCurrentNum = 0;
    int shipWeaponPoints = 1;
    double shipFuelStorage = 100.0;
    double shipFuel = 100.0;

    // getters and setters
    public String[] getShipEngine()
    {
        return shipEngine;
    }

    public void setShipEngine(String[] shipEngine)
    {
        this.shipEngine = shipEngine;
    }

    public int getShipEngineCurrentNum()
    {
        return shipEngineCurrentNum;
    }

    public void setShipEngineCurrentNum(int shipEngineCurrentNum)
    {
        this.shipEngineCurrentNum = shipEngineCurrentNum;
    }

    public int getEngineSpeed()
    {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed)
    {
        this.engineSpeed = engineSpeed;
    }

    public String[] getShipHull()
    {
        return shipHull;
    }

    public void setShipHull(String[] shipHull)
    {
        this.shipHull = shipHull;
    }

    public int getShipHullCurrentNum()
    {
        return shipHullCurrentNum;
    }

    public void setShipHullCurrentNum(int shipHullCurrentNum)
    {
        this.shipHullCurrentNum = shipHullCurrentNum;
    }

    public int getShipHullPoints()
    {
        return shipHullPoints;
    }

    public void setShipHullPoints(int shipHullPoints)
    {
        this.shipHullPoints = shipHullPoints;
    }

    public String[] getShipWeapons()
    {
        return shipWeapons;
    }

    public void setShipWeapons(String[] shipWeapons)
    {
        this.shipWeapons = shipWeapons;
    }

    public int getShipWeaponsCurrentNum()
    {
        return shipWeaponsCurrentNum;
    }

    public void setShipWeaponsCurrentNum(int shipWeaponsCurrentNum)
    {
        this.shipWeaponsCurrentNum = shipWeaponsCurrentNum;
    }

    public int getShipWeaponPoints()
    {
        return shipWeaponPoints;
    }

    public void setShipWeaponPoints(int shipWeaponPoints)
    {
        this.shipWeaponPoints = shipWeaponPoints;
    }

    public double getShipFuelStorage()
    {
        return shipFuelStorage;
    }

    public void setShipFuelStorage(double shipFuelStorage)
    {
        this.shipFuelStorage = shipFuelStorage;
    }

    public double getShipFuel()
    {
        return shipFuel;
    }

    public void setShipFuel(double shipFuel)
    {
        this.shipFuel = shipFuel;
    }
}


