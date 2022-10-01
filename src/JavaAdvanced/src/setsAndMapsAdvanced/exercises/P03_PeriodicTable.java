package setsAndMapsAdvanced.exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            for (int j = 0; j < elements.length; j++) {
                String currentElement = elements[j];

                compounds.add(currentElement);
            }
        }

        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
    }
}
