package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            int number = array[i];

            if (number % 2 == 0) {
                sum += number;
            }
        }
        System.out.println(sum);
    }
}

