package JavaAdvanced.src.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Arrays.stream(names).forEach(e -> System.out.println("Sir " + e));
    }
}
