package Arrays.Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstArray = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArray = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumOfArr = 0;
        int numOfIteration = 0;
        boolean isDiffertent = false;
        for (int i = 0; i <= firstArray.length - 1; i++) {
            if (firstArray[i] == secondArray[i]) {
                sumOfArr += firstArray[i];
            } else {
                numOfIteration = i;
                isDiffertent = true;
                break;
            }
        }
         if (isDiffertent) {
             System.out.printf("Arrays are not identical. Found difference at %d index.", numOfIteration);
         } else {
             System.out.printf("Arrays are identical. Sum: %d", sumOfArr);
         }
    }
}
