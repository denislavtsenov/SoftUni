package stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                stack.push(String.valueOf(i));
            } else if (currentSymbol == ')') {
                int startIndex = Integer.parseInt(stack.pop());
                String substring = input.substring(startIndex, i + 1);
                System.out.println(substring);
            }
        }
    }
}
