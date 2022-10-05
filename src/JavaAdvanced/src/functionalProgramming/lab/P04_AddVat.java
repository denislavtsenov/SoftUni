package JavaAdvanced.src.functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Prices with VAT:");
        Arrays.stream(values).forEach(value -> System.out.printf("%.2f%n", value *= 1.2));

    }
}

