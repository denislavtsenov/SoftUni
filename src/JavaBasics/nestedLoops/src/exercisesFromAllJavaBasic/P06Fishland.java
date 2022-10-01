package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P06Fishland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceOfMackerel = Double.parseDouble(scan.nextLine());
        double priceOfSprat = Double.parseDouble(scan.nextLine());
        double kgOfBonito = Double.parseDouble(scan.nextLine());
        double kgOfScad = Double.parseDouble(scan.nextLine());
        int kgOfMussels = Integer.parseInt(scan.nextLine());

        double priceOfBonito = kgOfBonito * (priceOfMackerel + (priceOfMackerel * 0.6));
        double priceOfScad = kgOfScad * (priceOfSprat + (priceOfSprat * 0.8));
        double priceOfMussels = kgOfMussels * 7.50;

        double totalSum = priceOfBonito + priceOfScad + priceOfMussels;

        System.out.printf("%.2f", totalSum);
    }
}
