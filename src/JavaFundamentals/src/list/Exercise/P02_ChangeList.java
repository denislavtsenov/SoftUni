package List.Exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commands = command.split(" ");

            String firstCommand = commands[0];
            int element = Integer.parseInt(commands[1]);


            switch (firstCommand) {
                case "Delete":
                    numbersList.removeAll(Collections.singleton(element));
                    break;
                case "Insert":
                    int position = Integer.parseInt(commands[2]);
                    numbersList.add(position, element);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int num : numbersList) {
            System.out.print(num + " ");
        }
    }
}
