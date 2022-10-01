package Lab;

import java.util.Scanner;

public class P01ReadText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        while (!command.equals("Stop")) {
            System.out.println(command);
            command = scan.nextLine();

        }
    }
}
