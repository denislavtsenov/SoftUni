package ExercisesFromAllJavaBasic.ExamPreparation;

import java.util.Scanner;

public class P02Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int countVideoCards = Integer.parseInt(scan.nextLine());
        int countProcessors = Integer.parseInt(scan.nextLine());
        int countRam = Integer.parseInt(scan.nextLine());

        double sumVideoCards = countVideoCards * 250;
        double sumProcessors = countProcessors * sumVideoCards * 0.35;
        double sumRam = countRam * sumVideoCards * 0.10;

        double totalSum = sumVideoCards + sumProcessors + sumRam;

        if (countVideoCards > countProcessors) {
            totalSum = totalSum * 0.85;
        }
        double diff = Math.abs(budget - totalSum);
        if (budget >= totalSum) {
            System.out.printf("You have %.2f leva left!", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", diff);
        }
    }
}
