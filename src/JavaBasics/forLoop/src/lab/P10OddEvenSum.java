package LAB;

import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int odd = 0;
        int even = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (i % 2 == 0) {
                even = even + num;
            } else {
                odd = odd + num;
            }
        }
        if (even == odd) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", odd);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(odd - even));

        }
    }
}
