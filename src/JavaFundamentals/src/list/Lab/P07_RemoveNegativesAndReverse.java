package List.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbersList.size(); i++) {
            int currentNum = numbersList.get(i);

            if (currentNum < 0 ) {
                numbersList.remove(i);
                i = -1;
            }
        }
        if (numbersList.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbersList);
            for (int num : numbersList) {
                System.out.print(num + " ");
            }
        }
    }
}
