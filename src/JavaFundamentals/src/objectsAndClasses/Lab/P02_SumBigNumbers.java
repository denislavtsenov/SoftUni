package ObjectsAndClasses.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class P02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = scanner.nextBigInteger();
        BigInteger secondNum = scanner.nextBigInteger();

        BigInteger sum = firstNum.add(secondNum);
        System.out.println(sum);
    }
}
