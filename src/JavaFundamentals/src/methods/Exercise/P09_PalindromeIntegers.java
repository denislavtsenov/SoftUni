package Methods.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            int[] numbers = Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] reversedNumbers = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                reversedNumbers[j] = numbers[numbers.length - 1 - j];
            }

            if (Arrays.equals(numbers, reversedNumbers)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }
    }
}

