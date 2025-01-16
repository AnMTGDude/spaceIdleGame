package Populate;

import Materials.Materials;

import java.util.Random;

/**
 * Planet class that has a chance of being created when user clicks advance
 * button
 */
public class Planet
{
    public String[] planetList = new String[]{
            "Ningihines", "Mostriuvis", "Latreshan", "Gizurn", "Iolia", "Xuanov", "Mulonus", "Grochephus",
            "Vippe N4X", "Niea OEL", "Postrotune", "Mabbougawa", "Tutheon", "Lilvarvis", "Xiumia", "Nelara",
            "Grianerth", "Stroyecury", "Vides Q403", "Chides N22W", "Mocopra", "Vigiohiri", "Otrion", "Hediuq",
            "Veomia", "Seiter", "Trudater", "Githunope", "Thora 1G92", "Goria YLPY", "Olmestea", "Hagopra",
            "Yugichi", "Yognarth", "Zemia", "Veitania", "Strebotera", "Lozolia", "Drarth 107", "Gore G6G",
            "Lilvealiv", "Azauhiri", "Ulniri", "Sadippe", "Rucury", "Mephus", "Trorustea", "Lladinides",
            "Dryria CD7C", "Strilia 6S9", "Matreorus", "Thastruvis", "Cinkolla", "Zagnurn", "Nauter", "Vonus",
            "Gnilonides", "Traciria", "Drosie K9", "Phara WPI", "Almaonerth", "Bobreoyama", "Ollerth", "Tindadus",
            "Dunus", "Nevis", "Dreralia", "Cruopra", "Gyke JUF8", "Thillon 9ZU", "Thacrutania", "Listriter",
            "Velviri", "Lanrinda", "Saiter", "Maohiri", "Brulutune", "Truthanov", "Zarth 631", "Grone S0LE",
            "Tobruria", "Lecounia", "Nichosie", "Dondone", "Rienus", "Burilia", "Sogustea", "Griirilia",
            "Gadus ORA1", "Dyke 947", "Kophealara", "Lebbeopra", "Itrarth", "Bodrilles", "Xaclite", "Goter",
            "Crebonides", "Thuuwei", "Gromia XZ8Z", "Thuna S0C5", "Vachiliv", "Etheutov", "Yungore", "Ginruna",
            "Uastea", "Otera", "Groveter", "Zemanides", "Cheshan DUA", "Bypso J8D", "Xucroria", "Sibrayama",
            "Nungade", "Xiphides", "Xueliv", "Ohines", "Drinunus", "Gitonides", "Varvis HE", "Gryria 0WD",
            "Yulueyama", "Zogrophus", "Dibborth", "Senerth", "Giagantu", "Olia", "Meugawa", "Cilatov",
            "Phiri JL", "Thilles 8V4", "Hodreamia", "Yiphiter", "Mugrov", "Idreron", "Uagantu", "Thilea",
            "Gipatune", "Degatune", "Cao 55R", "Brorth 7",     "Alvorix", "Belsor", "Craylith", "Duvaris", "Eglorix",
            "Fenthora", "Galmara", "Harnoth", "Iseron", "Junoza",
            "Kynthar", "Lerrius", "Mynorix", "Nytheron", "Otheon", "Pyrathis", "Quellian", "Rhalmar", "Sythera", "Thalaris",
            "Udrith", "Vanthera", "Wylrix", "Xaldris", "Ygronix", "Zephyron", "Atonel", "Braxan", "Cyrenith", "Drelion",
            "Ekrixia", "Faleris", "Gindor", "Harvol", "Iserith", "Jalaros", "Koritha", "Lanthez", "Mardov", "Norvix",
            "Othara", "Perythos", "Quenath", "Rylithan", "Sildron",
            "Therionis", "Vendarith", "Wrylanos", "Xuloth",
            "Yavandor", "Zotharix", "Arvathos", "Boryxen", "Cyndaris", "Drevoth", "Eylithar", "Falstir", "Galtharion", "Hothol",
            "Icarion", "Jenthur", "Kalvoren", "Lorvath", "Mothraxa", "Nialoth", "Oltrix", "Pyrithal", "Qytheros", "Rhelixan",
            "Sytharoth", "Terilith", "Unarvix", "Vexloth", "Wilaron", "Xandon", "Ygros", "Zerithor", "Aelthor", "Baeloria",
            "Cezivor", "Dorathil", "Ebaros", "Fextara", "Gralonis", "Heliorith", "Ilithar", "Jalrune", "Karthios", "Loryxian",
            "Mavoneth", "Nethirith", "Othrinis", "Praxioth", "Qelron", "Rorathos", "Sylthar", "Tirxoth", "Ulviron", "Vynthol",
            "Wewyphar", "Xuronis", "Ytheron", "Zynok", "Astralon", "Brystar", "Cyrindar", "Darathar", "Elvothar", "Faldira",
            "Gorthan", "Ilyon", "Jivara", "Kolthar", "Lendros", "Mersira", "Ninathar", "Ophos", "Pherolan", "Quithal",
            "Rezosian", "Shornath", "Telarion", "Ulstaria", "Vorinthus", "Wiphor", "Xithora", "Yenath", "Zaraon", "Altrix",
            "Briolth", "Cingora", "Dythora", "Ethiron", "Fenerith", "Gildron", "Huvorn", "Ilrath", "Jytha", "Kervos",
            "Lanthor", "Murnox", "Nyronia", "Orilith", "Pytros", "Qymnoria", "Rethura", "Sivath", "Tethior", "Uthronis",
            "Vathana", "Wolthar", "Xenvora", "Ytolos", "Zhyron", "Azython", "Brenthora", "Cenoryn", "Dorthal", "Ethrion",
            "Fhoras", "Grakori", "Hylvia", "Ithrox", "Jharulon", "Kronthia", "Lerithos", "Menthora", "Norilith", "Orkvan",
            "Pyrissian", "Quasarix", "Ruldrith", "Syrenith", "Talonar", "Ugoris", "Vydron", "Wethoth", "Xidron", "Yltaris",
            "Zarothis", "Anthera", "Bavathis", "Ciraxar", "Dilonith", "Ethalith", "Fynxoria", "Grosnia", "Hidaros", "Inovrin",
            "Jeralix", "Kalthor", "Liramar", "Mivalon", "Nenvora", "Olivis", "Pharora", "Quidera", "Rysalon", "Surnith",
            "Tavranis", "Ulorix", "Valdera", "Wovathis", "Xaderoth", "Yviron", "Zyloth", "Anronia", "Bravalor", "Cindras",
            "Draezar", "Evlirith", "Fornas", "Glothra", "Hidrona", "Itharion", "Jurelith", "Karnor", "Lunavon", "Mylethos",
            "Norviron", "Olovern", "Plathros", "Quelloria", "Rivonir", "Sydoris", "Thavalor", "Uviron", "Veyloth", "Wocora",
            "Xyros", "Ythrona", "Zarveros", "Aivon", "Brelian", "Celnor", "Dharor", "Elvinas", "Firanth", "Giltharos",
            "Horrith", "Intheron", "Jivroth", "Kyloth", "Lysol", "Mavrix", "Nixolos", "Orithos", "Parior", "Quezala",
            "Ravonith", "Sithal", "Tygoron", "Urion", "Vothir", "Wynora", "Xalonis", "Ylira", "Zythran", "Altheron",
            "Bralithos", "Cavorth", "Deyronis", "Enorath", "Ferilith", "Goronar", "Haxor", "Illior", "Jalith", "Kovira",
            "Lurithal", "Marneth", "Nevethan", "Oberix", "Plyxor", "Qandros", "Rhenalith", "Sithron", "Tivarth", "Ulvenar",
            "Vesol", "Wirthor", "Xenarian", "Yuroth", "Zymoran", "Aelvon", "Blaron", "Cinthara", "Dahlith", "Ezzanoth",
            "Farthor", "Glomarith", "Halvon", "Ishor", "Jonaric", "Klyon", "Lirthos", "Malvor", "Naltheron", "Onerix",
            "Phelan", "Qerith", "Rynix", "Selyris", "Talviris", "Unorath", "Vandros", "Wenoth", "Xilvora", "Ytrith",
            "Zalithor", "Averis", "Borithor", "Clytos", "Dlython", "Enarion", "Ferenor", "Gevros", "Halikron", "Ikrana",
            "Jalvian", "Kylan", "Lethon", "Morthana", "Nylith", "Oliron", "Pelys", "Qathal", "Rheon", "Sundon",
            "Teryos", "Ulan", "Vachthar", "Wylvin", "Xylion", "Ylathar", "Zorath", "Anithor", "Bovath", "Cernor",
            "Doroth", "Ephron", "Felith", "Galon", "Heran", "Iralon", "Jeryn", "Kothros", "Lorion", "Marin",
            "Narthis", "Orathus", "Peylor", "Quinx", "Rythros", "Seryx",
            "Tephon", "Ukanos", "Vothis", "Walyth", "Aetheron", "Bravix", "Cynolis", "Drosmos", "Fenrioth", "Galvoria", "Horlith", "Ivaris", "Jelthor",
            "Kithlar", "Lirionis", "Morthar", "Nyrithos", "Ogalon", "Perthox", "Quyros", "Rhalos", "Sivaron", "Tiradros",
            "Uphalon", "Velothar", "Wynkros", "Xandura", "Ylenor", "Zyphoria", "Aleroth", "Benvith", "Cyralith", "Drathoros",
            "Erithol", "Fornalis", "Golvas", "Hedris", "Irythos", "Jynthor", "Kaldorix", "Lyrithon", "Mylorian", "Norvex",
            "Oltharion", "Pernothis", "Quiralon", "Rydarion", "Sylvothar", "Thyros", "Urvoris", "Valanoth", "Wexarith", "Xylphar",
            "Yvorix", "Zerathor", "Aulian", "Balthorix", "Corynith", "Dravenix", "Eryxos", "Fothrion", "Gavarin", "Hekrion",
            "Ilionar", "Jexon", "Klarin", "Lorathos", "Mithron", "Nephalon", "Oridor", "Phalonis", "Quenoth", "Rylian",
            "Stharion", "Tavonis", "Ulindor", "Vorixian", "Wenthros", "Xilgaron", "Yllion", "Zethros", "Anovar", "Baldira",
            "Cavorith", "Darakon", "Elvithon", "Faralon", "Galyron", "Henthri", "Jylos", "Kovinor", "Lothonix",
            "Maviron", "Narvoth", "Olyron", "Phelron", "Qenathor", "Rynoras", "Satharion", "Tixanor", "Uvorian", "Worixol",
            "Xarom", "Yaroth", "Zelthor", "Amalis", "Bovinor", "Cythros", "Drioth", "Erionix", "Firosol", "Galvinar",
            "Hevathor", "Ilandros", "Jothlor", "Kornis", "Lophar", "Motharion", "Nothen", "Orythos", "Pralar", "Qarathis"
    };

