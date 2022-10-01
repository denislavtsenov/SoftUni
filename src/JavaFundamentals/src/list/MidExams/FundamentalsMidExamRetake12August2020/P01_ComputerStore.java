package List.MidExams.FundamentalsMidExamRetake12August2020;

import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalSumWithoutTax = 0;
        String pricesWithoutTax = scanner.nextLine();
        while (!pricesWithoutTax.equals("special") && !pricesWithoutTax.equals("regular")) {

            double currentPrice = Double.parseDouble(pricesWithoutTax);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                pricesWithoutTax = scanner.nextLine();
                continue;
            }

            totalSumWithoutTax += currentPrice;

            pricesWithoutTax = scanner.nextLine();
        }
        double taxes = totalSumWithoutTax * 0.2;
        double totalSumWithTax = totalSumWithoutTax + taxes;

        if (pricesWithoutTax.equals("special")) {
            totalSumWithTax = totalSumWithTax - (totalSumWithTax * 0.1);
        }

        if (totalSumWithTax == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalSumWithoutTax);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalSumWithTax);
        }
    }
}

