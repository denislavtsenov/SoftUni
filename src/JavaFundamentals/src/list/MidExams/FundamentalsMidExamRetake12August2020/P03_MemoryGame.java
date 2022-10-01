package List.MidExams.FundamentalsMidExamRetake12August2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MemoryGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> numberList = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = sc.nextLine();

        int moves = 0;
        while (!input.equals("end")) {
            moves++;
            List<String> indexes = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            int firstIndex = Integer.parseInt(indexes.get(0));
            int secondIndex = Integer.parseInt(indexes.get(1));

            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex >= numberList.size() || secondIndex < 0 || secondIndex >= numberList.size()) {
                int middleOfList = numberList.size() /2;
                numberList.add(middleOfList, "-" + moves + "a" );
                numberList.add(middleOfList, "-" + moves + "a" );
                System.out.println("Invalid input! Adding additional elements to the board");

            } else if (numberList.get(firstIndex).equals(numberList.get(secondIndex))) {
                String value = numberList.get(firstIndex);
                if (firstIndex > secondIndex) {
                    numberList.remove(firstIndex);
                    numberList.remove(secondIndex);
                } else {
                    numberList.remove(secondIndex);
                    numberList.remove(firstIndex);
                }
                System.out.printf("Congrats! You have found matching elements - %s!%n", value);
            } else if (!numberList.get(firstIndex).equals(numberList.get(secondIndex))) {
                System.out.println("Try again!");
            } if (numberList.isEmpty()) {
                System.out.printf("You have won in %d turns!", moves);
                return;

            }
            input = sc.nextLine();
        }

        System.out.println("Sorry you lose :(");
        System.out.println(numberList.toString().replace("[", "").replace("]", "").replace(",", ""));
    }
}
