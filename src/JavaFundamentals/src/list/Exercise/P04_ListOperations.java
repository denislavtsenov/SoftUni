package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            String command = commands[0];

            switch (command) {
                case "Add":
                    int number = Integer.parseInt(commands[1]);
                    numbersList.add(number);
                    break;
                case "Insert":
                    int number2 = Integer.parseInt(commands[1]);
                    int index = Integer.parseInt(commands[2]);
                    if (isIndexValid(numbersList, index)) {
                        numbersList.add(index, number2);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int number1 = Integer.parseInt(commands[1]);
                    if (isIndexValid(numbersList, number1)) {
                        numbersList.remove(number1);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "Shift":
                    String direction = commands[1];
                    int count = Integer.parseInt(commands[2]);
                    if (direction.equals("left")) {
                        for (int i = 0; i < count; i++) {
                            int firstNum = numbersList.get(0);
                            numbersList.add(firstNum);
                            numbersList.remove(numbersList.get(0));
                        }
                    } else if (direction.equals("right")) {
                        for (int i = 0; i < count; i++) {
                            int lastNum = numbersList.get(numbersList.size() - 1);
                            numbersList.add(0, lastNum);
                            numbersList.remove(numbersList.size()-1);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int num : numbersList) {
            System.out.print(num + " ");
        }
    }

    public static boolean isIndexValid(List<Integer> numList, int index) {
        return index >= 0 && index <= numList.size() - 1;
    }
}
