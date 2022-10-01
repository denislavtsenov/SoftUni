package stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println(0);
        } else {
            while (number > 0) {
                int binaryNum = number % 2;
                int newNum = number / 2;
                stack.push(binaryNum);
                number = newNum;
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
