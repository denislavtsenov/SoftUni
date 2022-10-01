package BasicSyntaxConditionalStatementsAndLoops.LAB.Exercise;

import java.util.Scanner;

public class P05_Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = scan.nextLine();
        String inputPass = scan.nextLine();

        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char currentSymbol = username.charAt(i);
            password = password + currentSymbol;
        }
        int count = 0;
        while (!inputPass.equals(password)) {
            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            inputPass = scan.nextLine();
        }
        System.out.printf("User %s logged in.", username);
    }
}
