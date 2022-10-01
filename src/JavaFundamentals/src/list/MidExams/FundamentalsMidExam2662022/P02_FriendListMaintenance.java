package List.MidExams.FundamentalsMidExam2662022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        int blacklistedNamesCount = 0;
        int lostNamesCount = 0;

        while (!input.equals("Report")) {
            String[] commands = input.split(" ");
            String command = commands[0];

            switch (command) {
                case "Blacklist":
                    String name = commands[1];

                    if (namesList.contains(name)) {
                        blacklistedNamesCount++;
                        System.out.printf("%s was blacklisted.%n", name);
                        int index = namesList.indexOf(name);
                        name = "Blacklisted";
                        namesList.set(index, name);

                    } else {
                        System.out.printf("%s was not found.%n", name);
                    }

                    break;

                case "Error":
                    int index = Integer.parseInt(commands[1]);

                    if (index >= 0 && index < namesList.size()) {
                        String nameError = String.valueOf(namesList.get(index));
                        if (!nameError.equals("Blacklisted") && !nameError.equals("Lost")) {
                            lostNamesCount++;
                            System.out.printf("%s was lost due to an error.%n", nameError);
                            nameError = "Lost";
                            namesList.set(index, nameError);
                        }
                    }

                    break;

                case "Change":
                    int indexChange = Integer.parseInt(commands[1]);
                    String newName = commands[2];

                    if (indexChange >= 0 && indexChange < namesList.size()) {
                        String currentName = String.valueOf(namesList.get(indexChange));
                        System.out.printf("%s changed his username to %s.%n", currentName, newName);

                        namesList.set(indexChange, newName);
                    }
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", blacklistedNamesCount);
        System.out.printf("Lost names: %d%n", lostNamesCount);
        System.out.println(String.join(" ", namesList));

    }
}
