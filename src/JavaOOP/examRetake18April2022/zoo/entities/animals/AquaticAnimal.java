package JavaOOP.examRetake18April2022.zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, 2.50, price);
        setKg(2.50);
    }


    @Override
    public void eat() {
        double newKg = getKg() + 7.50;
        setKg(newKg);
    }
}
