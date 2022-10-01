package List.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

            String name = input.get(0);
            String goingOrNot = input.get(2);

            switch (goingOrNot) {
                case "going!":
                    for (int j = 0; j <= names.size(); j++) {
                        if (names.contains(name)) {
                            System.out.printf("%s is already in the list!%n", name);
                            break;
                        } else {
                            names.add(name);
                            break;
                        }
                    }
                    break;
                case "not":
                    for (int j = 0; j <= names.size(); j++) {
                        if (names.contains(name)) {
                            names.remove(name);
                            break;
                        } else {
                            System.out.printf("%s is not in the list!%n", name);
                            break;
                        }
                    }
                    break;
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
