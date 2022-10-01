package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commandLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int elementsToPush = commandLine[0];
        int elementsToPop = commandLine[1];
        int elementToCheck = commandLine[2];

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbersLine[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
