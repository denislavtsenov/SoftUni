package LAB;

import java.util.Scanner;

public class P02NumbersNto1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for(int num = n; num >= 1; --num ) {
            System.out.println(num);
        }
    }
}
