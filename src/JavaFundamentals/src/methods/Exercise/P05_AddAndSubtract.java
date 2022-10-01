package Methods.Exercise;

import java.util.Scanner;

public class P05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractNumbers(firstNum, secondNum, thirdNum));

    }

    public static int sumTwoNum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public static int subtractNumbers(int firstNum, int secondNum, int thirdNum) {
        return sumTwoNum(firstNum, secondNum) - thirdNum;
    }
}
