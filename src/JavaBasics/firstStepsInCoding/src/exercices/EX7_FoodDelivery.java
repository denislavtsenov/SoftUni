package Excerices;

import java.util.Scanner;

public class EX7_FoodDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chicken = Integer.parseInt(scan.nextLine());
        int fish = Integer.parseInt(scan.nextLine());
        int vegan = Integer.parseInt(scan.nextLine());

        double priceChicken = chicken * 10.35;
        double priceFish = fish * 12.40;
        double priceVegan = vegan * 8.15;
        double sumMenu = priceChicken + priceFish + priceVegan;
        double priceDessert = sumMenu - (sumMenu * 0.8);
        double priceDelivery = 2.50;
        double totalPrice = sumMenu + priceDessert + priceDelivery;

        System.out.println(totalPrice);

    }
}
