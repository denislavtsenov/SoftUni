package Exercises;

import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scan.nextLine());
        int puzzleCount = Integer.parseInt(scan.nextLine());
        int dollCount = Integer.parseInt(scan.nextLine());
        int bearCount = Integer.parseInt(scan.nextLine());
        int minionCount = Integer.parseInt(scan.nextLine());
        int truckCount = Integer.parseInt(scan.nextLine());

        double totalPrice = (puzzleCount * 2.60) + (dollCount * 3) + (bearCount * 4.10) + (minionCount * 8.20) + (truckCount * 2);
        int totalCount = puzzleCount + dollCount + bearCount + minionCount + truckCount;

        if (totalCount >= 50) {
            totalPrice = totalPrice - (totalPrice * 0.25);
        }

        totalPrice = totalPrice - (totalPrice * 0.1);

        double moneyLeft = Math.abs(totalPrice - tripPrice);

        if (totalPrice >= tripPrice)  {
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", moneyLeft);
        }

    }
}
