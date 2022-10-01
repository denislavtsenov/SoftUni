package EXERCISE;

import java.util.Scanner;

public class P08TennisRanklist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countTournaments = Integer.parseInt(scan.nextLine());
        int initPoints = Integer.parseInt(scan.nextLine());

        int points = 0;
        double wins = 0;

        for (int i = 1; i <= countTournaments ; i++) {
            String type = scan.nextLine();

            switch (type) {
                case "W":
                    wins++;
                    points += 2000;
                    break;
                case "F":
                    points += 1200;
                    break;
                case "SF":
                    points += 720;
                    break;
            }
        }
        int totalPoints = initPoints + points;
        int average = points / countTournaments;
        double percent = wins / countTournaments * 100;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %.0f%n", Math.floor(average));
        System.out.printf("%.2f%%", percent);
    }
}
