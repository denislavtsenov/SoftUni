package RegularyExam;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class P03PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String cake = scan.nextLine();
        int countCakes = Integer.parseInt(scan.nextLine());
        int day = Integer.parseInt(scan.nextLine());

        double pricePerCake = 0;

        if (day <= 15) {
            switch (cake) {
                case "Cake":
                    pricePerCake = 24;
                    break;
                case "Souffle":
                    pricePerCake = 6.66;
                    break;
                case "Baklava":
                    pricePerCake = 12.60;
                    break;
            }
        } else {
            switch (cake) {
                case "Cake":
                    pricePerCake = 28.70;
                    break;
                case "Souffle":
                    pricePerCake = 9.80;
                    break;
                case "Baklava":
                    pricePerCake = 16.98;
                    break;
            }
        }
        double totalSum = countCakes * pricePerCake;

        if (day <= 22) {
            if (totalSum >= 100 && totalSum <= 200) {
                totalSum = totalSum * 0.85;
            } else if (totalSum > 200) {
                totalSum = totalSum * 0.75;
            }
        }
        if (day <= 15) {
            totalSum = totalSum * 0.9;
        }

        System.out.printf("%.2f", totalSum);
    }
}
