package EXERCISES;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int r = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        double totalPrice = 0;
        switch (type) {
            case "Premiere":
                totalPrice = r * c * 12;
                System.out.printf("%.2f leva", totalPrice);
                break;
            case "Normal":
                totalPrice = r * c * 7.50;
                System.out.printf("%.2f leva", totalPrice);
                break;
            case "Discount": {
                    totalPrice = r * c * 5.00;
                    System.out.printf("%.2f leva", totalPrice);
                    break;
                }

        }
    }
}
