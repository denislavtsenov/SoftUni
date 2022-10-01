package ProgrammingFundamentalsFinalExamRetake10042020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        Map<String, String> wordMap = new LinkedHashMap<>();

        while (matcher.find()) {
            counter++;
            String firstWord = matcher.group("wordOne");
            String secondWord = matcher.group("wordTwo");
            StringBuilder reversedSecondWord = new StringBuilder(secondWord).reverse();
            String secondWordReversed = reversedSecondWord.toString();

            if (firstWord.equals(secondWordReversed)) {
                wordMap.put(firstWord, secondWord);
            }
        }

        if (counter > 0) {
            System.out.println(counter + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }
        List<String> matchedWordList = new ArrayList<>();
        if (wordMap.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            for (Map.Entry<String, String> entry : wordMap.entrySet()) {
              matchedWordList.add(entry.getKey() + " <=> " + entry.getValue());
            }
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", matchedWordList));
        }
    }
}

