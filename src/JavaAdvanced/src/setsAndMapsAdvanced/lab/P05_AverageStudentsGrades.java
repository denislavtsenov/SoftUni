package setsAndMapsAdvanced.lab;

import java.util.*;
import java.util.stream.Collectors;

public class P05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            String name = inputLine[0];
            double grade = Double.parseDouble(inputLine[1]);

            if (!studentGrades.containsKey(name)) {
                studentGrades.put(name, new ArrayList<>());
            }
            studentGrades.get(name).add(grade);
        }
    }
}

