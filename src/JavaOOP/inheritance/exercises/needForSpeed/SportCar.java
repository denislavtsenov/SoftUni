package JavaOOP.inheritance.exercises.needForSpeed;

public class SportCar extends Car{
    protected static final double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }
}
