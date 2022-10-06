package JavaAdvanced.src.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String command = input;

            switch (command) {
                case "add":
                    add(numbers);
                    break;

                case "subtract":
                    subtract(numbers);
                    break;

                case "multiply":
                    multiply(numbers);
                    break;

                case "print":
                    print(numbers);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void print(int[] numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void multiply(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            currentNum = currentNum * 2;
            numbers[i] = currentNum;
        }
    }

    private static void subtract(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            currentNum -= 1;
            numbers[i] = currentNum;
        }
    }

    private static void add(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            currentNum += 1;
            numbers[i] = currentNum;
        }
    }
}

