package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(" ");

            String command = commands[0];

            switch (command) {
                case "1":
                    int number = Integer.parseInt(commands[1]);
                    stack.push(number);
                    break;

                case "2":
                    stack.pop();
                    break;

                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
