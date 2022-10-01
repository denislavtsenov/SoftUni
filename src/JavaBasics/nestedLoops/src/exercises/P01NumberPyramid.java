package EXERCISE;

import java.util.Scanner;

public class P01NumberPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int currentNum = 0;

        for (int r = 1; r <= n; r++) {
            for (int c = 0; c < r; c++) {
                currentNum++;

                if (currentNum > n) {
                    return;
                }
                System.out.print(currentNum + " ");
            }
            System.out.println();
        }
    }
}
