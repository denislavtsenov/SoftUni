package Arrays.Exercise;

import java.util.Scanner;

public class P02_CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");

        for (int i = 0; i <= secondArr.length - 1; i++) {
            String currentSecondInput = secondArr[i];
            for (int j = 0; j <= firstArr.length - 1; j++) {
                String currentFirstInput = firstArr[j];
                if (currentSecondInput.equals(currentFirstInput)) {
                    System.out.print(currentFirstInput + " ");
                }
            }
        }
    }
}

