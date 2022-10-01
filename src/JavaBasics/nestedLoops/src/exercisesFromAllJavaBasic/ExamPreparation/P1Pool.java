package ExercisesFromAllJavaBasic.ExamPreparation;

import java.util.Scanner;

public class P1Pool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scan.nextLine());
        double taxIn = Double.parseDouble(scan.nextLine());
        double pricePerDeckchair = Double.parseDouble(scan.nextLine());
        double pricePerUmbrella = Double.parseDouble(scan.nextLine());

        double sumTaxIn = peopleCount * taxIn;
        double countDeckchair = Math.ceil(peopleCount * 0.75);
        double sumDeckchair = countDeckchair * pricePerDeckchair;
        double totalUmbrellaCount = Math.ceil(peopleCount * 0.5);
        double sumUmbrella = totalUmbrellaCount * pricePerUmbrella;

        double totalSum = sumTaxIn + sumDeckchair + sumUmbrella;

        System.out.printf("%.2f lv.", totalSum);
    }
}
