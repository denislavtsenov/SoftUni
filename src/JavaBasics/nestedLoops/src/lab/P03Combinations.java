package LAB;

import java.util.Scanner;

public class P03Combinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int result = 0;
        int count = 0;

        for (int x1 = 0; x1 <= num; x1++) {
            for (int x2 = 0; x2 <= num ; x2++) {
                for (int x3 = 0; x3 <= num ; x3++) {
                    result = x1 + x2 + x3;

                    if(result == num) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
