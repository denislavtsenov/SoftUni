package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (String num : inputNumbers) {
            stackNumbers.push(Integer.valueOf(num));
        }

        for (int num : stackNumbers) {
            System.out.print(num + " ");
        }
    }
}
