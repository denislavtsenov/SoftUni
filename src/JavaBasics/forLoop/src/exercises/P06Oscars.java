package EXERCISE;

import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String actorName = scan.nextLine();
        double points = Double.parseDouble(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        double totalPoints = points;
        for (int i = 1; i <= n; i++) {
            String evaluate = scan.nextLine();
            double pointFromOthers = Double.parseDouble(scan.nextLine());

                double currentPoints = ((evaluate.length() * pointFromOthers) / 2);

                if (totalPoints < 1250.5) {
                    totalPoints = totalPoints + currentPoints;
                }



        }

        double diff = Math.abs(1250.5 - totalPoints);

        if (totalPoints > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints );
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, diff);
        }
    }
}