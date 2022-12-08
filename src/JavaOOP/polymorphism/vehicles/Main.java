package JavaOOP.polymorphism.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carConsumption = Double.parseDouble(carInfo[2]);

        Vehicle car = new Car(carFuelQuantity, carConsumption);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckConsumption = Double.parseDouble(truckInfo[2]);

        Vehicle truck = new Truck(truckFuelQuantity, truckConsumption);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            String typeVehicle = commands[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commands[2]);
                    if ("Car".equals(typeVehicle)) {
                        System.out.println(car.drive(distance));
                    } else if ("Truck".equals(typeVehicle)) {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commands[2]);
                    if ("Car".equals(typeVehicle)) {
                        car.refuel(liters);
                    } else if ("Truck".equals(typeVehicle)) {
                        truck.refuel(liters);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
