package List.MidExams.FundamentalsMidExam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectingItems =Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            List<String> commands = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commands.get(0);
            String item = commands.get(2);

            switch (command) {
                case "Collect":
                    if (collectingItems.contains(item)) {

                    } else {
                        collectingItems.add(item);
                    }
                    break;

                case "Drop":
                    if (collectingItems.contains(item)) {
                        collectingItems.remove(item);
                    }
                    break;

                case "Combine":
                    String items = commands.get(3);
                    String[] itemsArr = items.split(":");
                    String oldItem = itemsArr[0];
                    String newItem = itemsArr[1];

                    if (collectingItems.contains(oldItem)) {
                        int indexOfOldItem = collectingItems.indexOf(oldItem);
                        collectingItems.add(indexOfOldItem + 1, newItem);
                    }
                    break;


                case "Renew":
                    if (collectingItems.contains(item)) {
                        collectingItems.add(item);
                        collectingItems.remove(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < collectingItems.size(); i++) {
            if (i == collectingItems.size() - 1) {
                System.out.print(collectingItems.get(i));
            } else {
                System.out.print(collectingItems.get(i) + ", ");
            }
        }
    }
}
