package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int km = Integer.parseInt(scan.nextLine());
        String dayOrNight = scan.nextLine();

        double tax = 0;
        if (dayOrNight.equals("day")) {
            if (km < 20) {
                tax = 0.70 + km * 0.79;
            } else if (km < 100) {
                tax = km * 0.09;
            } else {
                tax = km * 0.06;
            }
        } else if (dayOrNight.equals("night")) {
            if (km < 20) {
                tax = 0.70 + km * 0.90;
            } else if (km < 100) {
                tax = km * 0.09;
            } else {
                tax = km * 0.06;
            }
        }
        System.out.printf("%.2f", tax);
    }
}
