package Methods.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbers = Math.abs(Integer.parseInt(scan.nextLine()));

        System.out.println(getMultiplyEvensByOdds(numbers));
    }

    public static int sumEven(int numbers) {
        int sumEven = 0;
        String intToString = Integer.toString(numbers);

        int[] arr = Arrays.stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < intToString.length(); i++) {
            int num = arr[i];

            if (num % 2 == 0) {
                sumEven += num;
            }

        }
        return sumEven;
    }

    public static int sumOdd(int numbers) {
        int sumOdd = 0;
        String intToString = Integer.toString(numbers);

        int[] arr = Arrays.stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < intToString.length(); i++) {
            int num = arr[i];

            if (num % 2 == 1) {
                sumOdd += num;
            }

        }
        return sumOdd;
    }

    public static int getMultiplyEvensByOdds(int numbers) {
        int result = sumEven(numbers) * sumOdd(numbers);

        return result;
    }
}
