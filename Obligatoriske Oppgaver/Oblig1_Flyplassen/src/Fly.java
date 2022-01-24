import java.util.ArrayList;
import java.util.Random;

public class Fly {

    private int id;
    private String name;
    private String type;
    private String produsent;
    private int mannskap;
    private int passasjerer;
    private double lengde;
    private double høyde;
    private double vingespenn;
    private double vekt;

    private String getRandomType () {
        ArrayList<String> values = new ArrayList<>();
        values.add("Turbo plane");
        values.add("Piston plane");
        values.add("Jet");
        values.add("Light jet");
        values.add("Mid-size jet");
        values.add("Jumbo jet");
        values.add("Narrow body");
        values.add("Wide body");
        values.add("Airbus");
        values.add("Millitary");
        values.add("Fighter");
        values.add("Water bomb");
        values.add("Maritime");
        int SIZE = values.size();
        Random RANDOM = new Random();

        return values.get(RANDOM.nextInt(SIZE));
    }

    private String getRandomProdusent () {
        ArrayList<String> values = new ArrayList<>();
        values.add("Boeing");
        values.add("Airbus");
        values.add("Embraer");
        values.add("Bombardier");
        values.add("Comac");
        values.add("Mitsubishi");
        values.add("UAC");
        values.add("Norwegian");
        int SIZE = values.size();
        Random RANDOM = new Random();

        return values.get(RANDOM.nextInt(SIZE));
    }

    public static String getRandomName() {
        ArrayList<String> values = new ArrayList<>();
        values.add("Boeing373");
        values.add("Norwegian 124AA4");
        values.add("Embraer1663");
        values.add("Bombardier43");
        values.add("Comac");
        values.add("Mitsubishi K4343");
        values.add("UAC KUMA123");
        int SIZE = values.size();
        Random RANDOM = new Random();

        return values.get(RANDOM.nextInt(SIZE));
    }

    private static float randFloat(float min, float max) {
        Random rand = new Random();
        return rand.nextFloat() * (max - min) + min;
    }

    private static int randInt (int min, int max) {
        Random rand = new Random();
        return rand.nextInt() * (max - min) + min;
    }

    public Fly(int id) {
        this.id = id;
        name = getRandomName();
        type = getRandomType();
        høyde = randFloat(2,10);
        lengde = randFloat(2, 100);
        vingespenn = randFloat(2,40);
        vekt = randFloat(100, 100000);
        mannskap = randInt(1, 20);
        passasjerer = randInt(1,2000);
        produsent = getRandomProdusent();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getProdusent() {
        return produsent;
    }

    public int getMannskap() {
        return mannskap;
    }

    public int getPassasjerer() {
        return passasjerer;
    }

    public double getLengde() {
        return lengde;
    }

    public double getHøyde() {
        return høyde;
    }

    public double getVingespenn() {
        return vingespenn;
    }

    public double getVekt() {
        return vekt;
    }

    @Override
    public String toString() {
        return getName();
    }
}
