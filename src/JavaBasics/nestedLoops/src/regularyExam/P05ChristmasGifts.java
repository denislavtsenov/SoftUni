package RegularyExam;

import java.util.Scanner;

public class P05ChristmasGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countAdults = 0;
        int countKids = 0;

        String input = scan.nextLine();
        while (!input.equals("Christmas")) {
            int years = Integer.parseInt(input);

            if (years <= 16) {
                countKids++;
            } else {
                countAdults++;
            }

            input = scan.nextLine();
        }
        double sumForAdults = countAdults * 15;
        double sumForKids = countKids * 5;

        System.out.printf("Number of adults: %d%n", countAdults);
        System.out.printf("Number of kids: %d%n", countKids);
        System.out.printf("Money for toys: %.0f%n", sumForKids);
        System.out.printf("Money for sweaters: %.0f%n", sumForAdults);
    }
}
