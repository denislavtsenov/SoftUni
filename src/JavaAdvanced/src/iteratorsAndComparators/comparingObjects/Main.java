package JavaAdvanced.src.iteratorsAndComparators.comparingObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayList<Person> people = new ArrayList<>();

        while (!input.equals("END")) {

            String[] tokens = input.split(" ");

            Person p = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(p);

            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());

        Person comparePerson = people.get(n - 1);

        int equalPeople = (int) people.stream()
                .filter(p -> p.compareTo(comparePerson) == 0)
                .count();

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", equalPeople, people.size() - equalPeople, people.size()));
        }
    }
}
