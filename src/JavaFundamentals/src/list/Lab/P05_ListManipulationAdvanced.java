package List.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("end")) {
            List<String> commandsList = Arrays.stream(commands.split(" "))
                    .collect(Collectors.toList());

            String firstCommand = commandsList.get(0);
            String secondCommand = commandsList.get(1);

            if (firstCommand.equals("Contains")) {
                if (numbersList.contains(Integer.parseInt(secondCommand))) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (secondCommand.equals("even")) {
                for (int i = 0; i < numbersList.size(); i++) {
                    int currentNum = numbersList.get(i);
                    if (currentNum % 2 == 0)
                        System.out.print(currentNum + " ");
                }
                System.out.println();

            } else if (secondCommand.equals("odd")) {
                for (int i = 0; i < numbersList.size(); i++) {
                    int currentNum = numbersList.get(i);
                    if (currentNum % 2 != 0)
                        System.out.print(currentNum + " ");
                }
                System.out.println();

            } else if (secondCommand.equals("sum")) {
                int sum = 0;
                for (int i = 0; i < numbersList.size(); i++) {
                    int currentNum = numbersList.get(i);
                    sum += currentNum;
                }
                System.out.println(sum);

            } else if (firstCommand.equals("Filter")) {
//'<', '>', ">=", "<="
                int specialNum = Integer.parseInt(commandsList.get(2));
                if (commandsList.get(1).equals(">=")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        int currentNum = numbersList.get(i);
                        if (currentNum >= specialNum) {
                            System.out.print(currentNum + " ");
                        }
                    }
                    System.out.println();

                } else if (commandsList.get(1).equals("<=")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        int currentNum = numbersList.get(i);
                        if (currentNum <= specialNum) {
                            System.out.print(currentNum + " ");
                        }
                    }
                    System.out.println();

                } else if (commandsList.get(1).equals(">")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        int currentNum = numbersList.get(i);
                        if (currentNum > specialNum) {
                            System.out.print(currentNum + " ");
                        }
                    }
                    System.out.println();

                } else if (commandsList.get(1).equals("<")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        int currentNum = numbersList.get(i);
                        if (currentNum < specialNum) {
                            System.out.print(currentNum + " ");
                        }
                    }
                    System.out.println();
                }
            }
            commands = scanner.nextLine();
        }
    }
}
