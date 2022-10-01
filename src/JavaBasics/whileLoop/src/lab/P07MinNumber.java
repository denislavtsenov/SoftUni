package Lab;

import java.util.Scanner;

public class P07MinNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minNum = Integer.MAX_VALUE;
        String input = scan.nextLine();

        while (!input.equals("Stop")) {
            int num = Integer.parseInt(input);

            if (num < minNum) {
                minNum = num;
            }
            input = scan.nextLine();

        }
        System.out.println(minNum);
    }
}
