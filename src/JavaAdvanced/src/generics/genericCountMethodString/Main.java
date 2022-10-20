package JavaAdvanced.src.generics.genericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            box.getCollection().add(scanner.nextLine());
        }

        String element = scanner.nextLine();

        int count = Box.compare(box.getCollection(), element);

        System.out.println(count);
    }
}
