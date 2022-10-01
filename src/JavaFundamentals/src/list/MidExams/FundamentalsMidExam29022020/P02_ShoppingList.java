package List.MidExams.FundamentalsMidExam29022020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShoppingList {
    public static <initialArr> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialArr = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            List<String> commands = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            String command = commands.get(0);
            String product = commands.get(1);

            switch (command) {
                case "Urgent":
                    if (initialArr.contains(product)) {

                    } else {
                        initialArr.add(0, product);
                    }
                    break;

                case "Unnecessary":
                    if (initialArr.contains(product)) {
                        initialArr.remove(product);
                    }
                    break;

                case "Correct":
                    String oldItem = commands.get(1);
                    String newItem = commands.get(2);
                    int indexOfOldItem = initialArr.indexOf(oldItem);
                    if (initialArr.contains(oldItem)) {
                        initialArr.set(indexOfOldItem, newItem);
                    }
                    break;

                case "Rearrange":
                    if (initialArr.contains(product)) {
                        String current = product;
                        initialArr.remove(product);
                        initialArr.add(current);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < initialArr.size(); i++) {
            if (i == initialArr.size() - 1) {
                System.out.print(initialArr.get(i));
            } else {
                System.out.print(initialArr.get(i) + ", ");
            }
        }
    }

}
