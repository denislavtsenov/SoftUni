package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setSizes = scanner.nextLine().split("\\s+");

        int firstSetSize = Integer.parseInt(setSizes[0]);
        int secondSetSize = Integer.parseInt(setSizes[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            firstSet.add(number);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            secondSet.add(number);
        }

        for (Integer num : firstSet) {
            if (secondSet.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
