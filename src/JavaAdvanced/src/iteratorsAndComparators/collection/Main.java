package JavaAdvanced.src.iteratorsAndComparators.collection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] lines = scanner.nextLine().split("\\s+");
        ListyIterator listyIterator = new ListyIterator();

        listyIterator.create(lines);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            switch (command) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();
        }
    }
}