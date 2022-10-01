package Excerices;

import java.util.Scanner;

public class EX5_SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pens = Integer.parseInt(scan.nextLine());
        int markers = Integer.parseInt(scan.nextLine());
        int razr = Integer.parseInt(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());

        double pensPrice = pens * 5.80;
        double markersPrice = markers * 7.20;
        double razrPrice = razr * 1.20;
        double totalPrice = pensPrice + markersPrice + razrPrice;
        double priceWithDiscount = totalPrice - (totalPrice * percent / 100);

        System.out.println(priceWithDiscount);

    }
}
