package JavaOOP.encapsulation.exercise.shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        Map<String, Person> personMap = new HashMap<>();

        for (String p : people) {
            String name = p.split("=")[0];
            double money = Double.parseDouble(p.split("=")[1]);

            try {
                Person person = new Person(name, money);
                personMap.put(name, person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        Map<String, Product> productMap = new HashMap<>();

        for (String p : products) {
            String name = p.split("=")[0];
            int price = Integer.parseInt(p.split("=")[1]);

            try {
                Product product = new Product(name, price);
                productMap.put(name, product);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        String commandLine = scanner.nextLine();

        while (!"END".equals(commandLine)) {
            String personName = commandLine.split("\\s+")[0];
            String productName = commandLine.split("\\s+")[1];

            Person person = personMap.get(personName);
            Product product = productMap.get(productName);

            try {
                person.buyProduct(product);
                System.out.println(personName + " bought " + productName);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            commandLine = scanner.nextLine();
        }

        personMap.values().forEach(System.out::println);
    }
}
