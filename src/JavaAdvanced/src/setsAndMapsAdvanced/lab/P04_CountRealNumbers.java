package setsAndMapsAdvanced.lab;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<Double, Integer> realNumbers = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {

            double current = Double.parseDouble(input[i]);
            if (!realNumbers.containsKey(current)) {
                realNumbers.put(current, 1);
            } else {
                int currentValue = realNumbers.get(current);
                realNumbers.put(current, currentValue + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : realNumbers.entrySet()) {
            double key = entry.getKey();
            int value = entry.getValue();

            System.out.printf("%.1f -> %d%n", key, value);
        }

    }
}
