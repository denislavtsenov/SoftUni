package Lab;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int sum = 0;

        while (sum < num) {
            int currentNum = Integer.parseInt(scan.nextLine());
            sum = sum + currentNum;
        }
        System.out.println(sum);
    }
}
