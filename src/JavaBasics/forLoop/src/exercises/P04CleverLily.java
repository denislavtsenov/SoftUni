package EXERCISE;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double priceWash = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        int toy = 0;
        double money = 0;
        double allMoney = 0;
        int brother = 0;

        for (int i = 1; i <= age ; i++) {

            if (i % 2 != 0) {
                toy++;
            } else {
                brother++;
                money += 10;
                allMoney = allMoney + money;
            }
        }
        int sumToy = toy * toyPrice;
        double totalMoney = sumToy + allMoney - brother;
        double diff = Math.abs(totalMoney - priceWash);

        if (priceWash <= totalMoney) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}
