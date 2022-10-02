package JavaAdvanced.src.functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("Count = " + Arrays.stream(numbers).count());
        System.out.println("Sum = " + Arrays.stream(numbers).sum());
    }
}
