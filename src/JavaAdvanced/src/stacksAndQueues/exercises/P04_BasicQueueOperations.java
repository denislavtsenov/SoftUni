package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");
        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<>();

        int elementsToAdd = Integer.parseInt(commands[0]);
        int elementsToRemove = Integer.parseInt(commands[1]);
        String elementToCheck = commands[2];

        for (int i = 0; i < elementsToAdd; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
