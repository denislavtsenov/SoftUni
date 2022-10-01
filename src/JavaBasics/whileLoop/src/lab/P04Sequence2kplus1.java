package Lab;

import java.util.Scanner;

public class P04Sequence2kplus1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int allNum = 1;

        while (allNum <= n) {
            System.out.println(allNum);
            allNum = (allNum * 2) + 1;
        }
    }
}
