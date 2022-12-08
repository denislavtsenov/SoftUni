package JavaOOP.examRetake18April2022.zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{
    private static double KG = 5.50;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    private static double getKG() {
        return KG;
    }

    private static void setKG(double KG) {
        TerrestrialAnimal.KG = KG;
    }

    @Override
    public void eat() {
        double newKg = getKG() + 5.70;
        setKG(newKg);
    }
}
