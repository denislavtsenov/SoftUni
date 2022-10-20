package JavaAdvanced.src.iteratorsAndComparators.listyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> data = Arrays.stream(scanner.nextLine().split(" "))
                .skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListIterator listIterator = new ListIterator(data);

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            switch (line) {
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.print());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
            }

            line = scanner.nextLine();
        }
    }
}

