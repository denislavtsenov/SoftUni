package JavaAdvanced.src.definingClasses.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();

        int numbersOfEngines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersOfEngines; i++) {
            String[] inputInfo = scanner.nextLine().split("\\s+");
            String model = inputInfo[0];
            String power = inputInfo[1];

            Engine engine = null;

            switch (inputInfo.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    char firstChar = inputInfo[2].charAt(0);
                    if (Character.isDigit(firstChar)) {
                        String displacement = inputInfo[2];
                        engine = new Engine(model, power, displacement, "n/a");
                    } else {
                        String efficiency = inputInfo[2];
                        engine = new Engine(model, power, "n/a", efficiency);
                    }
                    break;
                case 4:
                    String displacement = inputInfo[2];
                    String efficiency = inputInfo[3];

                    engine = new Engine(model, power, displacement, efficiency);
                    break;

            }
            engines.add(engine);
        }

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] inputCarInfo = scanner.nextLine().split("\\s+");
            String model = inputCarInfo[0];
            String engineName = inputCarInfo[1];

            Car car = null;

            Engine engine = null;
            for (Engine engine1 : engines) {
                String engineToCompare = engine1.getModel();
                if (engineToCompare.equals(engineName)) {
                    engine = engine1;
                    break;
                }
            }

            switch (inputCarInfo.length) {
                case 2:
                    car = new Car(model, engine, "n/a", "n/a");
                    break;

                case 3:
                    char firstChar = inputCarInfo[2].charAt(0);
                    if (Character.isDigit(firstChar)) {
                        String weight = inputCarInfo[2];
                        car = new Car(model, engine, weight, "n/a");
                    } else {
                        String color = inputCarInfo[2];
                        car = new Car(model, engine, "n/a", color);
                    }
                    break;
                case 4:
                    String weight = inputCarInfo[2];
                    String color = inputCarInfo[3];

                    car = new Car(model, engine, weight, color);
                    break;
            }

            cars.add(car);
        }

        for (Car car : cars) {

            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().getModel() + ":");
            System.out.println("Power: " + car.getEngine().getPower());
            System.out.println("Displacement: " + car.getEngine().getDisplacement());
            System.out.println("Efficiency: " + car.getEngine().getEfficiency());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());

        }
    }
}
