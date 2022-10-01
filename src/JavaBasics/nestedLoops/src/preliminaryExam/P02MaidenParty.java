package PreliminaryExam;

import java.util.Scanner;

public class P02MaidenParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        •	Любовно послание - 0.60 лв.
//•	Восъчна роза - 7.20 лв.
//•	Ключодържател - 3.60 лв.
//•	Карикатура - 18.20 лв.
//•	Късмет изненада - 22 лв.

        double priceForParty = Double.parseDouble(scan.nextLine());
        int countLoveMessages = Integer.parseInt(scan.nextLine());
        int countRoses = Integer.parseInt(scan.nextLine());
        int countKeyHolders = Integer.parseInt(scan.nextLine());
        int countCaricatures = Integer.parseInt(scan.nextLine());
        int countLucks = Integer.parseInt(scan.nextLine());

        double totalSum = (countLoveMessages * 0.60) + (countRoses * 7.20) + (countKeyHolders * 3.60)
                + (countCaricatures * 18.20) + (countLucks * 22);

        int totalArticles = countLoveMessages + countRoses + countKeyHolders + countCaricatures + countLucks;

        if (totalArticles >= 25) {
            totalSum = totalSum * 0.65;
        }

        double hosting = totalSum * 0.1;

        double profit = totalSum - hosting;

        double diff = Math.abs(priceForParty - profit);

        if (profit >= priceForParty) {
            System.out.printf("Yes! %.2f lv left.", diff);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", diff);
        }

    }
}
