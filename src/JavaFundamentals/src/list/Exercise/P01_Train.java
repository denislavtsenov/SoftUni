package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxPassengers = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            List<String> commands = Arrays.stream(command.split(" "))
                    .collect(Collectors.toList());

            String firstCommand = commands.get(0);


            if (firstCommand.equals("Add")) {
                String secondCommand = commands.get(1);
                numbersList.add(Integer.parseInt(secondCommand));
            } else {
                int passengersToAdd = Integer.parseInt(firstCommand);
                for (int i = 0; i < numbersList.size(); i++) {
                    int passenger = numbersList.get(i);

                    if (maxPassengers >= passengersToAdd + passenger) {
                        numbersList.set(i, passengersToAdd + passenger);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int wagon : numbersList) {
            System.out.print(wagon + " ");
        }
    }
}
