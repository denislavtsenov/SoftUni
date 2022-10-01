package ProgrammingFundamentalsFinalExamRetake10042020;

import java.util.*;

public class P03_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String inputInfo = scanner.nextLine();

            String car = inputInfo.split("\\|")[0];
            int mileage = Integer.parseInt(inputInfo.split("\\|")[1]);
            int fuel = Integer.parseInt(inputInfo.split("\\|")[2]);


            cars.putIfAbsent(car, new ArrayList<>());
            cars.get(car).add(0, mileage);
            cars.get(car).add(1, fuel);
        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Stop")) {
            String command = inputLine.split(" : ")[0];
            String car = inputLine.split(" : ")[1];

            switch (command) {

                case "Drive":
                    int distance = Integer.parseInt(inputLine.split(" : ")[2]);
                    int fuel = Integer.parseInt(inputLine.split(" : ")[3]);

                    int currentFuel = cars.get(car).get(1);
                    int currentMileage = cars.get(car).get(0);
                    int totalDistance = currentMileage + distance;

                    if (currentFuel >= fuel) {

                        int totalFuel = currentFuel - fuel;
                        cars.get(car).set(0, totalDistance);
                        cars.get(car).set(1, totalFuel);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    if (totalDistance >= 100000) {
                        cars.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;

                case "Refuel":
                    int reFuel = Integer.parseInt(inputLine.split(" : ")[2]);
                    int currentFuelBeforeRefuel = cars.get(car).get(1);
                    int totalFuel = currentFuelBeforeRefuel + reFuel;
                    int diff = reFuel;

                    if (totalFuel > 75) {
                        diff = 75 - currentFuelBeforeRefuel;
                        totalFuel = 75;
                    }
                    System.out.printf("%s refueled with %d liters%n", car, diff);
                    cars.get(car).set(1, totalFuel);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(inputLine.split(" : ")[2]);
                    int currentKm = cars.get(car).get(0);
                    int diffKm = currentKm - kilometers;

                    if (diffKm < 10000) {
                        diff = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);

                    }
                    cars.get(car).set(0, diffKm);
                    break;


            }
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
