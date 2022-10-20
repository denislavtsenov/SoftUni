package JavaAdvanced.src.examPreparation.javaAdvancedExam19February2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] creatingWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> vowelsQueue.offer(e.charAt(0)));

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> consonantsStack.push(e.charAt(0)));

        while (!consonantsStack.isEmpty()) {
            char firstVowel = vowelsQueue.poll();
            char firstConsonant = consonantsStack.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(firstVowel);
                int indexConsonant = word.indexOf(firstConsonant);

                if (indexVowel >= 0) {
                    creatingWords[i] = creatingWords[i].substring(0, indexVowel) + firstVowel
                    + creatingWords[i].substring(indexVowel + 1);
                }

                if (indexConsonant >= 0) {
                    creatingWords[i] = creatingWords[i].substring(0, indexConsonant) + firstConsonant
                    + creatingWords[i].substring(indexConsonant + 1);
                }

                vowelsQueue.offer(firstVowel);
            }

        }

        List<String> findWordsList = Arrays.stream(creatingWords).filter(word -> !word.contains("*"))
                .collect(Collectors.toList());

        System.out.printf("Words found: %d%n", findWordsList.size());

        for (String word : findWordsList) {
            System.out.println(word);
        }
    }
}
