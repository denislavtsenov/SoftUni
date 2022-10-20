package JavaAdvanced.src.generics.genericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            box.getCollection().add(Integer.parseInt(scanner.nextLine()));
        }
        int[] indexes = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box.swapper(box.getCollection(), indexes[0], indexes[1]);
        System.out.println(box.toString());
    }
}
