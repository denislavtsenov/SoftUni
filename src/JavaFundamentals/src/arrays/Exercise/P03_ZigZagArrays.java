package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 0; i < n; i++) {
            String[] numbers = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArr[i] = numbers[1];
                secondArr[i] = numbers[0];
            } else {
                firstArr[i] = numbers[0];
                secondArr[i] = numbers[1];
            }
        }

        System.out.println(Arrays.toString(secondArr).replace("[", "").replace("]", "").replace(",", ""));
        System.out.println(Arrays.toString(firstArr).replace("[", "").replace("]", "").replace(",", ""));
    }
}
