package Lab;

import java.util.Enumeration;
import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double totalMoney = 0;

        while (!input.equals("NoMoreMoney")) {
            double sum = Double.parseDouble(input);

            if (sum < 0) {
                System.out.println("Invalid operation!");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", sum);
                totalMoney = totalMoney + sum;
                input = scan.nextLine();
            }
        }
        System.out.printf("Total: %.2f", totalMoney);
    }

}
