package ProgrammingFundamentalsFinalExam04042020;

import java.util.Scanner;

public class P01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Done")) {
            String[] commands = inputLine.split(" ");
            String command = commands[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < text.length(); i += 2) {

                        String currentSymbol = String.valueOf(text.charAt(i));
                        newPassword.append(currentSymbol);

                    }
                    text = newPassword.toString();
                    System.out.println(text);

                    break;

                case "Cut":
                    int index = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]);

                    String substring = text.substring(index, index + length);
                    text = new StringBuilder(text).delete(index, index +length).toString();
                    System.out.println(text);
                    break;

                case "Substitute":
                    String substringSubs = commands[1];
                    String substitute = commands[2];

                    if (text.contains(substringSubs)) {
                        text = text.replaceAll(substringSubs, substitute);
                        System.out.println(text);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

            }
            inputLine = scanner.nextLine();
        }
        System.out.println("Your password is: " + text);
    }
}
