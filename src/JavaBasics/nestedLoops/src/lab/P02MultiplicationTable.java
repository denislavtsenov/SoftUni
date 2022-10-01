package LAB;

import java.util.Scanner;

public class P02MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int result = 0;
        for (int first = 1; first <= 10 ; first++) {
            for (int second = 1; second <= 10 ; second++) {
                result = first * second;
                System.out.printf("%d * %d = %d%n", first, second, result);
            }
        }
    }
}
