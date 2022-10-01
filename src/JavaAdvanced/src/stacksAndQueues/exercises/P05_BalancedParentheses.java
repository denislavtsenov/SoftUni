package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                openingBrackets.push(currentBracket);
            } else {

                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char lastOpeningBracket = openingBrackets.pop();

                if (lastOpeningBracket != '(' && currentBracket == ')') {
                    isBalanced = false;
                } else if (lastOpeningBracket != '[' && currentBracket == ']') {
                    isBalanced = false;
                } else if (lastOpeningBracket != '{' && currentBracket == '}') {
                    isBalanced = false;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
