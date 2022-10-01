package PreliminaryExam;

import java.util.Scanner;

public class P06UniquePINCodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int thirdNum = Integer.parseInt(scan.nextLine());

        for (int num1 = 2; num1 <= firstNum; num1 += 2) {
            for (int num2 = 2; num2 <= secondNum; num2++) {
                for (int num3 = 2; num3 <= thirdNum; num3 += 2) {
                    if (num2 == 2 || num2 == 3 || num2 == 5 || num2 == 7) {
                        System.out.printf("%d %d %d%n", num1, num2, num3);
                    }
                }
            }
        }
    }
}
