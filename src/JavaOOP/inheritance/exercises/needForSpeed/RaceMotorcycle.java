package JavaOOP.inheritance.exercises.needForSpeed;

public class RaceMotorcycle extends Motorcycle{
    protected static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }
}
