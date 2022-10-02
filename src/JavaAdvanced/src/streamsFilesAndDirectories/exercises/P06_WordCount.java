package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P06_WordCount {
    public static void main(String[] args) throws IOException {

        BufferedReader inputText = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/Exercises Resources/text.txt"));

        BufferedReader inputWord = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/Exercises Resources/words.txt"));

        String[] inputTextArr = inputText.readLine().split("\\s+");


       String[] words = inputWord.readLine().split("\\s+");

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        for (int i = 0; i < inputTextArr.length; i++) {

            String currentWord = inputTextArr[i];

            if (currentWord.equals(words[0])) {
                if (!wordsCount.containsKey(words[0])) {
                    wordsCount.put(words[0], 1);
                } else {
                    int currentValue = wordsCount.get(words[0]);
                    wordsCount.put(words[0], currentValue + 1);
                }
            } else if (currentWord.endsWith(words[1])) {

                if (!wordsCount.containsKey(words[1])) {
                    wordsCount.put(words[1], 1);
                } else {
                    int currentValue = wordsCount.get(words[1]);
                    wordsCount.put(words[1], currentValue + 1);
                }

            } else if (currentWord.equals(words[2])) {

                if (!wordsCount.containsKey(words[2])) {
                    wordsCount.put(words[2], 1);
                } else {
                    int currentValue = wordsCount.get(words[2]);
                    wordsCount.put(words[2], currentValue + 1);
                }
            }
        }
        PrintWriter output = new PrintWriter("src/JavaAdvanced/resources/exercises/Exercises Resources/results-word-count.txt");

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            output.println(entry.getKey() + " - " + entry.getValue());
        }

        output.println();


        inputText.close();
        inputWord.close();
        output.close();
    }
}
