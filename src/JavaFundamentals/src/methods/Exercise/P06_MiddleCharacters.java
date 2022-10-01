package Methods.Exercise;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        middleCharacters(input);
    }

    public static void middleCharacters(String input) {
        String[] arr = input.split("");

        if (input.length() % 2 == 0) {
            System.out.print(arr[input.length() / 2 - 1] + arr[input.length() / 2]);

        } else {
            System.out.println(arr[input.length() / 2]);
        }
    }
}

