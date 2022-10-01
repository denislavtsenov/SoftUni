package Exercises;

import java.util.Scanner;

public class P05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budgetForMovie = Double.parseDouble(scan.nextLine());
        int peopleCount = Integer.parseInt(scan.nextLine());
        double costumePrice = Double.parseDouble(scan.nextLine());

        double decorPrice = budgetForMovie * 0.1;
        if (peopleCount > 150) {
            costumePrice = costumePrice * 0.9;
        }

        double totalCostumePrice = peopleCount * costumePrice;
        double totalSumFilm = totalCostumePrice + decorPrice;
        double totalDiff = Math.abs(budgetForMovie - totalSumFilm);

        if (totalSumFilm > budgetForMovie) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalDiff);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", totalDiff);

        }
    }
}