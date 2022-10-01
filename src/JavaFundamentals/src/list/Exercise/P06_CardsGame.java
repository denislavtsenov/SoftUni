package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstHand.size() > 0 && secondHand.size() > 0) {

            int first = firstHand.get(0);
            int second = secondHand.get(0);
            firstHand.remove(0);
            secondHand.remove(0);

            if (first > second) {
                firstHand.add(first);
                firstHand.add(second);

            } else if (second > first) {
                secondHand.add(second);
                secondHand.add(first);
            }
        }
        int sum = 0;
        if (firstHand.size() == 0) {
           for (int cards : secondHand) {
               sum += cards;
           }

           System.out.printf("Second player wins! Sum: %d", sum);
       } else {
            for (int cards : firstHand) {
                sum += cards;
            }
           System.out.printf("First player wins! Sum: %d", sum);
       }
    }
}
