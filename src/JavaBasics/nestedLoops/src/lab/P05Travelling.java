package LAB;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();


        double totalSavings = 0;


        while (!input.equals("End")) {
            String destination = input;
            double budget = Double.parseDouble(scan.nextLine());
            totalSavings = 0;

            while (budget > totalSavings) {
                double savings = Double.parseDouble(scan.nextLine());
                totalSavings = savings + totalSavings;
            }
            System.out.printf("Going to %s!%n", destination);
            input = scan.nextLine();


        }

    }
}
