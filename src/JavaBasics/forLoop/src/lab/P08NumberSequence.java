package LAB;

import java.util.Scanner;

public class P08NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (num < smallest) {
                smallest = num;
            }
            if (num > biggest) {
                biggest = num;
            }


        }
        System.out.printf("Max number: %d%n", biggest);
        System.out.printf("Min number: %d", smallest);
    }

}
