package ProgrammingFundamentalsFinalExamRetake10042020;

import java.util.Scanner;

public class P01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String concealedMessage = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(concealedMessage);

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Reveal")) {
            String[] commands = inputLine.split(":\\|:");
            String command = commands[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < concealedMessage.length()) {
                        messageBuilder.insert(index, " ");
                    concealedMessage = String.valueOf(messageBuilder);
            }
                    System.out.println(concealedMessage);
                    break;

                case "Reverse":
                    String substring = commands[1];
                    if (concealedMessage.contains(substring)) {
                        concealedMessage = concealedMessage.replaceFirst(substring, "");
                        messageBuilder = new StringBuilder(concealedMessage);
                        StringBuilder reversedSubstring = new StringBuilder(substring);
                        reversedSubstring.reverse();
                        messageBuilder.append(reversedSubstring);
                        concealedMessage = String.valueOf(messageBuilder);
                        System.out.println(concealedMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String changeSubstring = commands[1];
                    String replacement = commands[2];

                    concealedMessage = concealedMessage.replaceAll(changeSubstring, replacement);
                    System.out.println(concealedMessage);

                    break;
            }
            inputLine = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + concealedMessage);
    }
}
