package Excerices;

import java.util.Scanner;

public class EX6_Repainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nylon = Integer.parseInt(scan.nextLine());
        int paint = Integer.parseInt(scan.nextLine());
        int thinner = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());

        double priceNylon = (nylon + 2) * 1.50;
        double pricePaint = (paint + (paint * 0.1)) * 14.50;
        double priceThinner = thinner * 5;
        double priceBags = 0.4;
        double totalPrice = priceNylon + pricePaint + priceThinner + priceBags;
        double priceWork = (totalPrice * 0.3) * 1;
        double totalSum = totalPrice + priceWork;

        System.out.println(totalSum);

    }
}
