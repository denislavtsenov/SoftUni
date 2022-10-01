package Exercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scan.nextLine());
        double money = Double.parseDouble(scan.nextLine());

        int daysCount = 0;
        int spendingCount = 0;
        double totalSum = money;

        while (neededMoney > totalSum) {
            if (spendingCount == 5) {
                break;
            }
            String spendOrSave = scan.nextLine();
            double sum = Double.parseDouble(scan.nextLine());
            daysCount++;

            if (spendOrSave.equals("spend")) {
                spendingCount++;
                totalSum = totalSum - sum;

                if (totalSum < 0) {
                    totalSum = 0;
                }


            } else if (spendOrSave.equals("save")) {
                totalSum = totalSum + sum;
                spendingCount = 0;

            }
            if (totalSum >= neededMoney) {
                break;
            }

            }
            if (spendingCount >= 5) {
                System.out.println("You can't save the money.");
                System.out.printf("%d", daysCount);
            } else {
                System.out.printf("You saved the money for %d days.", daysCount);
            }
        }
    }

