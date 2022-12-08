package JavaOOP.examRetake09April2022.fairyShop.models;

public class Sleepy extends BaseHelper{
    private int energy;

    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {
        if (this.energy - 15 < 0) {
            energy = 0;
        } else {
            this.energy -= 15;
        }
    }
}
