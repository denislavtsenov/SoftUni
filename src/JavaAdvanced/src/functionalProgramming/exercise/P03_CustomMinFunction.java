package JavaAdvanced.src.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.stream(numbers).min().getAsInt());


    }
}
