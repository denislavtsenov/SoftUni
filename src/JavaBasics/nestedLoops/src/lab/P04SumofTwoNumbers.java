package LAB;

import java.util.Scanner;

public class P04SumofTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magic = Integer.parseInt(scan.nextLine());

        int result = 0;
        int combinations = 0;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end ; j++) {
                combinations++;

                result = i + j;
                if (result == magic) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", combinations, i, j, result);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", combinations, magic);
        }
    }


