package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("search")) {

            String[] users = inputLine.split("-");

            String user = users[0];
            String phoneNumber = users[1];

            phoneBook.put(user, phoneNumber);

            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();

        while (!inputLine.equals("stop")) {
            String searchName = inputLine;

            if (phoneBook.containsKey(searchName)) {
                System.out.println(searchName + " -> " + phoneBook.get(searchName));

            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
            inputLine = scanner.nextLine();
        }
    }
}
