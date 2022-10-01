package List.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("end")) {
            List<String> commandsList = Arrays.stream(commands.split(" "))
                    .collect(Collectors.toList());

            String currentCommand = commandsList.get(0);
            switch (currentCommand) {
                case "Add":
                    numbersList.add(Integer.parseInt(commandsList.get(1)));
                    break;
                case "Remove":
                   numbersList.remove(Integer.valueOf(commandsList.get(1)));
                    break;
                case "RemoveAt":
                    numbersList.remove(Integer.parseInt(commandsList.get(1)));
                    break;
                case "Insert":
                    numbersList.add(Integer.parseInt(commandsList.get(2)), Integer.parseInt(commandsList.get(1)));
                    break;
            }
            commands = scanner.nextLine();
            }
        for (int num :numbersList) {
            System.out.print(num + " ");
        }
    }
}
