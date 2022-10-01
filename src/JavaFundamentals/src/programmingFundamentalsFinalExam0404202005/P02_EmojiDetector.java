package ProgrammingFundamentalsFinalExam0404202005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();


        int thresholdSum = 1;
        for (int i = 0; i < inputLine.length(); i++) {
            char currentSymbol = inputLine.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                String current = String.valueOf(currentSymbol);
                int currentNum = Integer.parseInt(current);
                thresholdSum = thresholdSum * currentNum;
            }
        }

        String regexEmoji = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern patternEmoji = Pattern.compile(regexEmoji);
        Matcher matcherEmoji = patternEmoji.matcher(inputLine);
        List<String> emojisList = new ArrayList<>();
        while (matcherEmoji.find()) {
            String emoji = matcherEmoji.group();
            emojisList.add(emoji);
        }

        System.out.println("Cool threshold: " + thresholdSum);
        System.out.println(emojisList.size() + " emojis found in the text. The cool ones are:");

        for (int i = 0; i < emojisList.size(); i++) {
            String currentEmoji = emojisList.get(i);
            int currentEmojiSum = 0;
            for (int j = 0; j < currentEmoji.length(); j++) {
                char symbol = currentEmoji.charAt(j);
                if (Character.isLetter(symbol)) {
                    int currentSymbol = currentEmoji.charAt(j);
                    currentEmojiSum += currentSymbol;
                }
            }

            if (currentEmojiSum >= thresholdSum) {
                System.out.println(currentEmoji);
            }
        }
    }
}
