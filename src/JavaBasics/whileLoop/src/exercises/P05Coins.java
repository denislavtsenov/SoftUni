package Exercise;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double coins = Double.parseDouble(scan.nextLine());

        double totalCoins = coins * 100;
        int countCoins = 0;
        double exchangedCoins = totalCoins;

        while (exchangedCoins > 0) {
            if (exchangedCoins >= 200) {
                countCoins++;
                exchangedCoins = exchangedCoins - 200;

            } else if (exchangedCoins >= 100) {
                countCoins++;
                exchangedCoins = exchangedCoins - 100;

            } else if (exchangedCoins >= 50) {
                countCoins++;
                exchangedCoins = exchangedCoins - 50;

            } else if (exchangedCoins >= 20) {
                countCoins++;
                exchangedCoins = exchangedCoins - 20;

            } else if (exchangedCoins >= 10) {
                countCoins++;
                exchangedCoins = exchangedCoins - 10;

            } else if (exchangedCoins >= 5) {
                countCoins++;
                exchangedCoins = exchangedCoins - 5;

            } else if (exchangedCoins >= 2) {
                countCoins++;
                exchangedCoins = exchangedCoins - 2;

            } else if (exchangedCoins >= 1) {
                countCoins++;
                exchangedCoins = exchangedCoins - 1;
            } else {
                break;
            }
        }
        System.out.println(countCoins);
    }
}
