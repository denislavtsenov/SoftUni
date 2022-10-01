package Lab;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        String password = scan.nextLine();

        String input = scan.nextLine();

        while (!input.equals(password)) {
            input = scan.nextLine();
        }
        System.out.printf("Welcome %s!", name);
    }
}
