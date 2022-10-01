package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Map<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < inputLine.length(); i++) {
            char currentSymbol = inputLine.charAt(i);

            if (!symbolsCount.containsKey(currentSymbol)) {
                symbolsCount.put(currentSymbol, 1);
            } else {
                int currentValue = symbolsCount.get(currentSymbol);
                symbolsCount.put(currentSymbol, currentValue + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }

    }
}
