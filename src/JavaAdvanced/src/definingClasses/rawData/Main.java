package JavaAdvanced.src.definingClasses.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputInfo = scanner.nextLine().split("\\s+");
            String model = inputInfo[0];
            int engineSpeed = Integer.parseInt(inputInfo[1]);
            int enginePower = Integer.parseInt(inputInfo[2]);
            int cargoWeight = Integer.parseInt(inputInfo[3]);
            String cargoType = inputInfo[4];
            double tire1Pressure = Double.parseDouble(inputInfo[5]);
            int tire1Age = Integer.parseInt(inputInfo[6]);
            double tire2Pressure = Double.parseDouble(inputInfo[7]);
            int tire2Age = Integer.parseInt(inputInfo[8]);
            double tire3Pressure = Double.parseDouble(inputInfo[9]);
            int tire3Age = Integer.parseInt(inputInfo[10]);
            double tire4Pressure = Double.parseDouble(inputInfo[11]);
            int tire4Age = Integer.parseInt(inputInfo[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire0 = new Tire(tire1Pressure, tire1Age);
            Tire tire1 = new Tire(tire2Pressure, tire2Age);
            Tire tire2 = new Tire(tire3Pressure, tire3Age);
            Tire tire3 = new Tire(tire4Pressure, tire4Age);

            List<Tire> tires = new ArrayList<>();
            tires.add(tire0);
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);

                Car car = new Car(model, engine, cargo, tires);
                cars.add(car);

        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
           cars.stream()
                    .filter(car -> car.getCargo().equals(cargoType))
                   .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                   .forEach(System.out::println);



        } else if (cargoType.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getCargo().equals(cargoType))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(System.out::println);
        }

    }
}
