package RegularyExam;

import java.util.Scanner;

public class P06GoldMine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countLocations = Integer.parseInt(scan.nextLine());

        double averageGold = 0;
        double totalGoldPerDay = 0;
        double avgGoldPerDay = 0;

        for (int i = 1; i <= countLocations; i++) {
            totalGoldPerDay = 0;
            averageGold = Double.parseDouble(scan.nextLine());
            int countDays = Integer.parseInt(scan.nextLine());
            for (int j = 1; j <= countDays; j++) {
                double goldPerDay = Double.parseDouble(scan.nextLine());
                totalGoldPerDay = totalGoldPerDay + goldPerDay;

            }
            avgGoldPerDay = totalGoldPerDay / countDays;
            double diff = Math.abs(averageGold - avgGoldPerDay);

            if (avgGoldPerDay >= averageGold) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", avgGoldPerDay);
            } else {
                System.out.printf("You need %.2f gold.%n", diff);
            }
        }

    }

}
