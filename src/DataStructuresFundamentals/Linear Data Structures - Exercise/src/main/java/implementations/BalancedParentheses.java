package implementations;

import interfaces.Deque;
import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {

        if (parentheses == null || parentheses.length() == 0) {
            return false;
        }

        boolean isEven = parentheses.length() % 2 == 0;

        char[] inputArr = parentheses.toCharArray();

        if (isEven) {
            for (int i = 0; i < inputArr.length / 2; i++) {
                char first = inputArr[i];
                char last = inputArr[inputArr.length - 1 - i];

                if (first == '(' && last != ')') {
                    return false;
                } else if (first == '{' && last != '}') {
                    return false;
                } else if (first == '[' && last != ']') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}



