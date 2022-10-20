package JavaAdvanced.src.generics.genericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            box.getCollection().add(Double.parseDouble(scanner.nextLine()));
        }

        double element = Double.parseDouble(scanner.nextLine());

        int count = Box.compare(box.getCollection(), element);

        System.out.println(count);
    }
}
