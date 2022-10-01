package Excerices;

import java.util.Scanner;

public class EX8_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int yearlyTax = Integer.parseInt(scan.nextLine());

        double trainingTax = yearlyTax;
        double shoesPrice = trainingTax - (trainingTax * 0.4);
        double suitPrice = shoesPrice - (shoesPrice * 0.2);
        double ballPrice = 0.25 * suitPrice;
        double accPrice = 0.2 * ballPrice;
        double totalPrice = trainingTax + shoesPrice + suitPrice + ballPrice + accPrice;

        System.out.println(totalPrice);

    }
}
