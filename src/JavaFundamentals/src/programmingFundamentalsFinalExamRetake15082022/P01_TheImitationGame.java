package ProgrammingFundamentalsFinalExamRetake15082020;

import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Decode")) {
            String command = inputLine.split("\\|")[0];

            switch (command) {
                case "Move":
                    int numOfLetters = Integer.parseInt(inputLine.split("\\|")[1]);
                    String firstLetters = encryptedMessage.substring(0, numOfLetters);
                    encryptedMessage = encryptedMessage.replace(firstLetters, "");
                    encryptedMessage = encryptedMessage.concat(firstLetters);

                    break;

                case "Insert":
                    int index = Integer.parseInt(inputLine.split("\\|")[1]);
                    String value = inputLine.split("\\|")[2];
                    StringBuilder currentMessage = new StringBuilder(encryptedMessage);
                    currentMessage.insert(index, value);
                    encryptedMessage = currentMessage.toString();

                    break;


                case "ChangeAll":
                    String substring = inputLine.split("\\|")[1];
                    String replacement = inputLine.split("\\|")[2];

                   encryptedMessage = encryptedMessage.replace(substring, replacement);
                    break;
            }


            inputLine = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
