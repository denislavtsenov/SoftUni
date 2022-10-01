package ProgrammingFundamentalsFinalExam09082020;

import java.util.*;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantsNumber = Integer.parseInt(scanner.nextLine());
        Map<String, PlantData> currentPlants = new LinkedHashMap<>();

        for (int i = 0; i < plantsNumber; i++) {
            String plantText = scanner.nextLine();
            String[] plantParts = plantText.split("<->");
            String plantName = plantParts[0];
            int plantRarity = Integer.parseInt(plantParts[1]);
            PlantData newPlant = new PlantData(new ArrayList<>(), plantRarity);
            currentPlants.put(plantName, newPlant);

        }
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Exhibition")) {
            String[] commands = inputLine.split(": ");
            String command = commands[0];
            String plantName = commands[1].split(" - ")[0];

            if (!currentPlants.containsKey(plantName)) {
                inputLine = scanner.nextLine();
                System.out.println("error");
                continue;
            }

            switch (command) {

                case "Rate":
                    int rating = Integer.parseInt(commands[1].split(" - ")[1]);
                    currentPlants.get(plantName).addRating(rating);
                    break;

                case "Update":
                    int newRarity = Integer.parseInt(commands[1].split(" - ")[1]);
                    currentPlants.get(plantName).setRarity(newRarity);
                    break;

                case "Reset":
                    currentPlants.get(plantName).removeAllRatings();
                    break;

                default:
                    System.out.println("error");
                    break;
            }
            inputLine = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        currentPlants.entrySet().stream().sorted((p1, p2) -> {
            int result = Integer.compare(p2.getValue().getRarity(), p1.getValue().getRarity());
            if (result == 0) {
                result = Double.compare(p2.getValue().getAverageRating(), p1.getValue().getAverageRating());
            }
            return result;
        }).forEach(plant -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                plant.getKey(), plant.getValue().getRarity(), plant.getValue().getAverageRating()));
    }
}

class PlantData {
    private List<Integer> ratings;
    private int rarity;

    public void removeAllRatings() {
        this.ratings.clear();
    }

    public void addRating(int rating) {
        this.ratings.add(rating);
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getRarity() {
        return rarity;
    }

    public double getAverageRating() {
        double sumOfAllRatings = 0;
        for (Integer rating : this.ratings) {
            sumOfAllRatings += rating;
        }
        if (sumOfAllRatings == 0) {
            return 0;
        } else {
            return sumOfAllRatings / this.ratings.size();
        }
    }

    public PlantData(List<Integer> ratings, int rarity) {
        this.ratings = ratings;
        this.rarity = rarity;
    }
}
