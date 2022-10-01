package Methods.Exercise;

import java.util.Scanner;

public class P08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int firstDigit = Integer.parseInt(sc.nextLine());
        int secondDigit = Integer.parseInt(sc.nextLine());

        System.out.printf("%.2f", 1.0 * factorial(firstDigit) / factorial(secondDigit));
    }

   public static double factorial(int digit) {
        double fact = 1;
        for (int i = 2; i <= digit; i++) {
            fact = fact * i;
        }
        return fact;
    }
}

