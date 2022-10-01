package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scan.nextLine());
        }
        int sum = 0;
        for (int i = 0; i <= numbers.length - 1; i++) {
            int num = numbers[i];
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}

