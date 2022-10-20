package JavaAdvanced.src.examPreparation.javaAdvancedExam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();

        for (int i = 0; i < firstBox.length; i++) {
            firstBoxQueue.offer(firstBox[i]);
        }

        int[] secondBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        for (int i = 0; i < secondBox.length; i++) {
            secondBoxStack.push(secondBox[i]);
        }

        int sum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstBoxElement = firstBoxQueue.peek();
            int secondBoxElement = secondBoxStack.peek();
            int currentSum = firstBoxElement + secondBoxElement;

            if (currentSum % 2 == 0) {
                sum += currentSum;

                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(secondBoxElement);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
