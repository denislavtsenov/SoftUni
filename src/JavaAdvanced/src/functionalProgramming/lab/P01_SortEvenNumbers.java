package JavaAdvanced.src.functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).filter(e -> e % 2 == 0)
                .toArray();

        System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", ""));

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", ""));

    }
}