    String[] planetTypes = new String[]{
            "Lush", "Frozen", "Toxic", "Radioactive", "Desert", "Scorched",
            "Barren", "Ocean", "Exotic", "Overgrown", "Dead", "Hot",
            "Wet", "Grassy"
    };

    // Variables
    String name = "ERROR";
    boolean habitable = false; /* decided based on temp and air*/
    boolean air; /* planet is habitable if the air is true not habitable if
    false. Randomly generated*/
    int temperature; /* randomly generated. planet is habitable depending
    on what type of suits the player has.  Standard is uninhabitable below
    -200F and above 200F*/
    String size; /* Change before flight (No use at the moment, saving this
    for when the program gets further along */
    String descriptiveTextSize; // Puts size into perspective (small, medium, 
    // big)
    String[] materials; /* the materials on the planet. This needs
    work*/
    boolean mined = false;
    String planetType;
    boolean populated = false;

    // Constructors


    public Planet()
    {
        // Creates two numbers 0 and 1 and if it's 0 the air is breathable
        int airRandomInt = (int) (Math.random() * 1);
        if(airRandomInt == 0)
        {
            this.air = true;
        }
        else
        {
            this.air = false;
        }

        // Generates a random temperature between -400 and 400
        int temperatureInt = new Random().nextInt((400 + 400)) - 400;
        this.temperature = temperatureInt;

        //
        int sizeInt = (int) (Math.random() * 200000) + 1000;
        this.size = sizeInt + "km";
//      this.materials = materials; Change before flight

        if(this.air && this.temperature <= 200 && temperatureInt >= -200)
        {
            this.habitable = true;
        }
        if(sizeInt < 2300)
        {
            this.descriptiveTextSize = "dwarf";
        }
        if(sizeInt < 10000 && sizeInt > 2300)
        {
            this.descriptiveTextSize = "small";
        }
        if(sizeInt > 10000 && sizeInt < 25000)
        {
            this.descriptiveTextSize = "medium";
        }
        if(sizeInt > 25000 && sizeInt < 190000)
        {
            this.descriptiveTextSize = "large";
        }
        if(sizeInt > 190000)
        {
            this.descriptiveTextSize = "super-giant";
        }

        int planetNameInt = (int) (Math.random() * planetList.length);
        this.name = planetList[planetNameInt];

        materials = Materials.getRandom();

        int planetTypeInt = (int) (Math.random() * planetTypes.length);

        this.planetType = planetTypes[planetTypeInt];
    }

    // Getters
    public boolean isHabitable()
    {
        return habitable;
    }

    public boolean isAir()
    {
        return air;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public String getSize()
    {
        return size;
    }

    public String getName()
    {
        return name;
    }

    public String getDescriptiveTextSize()
    {
        return descriptiveTextSize;
    }

    public String getMaterials()
    {
        return materials[1];
    }

    public String getPlanetType()
    {
        return planetType;
    }

    public void setPopulated(boolean populated)
    {
        this.populated = populated;
    }

    public boolean getPopulated()
    {
        return populated;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + '\n' +
                "Habitable: " + habitable + "\n" +
                "Air: " + air + "\n" +
                "Temperature: " + temperature + "°F" + "\n" +
                "Size: " + size + '\n' +
                "Size classification: " + descriptiveTextSize + '\n' +
                "Materials: " + getMaterials() + "\n" +
                "Planet type: " + planetType;
    }
}