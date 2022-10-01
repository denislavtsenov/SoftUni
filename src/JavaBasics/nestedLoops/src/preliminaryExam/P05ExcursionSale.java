package PreliminaryExam;

import java.util.Scanner;

public class P05ExcursionSale {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countSea = Integer.parseInt(scan.nextLine());
        int countMountain = Integer.parseInt(scan.nextLine());

        int totalSea = 0;
        int totalMountain = 0;
        int totalProfit = 0;

        String command = scan.nextLine();
        while (!command.equals("Stop")) {

           switch (command) {
               case "sea":
                   if (totalSea >= countSea) {
                       totalProfit = totalProfit + 0;
                   } else {
                       totalProfit = totalProfit + 680;
                   }
                   totalSea ++;
                   break;
               case "mountain":
                   if (totalMountain >= countMountain) {
                      totalProfit = totalProfit + 0;
                   } else {
                       totalProfit = totalProfit + 499;
                   }
                   totalMountain++;
                   break;
           }
           if ((totalSea >= countSea) && (totalMountain >= countMountain)) {
                System.out.println("Good job! Everything is sold.");
               System.out.printf("Profit: %d leva.", totalProfit);
                break;
            }
            command = scan.nextLine();
        }
        if (command.equals("Stop")) {
            System.out.printf("Profit: %d leva.", totalProfit);
        }
    }
}
