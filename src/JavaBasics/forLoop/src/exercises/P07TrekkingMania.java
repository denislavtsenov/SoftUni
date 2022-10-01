package EXERCISE;

import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countGroups = Integer.parseInt(scan.nextLine());


        int totalPeople = 0;
        double musala = 0;
        double monblan = 0;
        double kilimandzaro = 0;
        double k2 = 0;
        double everest = 0;


        for (int i = 1; i <= countGroups; i++) {
           int countPeople = Integer.parseInt(scan.nextLine());
            totalPeople += countPeople;

            if (countPeople <= 5) {
                musala += countPeople;
            } else if (countPeople <= 12) {
                monblan += countPeople;
            } else if (countPeople <= 25) {
                kilimandzaro += countPeople;
            } else if (countPeople <= 40) {
                k2 += countPeople;
            } else {
                everest += countPeople;
            }
        }
        double totalMusala = musala / totalPeople * 100;
        double totalMonblan = monblan / totalPeople * 100;
        double totalKilimandzaro = kilimandzaro / totalPeople * 100;
        double totalK2 = k2 / totalPeople * 100;
        double totalEverest = everest / totalPeople * 100;

        System.out.printf("%.2f%%%n", totalMusala);
        System.out.printf("%.2f%%%n", totalMonblan);
        System.out.printf("%.2f%%%n", totalKilimandzaro);
        System.out.printf("%.2f%%%n", totalK2);
        System.out.printf("%.2f%%%n", totalEverest);


    }
}
