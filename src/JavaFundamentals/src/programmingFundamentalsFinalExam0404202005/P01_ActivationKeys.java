package ProgrammingFundamentalsFinalExam0404202005;

import java.util.Locale;
import java.util.Scanner;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Generate")) {
            String[] commands = inputLine.split(">>>");
            String command = commands[0];

            String substring = "";
            int startIndex = 0;
            int endIndex = 0;

            switch (command) {
                case "Contains":
                    substring = commands[1];

                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String upperOrLower = commands[1];
                    startIndex = Integer.parseInt(commands[2]);
                    endIndex = Integer.parseInt(commands[3]);
                    substring = activationKey.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());
                    } else if (upperOrLower.equals("Lower")) {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;

                case "Slice":
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);
                    substring = activationKey.substring(startIndex, endIndex);

                    activationKey = activationKey.replace(substring, "");
                    System.out.println(activationKey);
                    break;
            }
            inputLine = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
