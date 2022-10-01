package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceVeg = Double.parseDouble(scan.nextLine());
        double priceFruits = Double.parseDouble(scan.nextLine());
        int totalKgVeg = Integer.parseInt(scan.nextLine());
        int totalKgFr = Integer.parseInt(scan.nextLine());

        double totalPriceVeg = priceVeg * totalKgVeg;
        double totalPriceFr = priceFruits * totalKgFr;
        double totalPrice = totalPriceFr + totalPriceVeg;

        double priceInEuro = totalPrice / 1.94;

        System.out.printf("%.2f", priceInEuro);
        }
    }

