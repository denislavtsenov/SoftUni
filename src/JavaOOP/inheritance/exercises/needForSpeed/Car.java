package JavaOOP.inheritance.exercises.needForSpeed;

public class Car extends Vehicle{
    protected static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }
}
