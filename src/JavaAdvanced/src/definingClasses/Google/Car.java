package JavaAdvanced.src.definingClasses.Google;

public class Car {
    private final String model;
    private final int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }
    public String format(){
        return String.format("%s %d",model,speed);
    }
}
