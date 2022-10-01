package ExercisesFromAllJavaBasic.ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int juniorsCount = Integer.parseInt(scan.nextLine());
        int seniorsCount = Integer.parseInt(scan.nextLine());
        String typeRoad = scan.nextLine();

        double totalCount = juniorsCount + seniorsCount;
        double totalSum = 0;

        switch (typeRoad) {
            case "trail":
                totalSum = (juniorsCount * 5.5) + (seniorsCount * 7);
                break;
            case "cross-country":
                totalSum = (juniorsCount * 8) + (seniorsCount * 9.5);

                if (totalCount >= 50) {
                    totalSum = totalSum * 0.75;
                }
                break;
            case "downhill":
                totalSum = (juniorsCount * 12.25) + (seniorsCount * 13.75);
                break;
            case "road":
                totalSum = (juniorsCount * 20) + (seniorsCount * 21.50);
                break;
        }
        double tax = totalSum * 0.05;
        double donation = totalSum - tax;

        System.out.printf("%.2f", donation);
    }
}
