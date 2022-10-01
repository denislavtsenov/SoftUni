package Exercises;

import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int videoCardsCount = Integer.parseInt(scan.nextLine());
        int processorsCount = Integer.parseInt(scan.nextLine());
        int ramCount = Integer.parseInt(scan.nextLine());

        double videoCardsPrice = videoCardsCount * 250;

        double processorsPrice = videoCardsPrice * 0.35;
        double totalProcessorsPrice = processorsCount * processorsPrice;

        double ramPrice = videoCardsPrice * 0.1;
        double totalRamPrice = ramCount * ramPrice;

        double totalPrice = videoCardsPrice + totalProcessorsPrice + totalRamPrice;

        if (videoCardsCount > processorsCount) {
         totalPrice = totalPrice - (totalPrice * 0.15);
        }
        double totalDiff = Math.abs(budget - totalPrice);

        if (budget >= totalPrice) {
            System.out.printf("You have %.2f leva left!", totalDiff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalDiff);
        }

    }
}
