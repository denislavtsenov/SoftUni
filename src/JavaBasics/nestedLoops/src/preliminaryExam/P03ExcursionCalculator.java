package PreliminaryExam;

import java.util.Scanner;

public class P03ExcursionCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countPeople = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();

        double pricePerPerson = 0;


        if (countPeople <= 5) {
            switch (season) {
                case "spring":
                    pricePerPerson = 50.00;
                    break;

                case "summer":
                    pricePerPerson = 48.50;
                    break;

                case "autumn":
                    pricePerPerson = 60.00;
                    break;

                case "winter":
                    pricePerPerson = 86.00;
                    break;
            }
        } else {
            switch (season) {
                case "spring":
                    pricePerPerson = 48.00;
                    break;

                case "summer":
                    pricePerPerson = 45.00;
                    break;

                case "autumn":
                    pricePerPerson = 49.50;
                    break;

                case "winter":
                    pricePerPerson = 85.00;
                    break;
            }
        }

        if (season.equals("summer")) {
            pricePerPerson = pricePerPerson * 0.85;
        } else if (season.equals("winter")) {
            pricePerPerson = pricePerPerson * 1.08;
        }

        double totalPrice = pricePerPerson * countPeople;

        System.out.printf("%.2f leva.", totalPrice);
    }
}
