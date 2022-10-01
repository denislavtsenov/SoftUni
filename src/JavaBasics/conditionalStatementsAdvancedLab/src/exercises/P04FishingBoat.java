package EXERCISES;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());

        double rent = 0;

        switch (season) {
            case "Spring":
                rent = 3000;
                if (count <= 6) {
                    rent = rent * 0.9;
                } else if (count <= 11) {
                    rent = rent * 0.85;
                } else {
                    rent = rent * 0.75;
                }
                break;
            case "Summer":
            case "Autumn":
                rent = 4200;
                if (count <= 6) {
                    rent = rent * 0.9;
                } else if (count <= 11) {
                    rent = rent * 0.85;
                } else {
                    rent = rent * 0.75;
                }
                break;
            case "Winter":
                rent = 2600;
                if (count <= 6) {
                    rent = rent * 0.9;
                } else if (count <= 11) {
                    rent = rent * 0.85;
                } else {
                    rent = rent * 0.75;
                }
                break;
        }

        if (count % 2 == 0) {
            if(season.equals("Autumn")) {
                rent = rent;
            } else {
                rent = rent - (rent * 0.05);
            }
        }

        Double diff = Math.abs(budget - rent);

        if (budget >= rent) {
            System.out.printf ("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }

    }
}
