package Materials;

public class Materials
{
    String type; // Can be science, metal, mineral, and oil
    static String[] metal = new String[]{"0", "Metal"};
    static String[] oil = new String[]{"0", "Oil"};
    static String[] mineral = new String[]{"0", "Mineral"};
    static String[] science = new String[]{"0", "Science"};
    static String amount;

    public static String[] getRandom()
    {
        int getRandomInt = (int)(Math.random() * 3);
        if(getRandomInt == 0)
        {
            return metal;
        }
        else if(getRandomInt == 1)
        {
            return oil;
        }
        else if(getRandomInt == 2)
        {
            return mineral;
        }
        else
        {
            return new String[]{"ERROR"};
        }

    }
}