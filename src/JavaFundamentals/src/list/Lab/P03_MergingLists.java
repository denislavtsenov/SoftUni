package List.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        int listMinSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < listMinSize; i++) {
            int firstItem = firstList.get(i);
            int secondItem = secondList.get(i);

            resultList.add(firstItem);
            resultList.add(secondItem);
        }

        if (firstList.size() > secondList.size()) {
            resultList.addAll(firstList.subList(listMinSize, firstList.size()));
        } else {
            resultList.addAll(secondList.subList(listMinSize, secondList.size()));
        }

        for (int num : resultList) {
            System.out.print(num + " ");
        }
    }
}
