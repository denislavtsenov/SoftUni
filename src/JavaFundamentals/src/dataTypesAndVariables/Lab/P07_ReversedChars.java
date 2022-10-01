package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P07_ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char firstInput = scan.nextLine().charAt(0);
        char secondInput = scan.nextLine().charAt(0);
        char thirdInput = scan.nextLine().charAt(0);
        System.out.printf("%c %c %c", thirdInput, secondInput, firstInput);
    }
}