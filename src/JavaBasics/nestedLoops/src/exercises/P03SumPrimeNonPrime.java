package EXERCISE;

import java.util.Scanner;

public class P03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int prime = 0;
        int nonPrime = 0;

        while (!input.equals("stop")) {
            int num = Integer.parseInt(input);

            if (num < 0) {
                System.out.println("Number is negative.");
                input = scan.nextLine();
                continue;
            }

            int count = 0;
            for (int i = 1; i <= num ; i++) {
                if (num % i == 0) {
                    count++;
                }
            }

            if (count == 2) {
                prime = prime + num;
            } else {
                nonPrime = nonPrime + num;
            }


            input = scan.nextLine();

        }
        System.out.printf("Sum of all prime numbers is: %d%n", prime);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrime);
    }
}
