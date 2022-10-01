package LAB;

import java.util.Scanner;

public class P01Clock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int h = 0; h <= 23 ; h++) {
            for (int m = 0; m <= 59; m++) {
                System.out.printf("%d:%d%n", h, m);
            }

        }
    }
}
