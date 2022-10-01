package List.MidExams.FundamentalsMidExam2662022;

import java.util.Scanner;

public class P01_BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double totalProfit = 0;

        for (int i = 1; i <= n; i++) {
            String nameOfCity = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());

            if (i % 3 == 0 && i % 5 == 0) {
                income = income - (income * 0.1);
            } else if (i % 3 == 0) {
                expenses = expenses + (expenses * 0.5);
            } else if (i % 5 == 0) {
               income = income - (income * 0.1);
            }

            double currentEarnings = income - expenses;

            System.out.printf("In %s Burger Bus earned %.2f leva.%n", nameOfCity, currentEarnings);


            totalProfit += currentEarnings;
        }

        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
