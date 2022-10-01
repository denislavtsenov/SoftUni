package Methods.Exercise;

import java.util.Scanner;

public class P03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        printCharactersInRange(first,second);
    }


    public static void printCharactersInRange(char first, char second) {
        int firstChar = Math.min(first, second);
        int secondChar = Math.max(first, second);

        for (int i = firstChar + 1; i < secondChar; i++) {
            System.out.print((char) i + " ");
        }
    }
}
