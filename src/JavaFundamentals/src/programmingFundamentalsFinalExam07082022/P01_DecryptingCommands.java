package ProgrammingFundamentalsFinalExam07082022;

import java.util.Scanner;

public class P01_DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Finish")) {

            String[] commands = inputLine.split(" ");
            String command = commands[0];
            String substring = "";
            int startIndex = 0;
            int endIndex = 0;

            switch (command) {

                case "Replace":
                    String currentChar = commands[1];
                    String newChar = commands[2];

                    text = text.replaceAll(currentChar, newChar);
                    System.out.println(text);

                    break;

                case "Cut":
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);

                    if (startIndex < 0 || startIndex >= text.length() ||
                            endIndex < 0 || endIndex >= text.length()) {
                        System.out.println("Invalid indices!");
                    } else {
                        substring = text.substring(startIndex, endIndex + 1);
                        text = text.replace(substring, "");
                        System.out.println(text);
                    }
                    break;

                case "Make":
                    String upperOrLower = commands[1];

                    if (upperOrLower.equals("Upper")) {
                        text = text.replace(text, text.toUpperCase());
                    } else if (upperOrLower.equals("Lower")) {
                        text = text.replace(text, text.toLowerCase());
                    }

                    System.out.println(text);
                    break;

                case "Check":
                    substring = commands[1];

                    if (text.contains(substring)) {
                        System.out.println("Message contains " + substring);
                    } else {
                        System.out.println("Message doesn't contain " + substring);
                    }
                    break;

                case "Sum":
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);


                    if (startIndex < 0 || startIndex >= text.length() ||
                            endIndex < 0 || endIndex >= text.length()) {
                        System.out.println("Invalid indices!");
                    } else {
                        substring = text.substring(startIndex, endIndex + 1);
                        int totalSymbolsSum = 0;
                        for (int i = 0; i < substring.length(); i++) {
                            int currentSymbolNum = substring.charAt(i);
                            totalSymbolsSum += currentSymbolNum;

                        }
                        System.out.println(totalSymbolsSum);
                    }

                    break;
            }
            inputLine = scanner.nextLine();
        }
    }
}
