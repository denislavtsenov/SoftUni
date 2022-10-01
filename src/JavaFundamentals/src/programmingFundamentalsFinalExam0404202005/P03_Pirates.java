package ProgrammingFundamentalsFinalExam0404202005;

import java.util.*;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();

        String inputCities = scanner.nextLine();
        while (!inputCities.equals("Sail")) {
            String[] cities = inputCities.split("\\|\\|");
            String city = cities[0];
            int population = Integer.parseInt(cities[1]);
            int gold = Integer.parseInt(cities[2]);

            if (!citiesMap.containsKey(city)) {
                citiesMap.put(city, new ArrayList<>());
                citiesMap.get(city).add(0, population);
                citiesMap.get(city).add(1, gold);
            } else {
                int currentPopulation = citiesMap.get(city).get(0);
                int currentGold = citiesMap.get(city).get(1);

                citiesMap.get(city).set(0, currentPopulation + population);
                citiesMap.get(city).set(1, currentGold + gold);
            }
            inputCities = scanner.nextLine();
        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("End")) {
            String[] commands = inputLine.split("=>");
            String command = commands[0];
            String town = commands[1];

            int currentPopulation = citiesMap.get(town).get(0);
            int currentGold = citiesMap.get(town).get(1);
            switch (command) {

                case "Plunder":
                    int numberOfPeople = Integer.parseInt(commands[2]);
                    int stealGold = Integer.parseInt(commands[3]);
                    int populationAfterAttack = currentPopulation - numberOfPeople;
                    int goldAfterAttack = currentGold - stealGold;

                    citiesMap.get(town).set(0, populationAfterAttack);
                    citiesMap.get(town).set(1, goldAfterAttack);

                    System.out.printf("%s plundered! %s gold stolen, %s citizens killed.%n", town, stealGold, numberOfPeople);

                    if (populationAfterAttack <= 0 || goldAfterAttack <= 0) {
                        citiesMap.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;

                case "Prosper":
                    int amountOfGold = Integer.parseInt(commands[2]);

                    if (amountOfGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int totalGold = amountOfGold + currentGold;
                        citiesMap.get(town).set(1, totalGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                amountOfGold, town, totalGold);
                    }
                    break;
            }
            inputLine = scanner.nextLine();
        }

        if (citiesMap.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());

            for (Map.Entry<String, List<Integer>> entry : citiesMap.entrySet()) {
                String town = entry.getKey();
                int population = entry.getValue().get(0);
                int gold = entry.getValue().get(1);

                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        town, population, gold);
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }


    }
}
