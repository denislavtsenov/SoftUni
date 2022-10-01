package Methods.Exercise;

import java.util.Scanner;

public class P04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (passwordValidator(password)) {
            System.out.println("Password is valid");
        }

    }

    public static boolean passwordValidator(String password) {
        boolean passwordIsValidLength = false;

        if (password.length() >= 6 && password.length() <= 10) {
            passwordIsValidLength = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean passwordIsLettersAndDigits = false;
        char[] arr = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = arr[i];
            if (Character.isLetterOrDigit(currentSymbol)) {
                passwordIsLettersAndDigits = true;
            } else {
                System.out.println("Password must consist only of letters and digits");
                passwordIsLettersAndDigits = false;
                break;
            }
        }
        boolean passwordIsValidDigits = false;
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = arr[i];
            if (Character.isDigit(currentSymbol)) {
                countDigits++;
            }
        }
        if (countDigits >= 2) {
            passwordIsValidDigits = true;
        } else {
            System.out.println("Password must have at least 2 digits");
        }

        boolean passwordIsValid = false;

        if (passwordIsLettersAndDigits && passwordIsValidLength && passwordIsValidDigits) {
            passwordIsValid = true;
        }
        return passwordIsValid;
    }
}
