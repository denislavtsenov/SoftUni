package implementations;

import interfaces.Deque;
import interfaces.Solvable;

import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        boolean isBalanced = parentheses.length() % 2 == 0;

        return isBalanced;
    }
}
