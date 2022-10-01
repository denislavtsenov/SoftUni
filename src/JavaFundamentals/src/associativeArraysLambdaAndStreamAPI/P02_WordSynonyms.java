package AssociativeArraysLambdaAndStreamAPI;

import java.util.*;

public class P02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<String>> wordsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n * 2; i+= 2) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            wordsMap.putIfAbsent(word, new ArrayList<String>());
            wordsMap.get(word).add(synonym);

        }

        for (Map.Entry<String, List<String>> entry : wordsMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", (entry.getValue())));
        }

    }
}
