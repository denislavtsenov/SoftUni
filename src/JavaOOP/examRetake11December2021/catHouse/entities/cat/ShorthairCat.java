package JavaOOP.examRetake11December2021.catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int INITIAL_KG = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(INITIAL_KG);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }
}
