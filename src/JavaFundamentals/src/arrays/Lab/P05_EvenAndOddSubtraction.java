package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i <= numArr.length - 1; i++) {
            int numbers = numArr[i];

            if (numbers % 2 == 0) {
                sumEven += numbers;
            } else {
                sumOdd += numbers;
            }
        }
        int diff = sumEven - sumOdd;
        System.out.println(diff);
    }
}
