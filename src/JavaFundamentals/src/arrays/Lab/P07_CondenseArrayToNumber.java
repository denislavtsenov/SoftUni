package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        while (numbers.length > 1) {
            int[] condensed = new int[numbers.length - 1];
            for (int i = 0; i <= condensed.length - 1; i++) {
                condensed[i] = numbers[i] + numbers[i + 1];

            }
            numbers = condensed;

        }
        System.out.println(numbers[0]);
    }
}

