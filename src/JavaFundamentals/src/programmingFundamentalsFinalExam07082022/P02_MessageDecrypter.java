package ProgrammingFundamentalsFinalExam07082022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([$%])(?<message>[A-Z][a-z]{2,})\\1: \\[(?<firstNum>[0-9]+)\\]\\|\\[(?<secondNum>[0-9]+)\\]\\|\\[(?<thirdNum>[0-9]+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String message = matcher.group("message");
                int firstNum = Integer.parseInt(matcher.group("firstNum"));
                int secondNum = Integer.parseInt(matcher.group("secondNum"));
                int thirdNum = Integer.parseInt(matcher.group("thirdNum"));

                StringBuilder messageBuilder = new StringBuilder();
                char firstSymbol = (char) firstNum;
                char secondSymbol = (char) secondNum;
                char thirdSymbol = (char) thirdNum;

                String firstChar = String.valueOf(firstSymbol);
                String secondChar = String.valueOf(secondSymbol);
                String thirdChar = String.valueOf(thirdSymbol);

                messageBuilder.append(firstChar);
                messageBuilder.append(secondChar);
                messageBuilder.append(thirdChar);

                System.out.printf("%s: %s%n", message, messageBuilder.toString());
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
