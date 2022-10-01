package Methods.LAB;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number1 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int number2 = Integer.parseInt(scan.nextLine());
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(calculate(number1,operator,number2)));


    }

    public static double calculate(int number1, String operator, int number2) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = addNumbers(number1, number2);
                break;
            case "-":
               result = subtractionNumbers(number1, number2);
                break;
            case "/":
                result = divisionNumbers(number1, number2);
                break;
            case "*":
                result = multiplyNumbers(number1, number2);
                break;
        }
        return  result;
    }

    public static double addNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public static double multiplyNumbers(int number1, int number2) {
        return number1 * number2;
    }

    public static double subtractionNumbers(int number1, int number2) {
        return number1 - number2;
    }

    public static double divisionNumbers(int number1, int number2) {
        return number1 / number2;
    }
}