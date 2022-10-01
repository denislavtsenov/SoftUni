 package Excerices;

import java.util.Scanner;

        public class EX3_DepositCalculator {
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);

                double deposits = Double.parseDouble(scan.nextLine());
                int months = Integer.parseInt(scan.nextLine());
                double percent = Double.parseDouble(scan.nextLine());

              double increase = deposits * (percent / 100);
              double monthlyIncrease = increase / 12;
              double total = deposits + months * monthlyIncrease;

                System.out.println(total);
            }
        }

