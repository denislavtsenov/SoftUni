package JavaAdvanced.src.definingClasses.carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        setModel(model);
        setEngine(engine);
        setWeight(weight);
        setColor(color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, "n/a", "n/a");
    }

    public Car(String model, Engine engine, String weight) {
        this(model, engine, weight, "n/a");
    }

//    public Car(String model, String engine, String color) {
//        this(model, engine, "n/a", color);
//
//    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    @Override
//    public String toString() {
//        return String.format("%s:%n", model)
//                + String.format("%s:%n", engine)
//                + String.format("Power: %s%n", engines).trim();

//        Power: {EnginePower}
//        Displacement: {EngineDisplacement}
//        Efficiency: {EngineEfficiency}
//        Weight: {CarWeight}
//        Color: {CarColor}

}

