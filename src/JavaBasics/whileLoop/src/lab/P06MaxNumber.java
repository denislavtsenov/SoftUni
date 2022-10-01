package Lab;

import java.util.Scanner;

public class P06MaxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxNum = Integer.MIN_VALUE;
        String input = scan.nextLine();

        while (!input.equals("Stop")) {
            int num = Integer.parseInt(input);

            if (num > maxNum) {
                maxNum = num;
            }
            input = scan.nextLine();
        }
        System.out.println(maxNum);
    }
}
