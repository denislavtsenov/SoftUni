package LAB;

import java.util.Scanner;

public class P09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sumLeftNum = 0;
        int sumRightNum = 0;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            sumLeftNum = sumLeftNum + num;
        }
        for (int i = 1; i <= n; i++) {
            int num2 = Integer.parseInt(scan.nextLine());

            sumRightNum = sumRightNum + num2;
        }

        if (sumLeftNum == sumRightNum) {
            System.out.printf("Yes, sum = %d", sumLeftNum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(sumLeftNum - sumRightNum));
        }
    }
}
